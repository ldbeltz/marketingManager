package com.api.marketingManager.api.infrastructure.persistence;

import com.api.marketingManager.api.domain.model.contrato.ContratoModel;
import com.api.marketingManager.api.domain.model.contrato.ContratoRepository;
import com.api.marketingManager.api.infrastructure.persistence.contrato.ContratoPersistence;
import com.api.marketingManager.api.infrastructure.persistence.contrato.ContratoPersistenceConversor;
import com.api.marketingManager.api.infrastructure.persistence.jdbc.JdbcContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContratoRepositoryPostgres implements ContratoRepository {

    private final JdbcContratoRepository jdbcContratoRepository;

    @Autowired
    public ContratoRepositoryPostgres(JdbcContratoRepository jdbcContratoRepository) {
        this.jdbcContratoRepository = jdbcContratoRepository;
    }

    public ContratoModel save(ContratoModel contratoModel){
        return ContratoPersistenceConversor.toModel(jdbcContratoRepository.save(ContratoPersistenceConversor.toPersistence(contratoModel)));
    }

    public ContratoModel findById(Long id) {
        ContratoPersistence contratoPersistence = jdbcContratoRepository.findById(id);
        return (contratoPersistence != null) ? ContratoPersistenceConversor.toModel(contratoPersistence) : null;
    }

    public List<ContratoModel> findAll() {
        return ContratoPersistenceConversor.toModelList(jdbcContratoRepository.findAll());
    }

    public ContratoModel update(ContratoModel contratoModel){
        return ContratoPersistenceConversor.toModel(jdbcContratoRepository.update(ContratoPersistenceConversor.toPersistence(contratoModel)));
    }

    public void delete(ContratoModel contratoModel){
        jdbcContratoRepository.delete(ContratoPersistenceConversor.toPersistence(contratoModel));
    }
}
