package com.api.marketingManager.api.infrastructure.persistence.jdbc;

import com.api.marketingManager.api.infrastructure.persistence.jdbc.queries.PessoaQuery;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.rowMapper.PessoaRowMapper;
import com.api.marketingManager.api.infrastructure.persistence.pessoa.PessoaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
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
}
