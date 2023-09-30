package com.api.marketingManager.api.infrastructure.persistence.pessoa;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaPersistenceConversor {

    public static PessoaModel toModel(PessoaPersistence pessoaPersistence) {
        return new PessoaModel(pessoaPersistence.getPessoaId(),
                pessoaPersistence.getNome(),
                pessoaPersistence.getEndereco(),
                pessoaPersistence.getNumEndereco(),
                pessoaPersistence.getCep(),
                pessoaPersistence.getEmail(),
                pessoaPersistence.getDddTelefone(),
                pessoaPersistence.getNumTelefone(),
                pessoaPersistence.getNumCpf(),
                pessoaPersistence.getDtaNascimento(),
                pessoaPersistence.getCnpj(),
                pessoaPersistence.getDtaCadastro(),
                pessoaPersistence.getCpfResponsavel()
        );
    }

    public static PessoaPersistence toPersistence(PessoaModel pessoaModel){
        return new PessoaPersistence(pessoaModel.getPessoaId(),
                pessoaModel.getNome(),
                pessoaModel.getEndereco(),
                pessoaModel.getNumEndereco(),
                pessoaModel.getCep(),
                pessoaModel.getEmail(),
                pessoaModel.getDddTelefone(),
                pessoaModel.getNumTelefone(),
                pessoaModel.getNumCpf(),
                pessoaModel.getDtaNascimento(),
                pessoaModel.getCnpj(),
                pessoaModel.getDtaCadastro(),
                pessoaModel.getCpfResponsavel()
        );
    }
    public static List<PessoaModel> toModelList(List<PessoaPersistence> pessoas){
        return pessoas.stream()
                .map(PessoaPersistenceConversor::toModel)
                .collect(Collectors.toList());
    }
}
