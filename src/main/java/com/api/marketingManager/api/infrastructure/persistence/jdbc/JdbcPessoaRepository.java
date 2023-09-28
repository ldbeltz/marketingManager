package com.api.marketingManager.api.infrastructure.persistence.jdbc;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.queries.PessoaQuery;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.rowMapper.PessoaRowMapper;
import com.api.marketingManager.api.infrastructure.persistence.pessoa.PessoaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static com.api.marketingManager.api.infrastructure.persistence.jdbc.queries.PessoaQuery.PESSOA_INSERT_QUERY;

@Repository
public class JdbcPessoaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPessoaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public void save (PessoaPersistence pessoaPersistence){
       //TODO
        /* String query = "";
        if (pessoaPersistence.getCep() != null){
            query = " INSERT INTO pessoa_fisica (id_pessoa, cpf, dta_nascimento) VALUES (SELECT last_inserted_id(), ?, ?)";
        } else {
            query = " INSERT INTO pessoa_juridica (id_pessoa, cnpj, dta_cadastro, cpf_responsavel) VALUES (SELECT last_inserted_id(), ?, ?, ?)";
        }

        jdbcTemplate.update(PESSOA_INSERT_QUERY + query)
        int[] arr = jdbcTemplate.batchUpdate(PESSOA_INSERT_QUERY + query, new BatchPreparedStatementSetter() {
            @Override

            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setObject(1, pessoaPersistence.getNome());
                ps.setObject(2, pessoaPersistence.getEndereco());
                ps.setObject(3, pessoaPersistence.getNumEndereco());
                ps.setObject(4, pessoaPersistence.getCep());
                ps.setObject(5, pessoaPersistence.getEmail());
                ps.setObject(6, pessoaPersistence.getDddTelefone());
                ps.setObject(7, pessoaPersistence.getNumTelefone());
                if (pessoaPersistence.getCep() != null){
                    ps.setObject(8, pessoaPersistence.getNumCpf());
                    ps.setObject(9, pessoaPersistence.getDtaNascimento());
                } else {
                    ps.setObject(8, pessoaPersistence.getCnpj());
                    ps.setObject(9, pessoaPersistence.getDtaCadastro());
                    ps.setObject(10, pessoaPersistence.getCpfResponsavel());
                }
                ps.executeUpdate();
            }
            @Override
            public int getBatchSize() {
                return 0;
            }
        });
       /* if (pessoaPersistence.getCep() != null){
            return findByCPF(pessoaPersistence.getNumCpf());
        } else {
            return findByCNPJ(pessoaPersistence.getCnpj());
        }*/
    }
    public List<PessoaPersistence> findAll(){
        return jdbcTemplate.query(PessoaQuery.PESSOA_SELECT_QUERY, new PessoaRowMapper());
    }

    public PessoaPersistence findByCPF(String CPF){
        try {
            return jdbcTemplate.queryForObject(PessoaQuery.PESSOA_SELECT_QUERY + " WHERE CPF = ?", new PessoaRowMapper(), CPF);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public PessoaPersistence findByCNPJ(String CNPJ){
        try {
            return jdbcTemplate.queryForObject(PessoaQuery.PESSOA_SELECT_QUERY + " WHERE CNPJ = ?", new PessoaRowMapper(), CNPJ);
        } catch (EmptyResultDataAccessException e){
           return null;
        }

    }
}
