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

import static com.api.marketingManager.api.infrastructure.persistence.jdbc.queries.PessoaQuery.*;

@Repository
public class JdbcPessoaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPessoaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

     public PessoaPersistence save (PessoaPersistence pessoaPersistence){
         String query = "";

         pessoaPersistence.setPessoaId(jdbcTemplate.query("SELECT nextval('pessoa_id_pessoa_seq')",
                 rs -> {
                    if (rs.next()){
                        return rs.getLong(1);
                    } else {
                        throw new SQLException("Não foi possivel efetuar o registro, erro de banco de dados.");
                    }
                 }));
         if (pessoaPersistence.getNumCpf() != null){
             query = " INSERT INTO pessoa_fisica (id_pessoa, cpf, dta_nascimento) VALUES (?, ?, ?)";
         } else {
             query = " INSERT INTO pessoa_juridica (id_pessoa, cnpj, cpf_responsavel) VALUES (?, ?, ?)";
         }
         jdbcTemplate.update(PESSOA_INSERT_QUERY + query,
                 pessoaPersistence.getPessoaId(),
                 pessoaPersistence.getNome(),
                 pessoaPersistence.getEndereco(),
                 pessoaPersistence.getNumEndereco(),
                 pessoaPersistence.getCep(),
                 pessoaPersistence.getEmail(),
                 pessoaPersistence.getDddTelefone(),
                 pessoaPersistence.getNumTelefone(),
                 pessoaPersistence.getDtaCadastro(),
                 pessoaPersistence.getPessoaId(),
                 (pessoaPersistence.getNumCpf() != null) ? pessoaPersistence.getNumCpf() : pessoaPersistence.getCnpj(),
                 (pessoaPersistence.getNumCpf() != null) ? pessoaPersistence.getDtaNascimento() : pessoaPersistence.getCpfResponsavel()
                 );
         return findById(pessoaPersistence.getPessoaId());
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

    public PessoaPersistence findById(Long id){
        try {
            return jdbcTemplate.queryForObject(PessoaQuery.PESSOA_SELECT_QUERY + " WHERE pe.id_pessoa = ?", new PessoaRowMapper(), id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public PessoaPersistence update(PessoaPersistence pessoaPersistence){
        String query = "";
        if (pessoaPersistence.getNumCpf() != null){
            query = "UPDATE pessoa_fisica SET cpf = ?, dta_nascimento = ? WHERE id_pessoa = ?";
        } else {
            query = "UPDATE pessoa_juridica SET cnpj = ?, cpf_responsavel = ? WHERE id_pessoa = ?";
        }
        jdbcTemplate.update(PESSOA_UPDATE_QUERY + query,
             pessoaPersistence.getNome(),
             pessoaPersistence.getEndereco(),
             pessoaPersistence.getNumEndereco(),
             pessoaPersistence.getCep(),
             pessoaPersistence.getEmail(),
             pessoaPersistence.getDddTelefone(),
             pessoaPersistence.getNumTelefone(),
             pessoaPersistence.getPessoaId(),
             (pessoaPersistence.getNumCpf() != null) ? pessoaPersistence.getNumCpf() : pessoaPersistence.getCnpj(),
             (pessoaPersistence.getNumCpf() != null) ?pessoaPersistence.getDtaNascimento() : pessoaPersistence.getCpfResponsavel(),
             pessoaPersistence.getPessoaId()
        );
        return findById(pessoaPersistence.getPessoaId());
    }

    public void delete(PessoaPersistence pessoaPersistence){
        jdbcTemplate.update(PESSOA_DELETE_QUERY, pessoaPersistence.getPessoaId());
    }
}
