package com.api.marketingManager.api.domain.model.pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository {

    PessoaModel save(PessoaModel pessoaModel);
    PessoaModel findByCPF(String CPF);

    PessoaModel findByCNPJ(String CNPJ);

    List<PessoaModel> findAll();


}
