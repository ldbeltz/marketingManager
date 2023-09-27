package com.api.marketingManager.infrastructure.persistence.jdbc;

import com.api.marketingManager.infrastructure.persistence.jdbc.rowMapper.PessoaRowMapper;
import com.api.marketingManager.infrastructure.persistence.pessoa.PessoaPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcPessoaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcPessoaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<PessoaPersistence> findAll(){
        return jdbcTemplate.query("", new PessoaRowMapper());
    }
}
