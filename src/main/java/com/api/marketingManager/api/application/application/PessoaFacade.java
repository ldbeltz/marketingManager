package com.api.marketingManager.api.application.application;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.application.dtos.PessoaDto;

import java.util.List;


public interface PessoaFacade {

    Long cadPessoa(PessoaDto pessoaDto);

    PessoaDto findPessoa(Long idPessoa);

    List<PessoaModel> findAll();
}
