package com.api.marketingManager.api.application;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.view.dtos.PessoaDto;

import java.util.List;
import java.util.Optional;


public interface PessoaFacade {

    PessoaModel save(PessoaModel pessoaModel);

    PessoaModel findById(Long id);

    PessoaModel findByCNPJ(String CNPJ);

    PessoaModel findByCPF(String CPF);

    List<PessoaModel> findAll();

    PessoaModel update(PessoaModel pessoaModel);

    void delete(PessoaModel pessoaModel);
}
