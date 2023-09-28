package com.api.marketingManager.domain.model.pessoa;

import java.util.UUID;

public class PessoaModel {
    private Long pessoaId;
    private String nome;
    private String endereco;
    private int numEndereco;
    private String cep;
    private String email;
    private int dddTelefone;
    private int numTelefone;

    public PessoaModel(Long pessoaId, String nome, String endereco, int numEndereco, String cep, String email, int dddTelefone, int numTelefone) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.cep = cep;
        this.email = email;
        this.dddTelefone = dddTelefone;
        this.numTelefone = numTelefone;
    }

    public Long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(Long pessoaId) {
        this.pessoaId = pessoaId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumEndereco() {
        return numEndereco;
    }

    public void setNumEndereco(int numEndereco) {
        this.numEndereco = numEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDddTelefone() {
        return dddTelefone;
    }

    public void setDddTelefone(int dddTelefone) {
        this.dddTelefone = dddTelefone;
    }

    public int getNumTelefone() {
        return numTelefone;
    }

    public void setNumTelefone(int numTelefone) {
        this.numTelefone = numTelefone;
    }
}
