package com.api.marketingManager.api.infrastructure.persistence.jdbc.queries;

public class ContratoQuery {

    public static final String CONTRATO_SELECT_QUERY =  "SELECT id_contrato," +
                                                        " dta_inicio," +
                                                        " dta_fim," +
                                                        " valor_contrato," +
                                                        " des_contrato," +
                                                        " cnpj_contratante," +
                                                        " id_tipo_contrato" +
                                                        " FROM contratos ";

    public static final String CONTRATO_INSERT_QUERY =  "INSERT INTO contratos (" +
                                                        " id_contrato," +
                                                        " dta_inicio," +
                                                        " dta_fim," +
                                                        " valor_contrato," +
                                                        " des_contrato," +
                                                        " cnpj_contratante," +
                                                        " id_tipo_contrato)" +
                                                        " VALUES (?,?,?,?,?,?,?) ";

    public static final String CONTRATO_UPDATE_QUERY =  "UPDATE contrato SET " +
                                                        " dta_inicio = ?," +
                                                        " dta_fim = ?," +
                                                        " valor_contrato = ?," +
                                                        " des_contrato = ?," +
                                                        " cnpj_contratante = ?," +
                                                        " id_tipo_contrato = ? " +
                                                        " WHERE id_contrato = ? ";

    public static final String CONTRATO_DELETE_QUERY = "DELETE FROM contratos WHERE id_contrato = ?";
}
