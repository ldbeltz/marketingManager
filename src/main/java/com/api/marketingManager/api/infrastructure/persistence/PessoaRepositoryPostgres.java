package com.api.marketingManager.api.infrastructure.persistence;

import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;
import com.api.marketingManager.api.domain.model.pessoa.PessoaRepository;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.JdbcPessoaRepository;
import com.api.marketingManager.api.infrastructure.persistence.pessoa.PessoaPersistenceConversor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PessoaRepositoryPostgres implements PessoaRepository {

    private final JdbcPessoaRepository jdbcPessoaRepository;

    @Autowired
    public PessoaRepositoryPostgres(JdbcPessoaRepository jdbcPessoaRepository) {
        this.jdbcPessoaRepository = jdbcPessoaRepository;
    }

    public PessoaModel findPessoa(Long idPessoa) {
        return null;
    }

    public List<PessoaModel> findAll() {
        return PessoaPersistenceConversor.toModelList(jdbcPessoaRepository.findAll());
    }
}
