package com.api.marketingManager.api.domain.model.pessoa;

import java.util.List;

public interface PessoaRepository {

    PessoaModel findPessoa(Long idPessoa);

    List<PessoaModel> findAll();


}
