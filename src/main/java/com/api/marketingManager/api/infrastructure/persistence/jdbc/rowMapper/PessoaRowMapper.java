package com.api.marketingManager.api.infrastructure.persistence.jdbc.rowMapper;

import com.api.marketingManager.api.infrastructure.persistence.pessoa.PessoaPersistence;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.api.marketingManager.base.utils.DateUtils.dateSqlToLocalDate;

public class PessoaRowMapper implements RowMapper<PessoaPersistence> {
    @Override
    public PessoaPersistence mapRow(ResultSet resultSet, int i) throws SQLException{

        return new PessoaPersistence(resultSet.getLong("ID_PESSOA"),
                resultSet.getString("NOME_PESSOA"),
                resultSet.getString("ENDERECO"),
                resultSet.getInt("NUM_ENDERECO"),
                resultSet.getInt("CEP"),
                resultSet.getString("EMAIL"),
                resultSet.getInt("DDD_TELEFONE"),
                resultSet.getInt("NUM_TELEFONE"),
                resultSet.getString("CPF"),
                dateSqlToLocalDate(resultSet.getDate("DTA_NASCIMENTO")),
                resultSet.getString("CNPJ"),
                dateSqlToLocalDate(resultSet.getDate("DTA_CADASTRO")),
                resultSet.getString("CPF_RESPONSAVEL")
        );
    }

}
