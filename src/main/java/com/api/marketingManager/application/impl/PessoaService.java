package com.api.marketingManager.application.impl;

import com.api.marketingManager.application.PessoaFacade;
import com.api.marketingManager.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.domain.model.pessoa.PessoaRepository;
import com.api.marketingManager.dtos.PessoaDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PessoaService implements PessoaFacade {
    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Long cadPessoa(PessoaDto pessoaDto) {
        return null;
    }

    public PessoaDto findPessoa(Long idPessoa) {
        return null;
    }

    public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }
}
