package com.api.marketingManager.api.infrastructure.persistence.jdbc;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.queries.PessoaQuery;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.rowMapper.PessoaRowMapper;
import com.api.marketingManager.api.infrastructure.persistence.pessoa.PessoaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcPessoaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPessoaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
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
