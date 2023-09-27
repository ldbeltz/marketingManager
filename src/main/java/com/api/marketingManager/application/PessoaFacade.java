package com.api.marketingManager.application;

import com.api.marketingManager.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.dtos.PessoaDto;

import java.util.List;


public interface PessoaFacade {

    Long cadPessoa(PessoaDto pessoaDto);

    PessoaDto findPessoa(Long idPessoa);

    List<PessoaModel> findAll();
}
