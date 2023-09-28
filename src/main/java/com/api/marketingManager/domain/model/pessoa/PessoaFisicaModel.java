package com.api.marketingManager.domain.model.pessoa;

import java.time.LocalDate;

public class PessoaFisicaModel extends PessoaModel{
    private String numCpf;
    private LocalDate dtaNascimento;

    public PessoaFisicaModel(Long pessoaId, String nome, String endereco, int numEndereco, String cep, String email, int dddTelefone, int numTelefone) {
        super(pessoaId, nome, endereco, numEndereco, cep, email, dddTelefone, numTelefone);
    }

    public String getNumCpf() {
        return numCpf;
    }

    public void setNumCpf(String numCpf) {
        this.numCpf = numCpf;
    }

    public LocalDate getDtaNascimento() {
        return dtaNascimento;
    }

    public void setDtaNascimento(LocalDate dtaNascimento) {
        this.dtaNascimento = dtaNascimento;
    }
}
