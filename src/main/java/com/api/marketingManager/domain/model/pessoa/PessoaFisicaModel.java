package com.api.marketingManager.domain.model.pessoa;

import java.time.LocalDate;

public class PessoaFisicaModel extends PessoaModel{
    private String numCpf;
    private LocalDate dtaNascimento;

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
