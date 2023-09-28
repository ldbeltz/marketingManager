package com.api.marketingManager.domain.model.pessoa;

import java.time.LocalDate;

public class PessoaJuridicaModel extends PessoaModel{
    private String cnpj;
    private LocalDate dtaCadastro;
    private String cpfResponsavel;

    public PessoaJuridicaModel(Long pessoaId, String nome, String endereco, int numEndereco, String cep, String email, int dddTelefone, int numTelefone) {
        super(pessoaId, nome, endereco, numEndereco, cep, email, dddTelefone, numTelefone);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public LocalDate getDtaCadastro() {
        return dtaCadastro;
    }

    public void setDtaCadastro(LocalDate dtaCadastro) {
        this.dtaCadastro = dtaCadastro;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getIdContaBancaria() {
        return idContaBancaria;
    }

    public void setIdContaBancaria(int idContaBancaria) {
        this.idContaBancaria = idContaBancaria;
    }

    private int idStatus;
    private int idContaBancaria;
}
