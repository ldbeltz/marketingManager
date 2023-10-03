package com.api.marketingManager.api.application;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;

import java.util.List;


public interface PessoaFacade {

    PessoaModel save(PessoaModel pessoaModel);

    PessoaModel findById(Long id);

    PessoaModel findByCNPJ(String CNPJ);

    PessoaModel findByCPF(String CPF);

    List<PessoaModel> findAll();

    PessoaModel update(PessoaModel pessoaModel);

    void delete(PessoaModel pessoaModel);
}
