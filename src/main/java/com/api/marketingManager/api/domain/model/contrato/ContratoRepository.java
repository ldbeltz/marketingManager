package com.api.marketingManager.api.domain.model.contrato;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;

import java.util.List;

public interface ContratoRepository {

    ContratoModel save(ContratoModel contratoModel);

    ContratoModel findById(Long id);

    List<ContratoModel> findAll();

    ContratoModel update(ContratoModel contratoModel);

    void delete(ContratoModel contratoModel);
}
