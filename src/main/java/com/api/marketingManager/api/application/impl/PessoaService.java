package com.api.marketingManager.api.application.impl;

import com.api.marketingManager.api.application.PessoaFacade;
import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.domain.model.pessoa.PessoaRepository;
import com.api.marketingManager.api.view.dtos.PessoaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PessoaService implements PessoaFacade {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public PessoaModel save(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);    }

    public PessoaModel findByCPF(String CPF) {
        return pessoaRepository.findByCPF(CPF);
    }

    public PessoaModel findByCNPJ(String CNPJ) {
        return pessoaRepository.findByCNPJ(CNPJ);
    }

    public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }
}
