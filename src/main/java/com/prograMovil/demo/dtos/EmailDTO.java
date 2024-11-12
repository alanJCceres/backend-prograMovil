package com.prograMovil.demo.dtos;

public class EmailDTO {
    private String destinatario;
    private String asunto;
    private String mensaje;
    public EmailDTO() {}

    public EmailDTO(String mensaje, String asunto, String destinatario) {
        this.mensaje = mensaje;
        this.asunto = asunto;
        this.destinatario = destinatario;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
}
