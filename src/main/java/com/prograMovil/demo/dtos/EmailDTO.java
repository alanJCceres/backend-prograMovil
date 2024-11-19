package com.prograMovil.demo.dtos;

public class EmailDTO {
    private String destinatario;
    private Integer idPostulante;
    private Integer idConvocatoria;
    private String tituloConvocatoria;
    private boolean aceptado;
    public EmailDTO() {}

    public EmailDTO(String destinatario, Integer idPostulante, String tituloConvocatoria, boolean aceptado, Integer idConvocatoria) {
        this.destinatario = destinatario;
        this.idPostulante = idPostulante;
        this.tituloConvocatoria = tituloConvocatoria;
        this.aceptado = aceptado;
        this.idConvocatoria = idConvocatoria;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public boolean isAceptado() {
        return aceptado;
    }
    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public Integer getIdPostulante() {
        return idPostulante;
    }

    public void setIdPostulante(Integer idPostulante) {
        this.idPostulante = idPostulante;
    }

    public String getTituloConvocatoria() {
        return tituloConvocatoria;
    }

    public void setTituloConvocatoria(String tituloConvocatoria) {
        this.tituloConvocatoria = tituloConvocatoria;
    }

    public Integer getIdConvocatoria() {
        return idConvocatoria;
    }

    public void setIdConvocatoria(Integer idConvocatoria) {
        this.idConvocatoria = idConvocatoria;
    }
}
