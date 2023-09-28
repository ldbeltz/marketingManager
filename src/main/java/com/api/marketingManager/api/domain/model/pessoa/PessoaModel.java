package com.api.marketingManager.api.domain.model.pessoa;

import java.time.LocalDate;
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
    private String numCpf;
    private LocalDate dtaNascimento;
    private String cnpj;
    private LocalDate dtaCadastro;
    private String cpfResponsavel;

    public PessoaModel(Long pessoaId, String nome, String endereco, int numEndereco, String cep, String email, int dddTelefone, int numTelefone, String numCpf, LocalDate dtaNascimento, String cnpj, LocalDate dtaCadastro, String cpfResponsavel) {
        this.pessoaId = pessoaId;
        this.nome = nome;
        this.endereco = endereco;
        this.numEndereco = numEndereco;
        this.cep = cep;
        this.email = email;
        this.dddTelefone = dddTelefone;
        this.numTelefone = numTelefone;
        this.numCpf = numCpf;
        this.dtaNascimento = dtaNascimento;
        this.cnpj = cnpj;
        this.dtaCadastro = dtaCadastro;
        this.cpfResponsavel = cpfResponsavel;
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
}
