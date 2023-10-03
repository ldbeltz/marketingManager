package com.api.marketingManager.api.application;

import com.api.marketingManager.api.domain.model.contrato.ContratoModel;

import java.util.List;

public interface ContratoFacade {

    ContratoModel save(ContratoModel contratoModel);

    ContratoModel findById(Long id);

    List<ContratoModel> findAll();

    ContratoModel update(ContratoModel contratoModel);

    void delete(ContratoModel contratoModel);
}
