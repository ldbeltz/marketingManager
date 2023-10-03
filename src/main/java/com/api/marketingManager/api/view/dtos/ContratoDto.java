package com.api.marketingManager.api.view.dtos;

import java.time.LocalDate;

public class ContratoDto {
    private LocalDate dtaInicio;
    private LocalDate dtaFim;
    private float valorContrato;
    private String desContrato;
    private String cnpjContratante;
    private int idTipoContrato;

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
