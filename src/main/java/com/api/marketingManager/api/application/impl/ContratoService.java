package com.api.marketingManager.api.application.impl;


import com.api.marketingManager.api.application.ContratoFacade;
import com.api.marketingManager.api.domain.model.contrato.ContratoModel;
import com.api.marketingManager.api.domain.model.contrato.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService implements ContratoFacade {
    private final ContratoRepository contratoRepository;

    @Autowired
    public ContratoService(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    public ContratoModel save(ContratoModel contratoModel) {
        return contratoRepository.save(contratoModel);    }

    public ContratoModel findById(Long id) {
        return contratoRepository.findById(id);
    }

    public List<ContratoModel> findAll() {
        return contratoRepository.findAll();
    }

    public ContratoModel update(ContratoModel contratoModel){
        return contratoRepository.update(contratoModel);
    }

    public void delete(ContratoModel contratoModel){
        contratoRepository.delete(contratoModel);
    }
}
