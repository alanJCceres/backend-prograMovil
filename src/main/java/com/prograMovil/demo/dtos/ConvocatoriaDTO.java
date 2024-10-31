package com.prograMovil.demo.dtos;

import java.util.Date;

public class ConvocatoriaDTO {
    private String titulo;
    private String descripcion;
    private String imagen;
    private Integer cantidadMaxPost;
    private Date fechaInicio;
    private Date fechaFin;
    private EmpresaDTO empresa;
    public ConvocatoriaDTO() {}

    public ConvocatoriaDTO(String titulo, String descripcion, String imagen, Integer cantidadMaxPost, Date fechaInicio, Date fechaFin, EmpresaDTO empresa) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.cantidadMaxPost = cantidadMaxPost;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.empresa = empresa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Integer getCantidadMaxPost() {
        return cantidadMaxPost;
    }

    public void setCantidadMaxPost(Integer cantidadMaxPost) {
        this.cantidadMaxPost = cantidadMaxPost;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }
}
