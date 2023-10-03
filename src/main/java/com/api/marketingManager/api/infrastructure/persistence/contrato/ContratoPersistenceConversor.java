package com.api.marketingManager.api.infrastructure.persistence.contrato;

import com.api.marketingManager.api.domain.model.contrato.ContratoModel;
import com.api.marketingManager.api.infrastructure.persistence.pessoa.PessoaPersistenceConversor;

import java.util.List;
import java.util.stream.Collectors;

public class ContratoPersistenceConversor {

    public static ContratoModel toModel(ContratoPersistence contratoPersistence) {
        return new ContratoModel(contratoPersistence.getIdContrato(),
                contratoPersistence.getDtaInicio(),
                contratoPersistence.getDtaFim(),
                contratoPersistence.getValorContrato(),
                contratoPersistence.getDesContrato(),
                contratoPersistence.getCnpjContratante(),
                contratoPersistence.getIdTipoContrato()
        );
    }

    public static ContratoPersistence toPersistence(ContratoModel contratoModel){
        return new ContratoPersistence(contratoModel.getIdContrato(),
                contratoModel.getDtaInicio(),
                contratoModel.getDtaFim(),
                contratoModel.getValorContrato(),
                contratoModel.getDesContrato(),
                contratoModel.getCnpjContratante(),
                contratoModel.getIdTipoContrato()
        );
    }
    public static List<ContratoModel> toModelList(List<ContratoPersistence> contratos){
        return contratos.stream()
                .map(ContratoPersistenceConversor::toModel)
                .collect(Collectors.toList());
    }
}
