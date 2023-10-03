package com.api.marketingManager.api.infrastructure.persistence.jdbc;

import com.api.marketingManager.api.infrastructure.persistence.contrato.ContratoPersistence;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.rowMapper.ContratoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

import static com.api.marketingManager.api.infrastructure.persistence.jdbc.queries.ContratoQuery.*;

@Repository
public class JdbcContratoRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcContratoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public ContratoPersistence save (ContratoPersistence contratoPersistence){

        contratoPersistence.setIdContrato(jdbcTemplate.query("SELECT nextval('seq_contratos')",
                rs -> {
                    if (rs.next()){
                        return rs.getLong(1);
                    } else {
                        throw new SQLException("Não foi possivel efetuar o registro, erro de banco de dados.");
                    }
                }));
        jdbcTemplate.update(CONTRATO_INSERT_QUERY,
                contratoPersistence.getIdContrato(),
                contratoPersistence.getDtaInicio(),
                contratoPersistence.getDtaFim(),
                contratoPersistence.getValorContrato(),
                contratoPersistence.getDesContrato(),
                contratoPersistence.getCnpjContratante(),
                contratoPersistence.getIdTipoContrato()
        );
        return findById(contratoPersistence.getIdContrato());
    }
    public List<ContratoPersistence> findAll(){
        return jdbcTemplate.query(CONTRATO_SELECT_QUERY, new ContratoRowMapper());
    }

    public ContratoPersistence findById(Long id){
        try {
            return jdbcTemplate.queryForObject(CONTRATO_SELECT_QUERY + " WHERE id_contrato = ?", new ContratoRowMapper(), id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public ContratoPersistence update(ContratoPersistence contratoPersistence){
        jdbcTemplate.update(CONTRATO_UPDATE_QUERY,
                contratoPersistence.getDtaInicio(),
                contratoPersistence.getDtaFim(),
                contratoPersistence.getValorContrato(),
                contratoPersistence.getDesContrato(),
                contratoPersistence.getCnpjContratante(),
                contratoPersistence.getIdTipoContrato(),
                contratoPersistence.getIdContrato()
        );
        return findById(contratoPersistence.getIdContrato());
    }

    public void delete(ContratoPersistence contratoPersistence){
        jdbcTemplate.update(CONTRATO_DELETE_QUERY, contratoPersistence.getIdContrato());
    }
}
