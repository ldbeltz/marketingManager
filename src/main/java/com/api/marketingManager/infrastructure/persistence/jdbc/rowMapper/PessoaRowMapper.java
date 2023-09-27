package com.api.marketingManager.infrastructure.persistence.jdbc.rowMapper;

import com.api.marketingManager.infrastructure.persistence.pessoa.PessoaPersistence;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaRowMapper implements RowMapper<PessoaPersistence> {

    public PessoaPersistence mapRow(ResultSet resultSet, int i) throws SQLException{
        return null;
    }

}
