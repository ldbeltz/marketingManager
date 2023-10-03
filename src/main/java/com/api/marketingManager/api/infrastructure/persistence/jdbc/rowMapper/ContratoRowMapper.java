package com.api.marketingManager.api.infrastructure.persistence.jdbc.rowMapper;

import com.api.marketingManager.api.infrastructure.persistence.contrato.ContratoPersistence;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.api.marketingManager.base.utils.DateUtils.dateSqlToLocalDate;

public class ContratoRowMapper implements RowMapper<ContratoPersistence> {

    @Override
    public ContratoPersistence mapRow(ResultSet resultSet, int i) throws SQLException {
        return new ContratoPersistence(resultSet.getLong("id_contrato"),
                dateSqlToLocalDate(resultSet.getDate("dta_inicio")),
                dateSqlToLocalDate(resultSet.getDate("dta_fim")),
                resultSet.getFloat("valor_contrato"),
                resultSet.getString("des_contrato"),
                resultSet.getString("cnpj_contratante"),
                resultSet.getInt("id_tipo_contrato")
        );
    }

}
