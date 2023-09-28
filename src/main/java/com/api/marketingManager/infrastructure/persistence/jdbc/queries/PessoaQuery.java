package com.api.marketingManager.infrastructure.persistence.jdbc.queries;

public class PessoaQuery {

    public static final String PESSOA_SELECT_QUERY = "SELECT pe.ID_PESSOA, NOME_PESSOA, ENDERECO, NUM_ENDERECO, CEP," +
                                                     "EMAIL, DDD_TELEFONE, NUM_TELEFONE,CPF, DTA_NASCIMENTO,CNPJ," +
                                                     "DTA_CADASTRO,CPF_RESPONSAVEL" +
                                                     "FROM pessoa pe" +
                                                     "LEFT JOIN pessoa_fisica pf ON (pe.ID_PESSOA = pf.ID_PESSOA)" +
                                                     "LEFT JOIN pessoa_juridica pj ON (pe.ID_PESSOA = pj.ID_PESSOA)";
}
