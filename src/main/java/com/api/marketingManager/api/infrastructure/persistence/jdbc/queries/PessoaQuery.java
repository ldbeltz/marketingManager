package com.api.marketingManager.api.infrastructure.persistence.jdbc.queries;

public class PessoaQuery {

    public static final String PESSOA_SELECT_QUERY = "SELECT pe.ID_PESSOA, NOME_PESSOA, ENDERECO, NUM_ENDERECO, CEP, " +
                                                     "EMAIL, DDD_TELEFONE, NUM_TELEFONE,CPF, DTA_NASCIMENTO,CNPJ, " +
                                                     "DTA_CADASTRO,CPF_RESPONSAVEL " +
                                                     "FROM pessoa pe " +
                                                     "LEFT JOIN pessoa_fisica pf ON (pe.ID_PESSOA = pf.ID_PESSOA) " +
                                                     "LEFT JOIN pessoa_juridica pj ON (pe.ID_PESSOA = pj.ID_PESSOA) ";
    public static final String PESSOA_INSERT_QUERY = "INSERT INTO pessoa (" +
                                                     "id_pessoa," +
                                                     " nome_pessoa," +
                                                     " endereco, " +
                                                     " num_endereco," +
                                                     " cep," +
                                                     " email," +
                                                     " ddd_telefone," +
                                                     " num_telefone," +
                                                     " dta_cadastro) " +
                                                     "VALUES" +
                                                     "(?,?,?,?,?,?,?,?,?); ";
}
