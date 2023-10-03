package com.api.marketingManager.api.domain.model.contrato;
import com.api.marketingManager.api.domain.model.pessoa.PessoaModel;

import java.time.LocalDate;

public class ContratoModel {

    private Long idContrato;
    private LocalDate dtaInicio;
    private LocalDate dtaFim;
    private float valorContrato;
    private String desContrato;
    private String cnpjContratante;
    private int idTipoContrato;

    public ContratoModel() {
    }

    public ContratoModel(Long idContrato, LocalDate dtaInicio, LocalDate dtaFim, float valorContrato, String desContrato, String cnpjContratante, int idTipoContrato) {
        this.idContrato = idContrato;
        this.dtaInicio = dtaInicio;
        this.dtaFim = dtaFim;
        this.valorContrato = valorContrato;
        this.desContrato = desContrato;
        this.cnpjContratante = cnpjContratante;
        this.idTipoContrato = idTipoContrato;
    }

    public Long getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Long idContrato) {
        this.idContrato = idContrato;
    }

    public LocalDate getDtaInicio() {
        return dtaInicio;
    }

    public void setDtaInicio(LocalDate dtaInicio) {
        this.dtaInicio = dtaInicio;
    }

    public LocalDate getDtaFim() {
        return dtaFim;
    }

    public void setDtaFim(LocalDate dtaFim) {
        this.dtaFim = dtaFim;
    }

    public float getValorContrato() {
        return valorContrato;
    }

    public void setValorContrato(float valorContrato) {
        this.valorContrato = valorContrato;
    }

    public String getDesContrato() {
        return desContrato;
    }

    public void setDesContrato(String desContrato) {
        this.desContrato = desContrato;
    }

    public String getCnpjContratante() {
        return cnpjContratante;
    }

    public void setCnpjContratante(String cnpjContratante) {
        this.cnpjContratante = cnpjContratante;
    }

    public int getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(int idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }
}
