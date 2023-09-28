package com.api.marketingManager.infrastructure.persistence.jdbc.rowMapper;

import com.api.marketingManager.infrastructure.persistence.pessoa.PessoaPersistence;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PessoaRowMapper implements RowMapper<PessoaPersistence> {

    public PessoaPersistence mapRow(ResultSet resultSet, int i) throws SQLException{
        return new PessoaPersistence(resultSet.getLong("ID_PESSOA"),
                                     resultSet.getString("NOME_PESSOA"),
                                     resultSet.getString("ENDERECO"),
                                     resultSet.getInt("NUM_ENDERECO"),
                                     resultSet.getString("CEP"),
                                     resultSet.getString("EMAIL"),
                                     resultSet.getInt("DDD_TELEFONE"),
                                     resultSet.getInt("NUM_TELEFONE")
                                     /*resultSet.getString("CPF"),
                                     resultSet.getDate("DTA_NASCIMENTO").toLocalDate(),// CRIAR A CLASSE DateUtils
                                     resultSet.getString("CNPJ"),
                                     resultSet.getDate("DTA_CADASTRO").toLocalDate(),
                                     resultSet.getString("CPF_RESPONSAVEL")*/
                );
    }

}
