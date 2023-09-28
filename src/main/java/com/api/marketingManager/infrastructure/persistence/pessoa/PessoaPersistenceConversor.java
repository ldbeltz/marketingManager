package com.api.marketingManager.infrastructure.persistence.pessoa;

import com.api.marketingManager.domain.model.pessoa.PessoaModel;

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
                pessoaPersistence.getNumTelefone()
        );
    }
    public static List<PessoaModel> toModelList(List<PessoaPersistence> pessoas){
        return pessoas.stream()
                .map(PessoaPersistenceConversor::toModel)
                .collect(Collectors.toList());
    }
}
