package com.api.marketingManager.api.infrastructure.persistence;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.domain.model.pessoa.PessoaRepository;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.JdbcPessoaRepository;
import com.api.marketingManager.api.infrastructure.persistence.pessoa.PessoaPersistence;
import com.api.marketingManager.api.infrastructure.persistence.pessoa.PessoaPersistenceConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PessoaRepositoryPostgres implements PessoaRepository {

    private final JdbcPessoaRepository jdbcPessoaRepository;

    @Autowired
    public PessoaRepositoryPostgres(JdbcPessoaRepository jdbcPessoaRepository) {
        this.jdbcPessoaRepository = jdbcPessoaRepository;
    }

    public PessoaModel save(PessoaModel pessoaModel){
        return PessoaPersistenceConversor.toModel(jdbcPessoaRepository.save(PessoaPersistenceConversor.toPersistence(pessoaModel)));
    }

    public PessoaModel findById(Long id) {
        PessoaPersistence pessoaPersistence = jdbcPessoaRepository.findById(id);
        return (pessoaPersistence != null) ? PessoaPersistenceConversor.toModel(pessoaPersistence) : null;
    }
    public PessoaModel findByCPF(String CPF) {
        PessoaPersistence pessoaPersistence = jdbcPessoaRepository.findByCPF(CPF);
        return (pessoaPersistence != null) ? PessoaPersistenceConversor.toModel(pessoaPersistence) : null;
    }

    public PessoaModel findByCNPJ(String CNPJ) {
        PessoaPersistence pessoaPersistence = jdbcPessoaRepository.findByCNPJ(CNPJ);
        return (pessoaPersistence != null) ? PessoaPersistenceConversor.toModel(pessoaPersistence) : null;
    }

    public List<PessoaModel> findAll() {
        return PessoaPersistenceConversor.toModelList(jdbcPessoaRepository.findAll());
    }

    public PessoaModel update(PessoaModel pessoaModel){
        return PessoaPersistenceConversor.toModel(jdbcPessoaRepository.update(PessoaPersistenceConversor.toPersistence(pessoaModel)));
    }

    public void delete(PessoaModel pessoaModel){
        jdbcPessoaRepository.delete(PessoaPersistenceConversor.toPersistence(pessoaModel));
    }
}
