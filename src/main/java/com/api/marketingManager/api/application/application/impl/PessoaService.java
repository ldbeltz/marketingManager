package com.api.marketingManager.api.application.application.impl;

import com.api.marketingManager.api.application.application.PessoaFacade;
import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.domain.model.pessoa.PessoaRepository;
import com.api.marketingManager.api.application.dtos.PessoaDto;
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
