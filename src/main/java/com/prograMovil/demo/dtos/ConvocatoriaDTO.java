package com.prograMovil.demo.dtos;

import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Postulante;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;

@Slf4j
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConvocatoriaDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private Integer cantidadMaxPost;
    private String estado;
    private Date fechaInicioReclutamiento;
    private Date fechaFinReclutamiento;
    private Date fechaInicioSeleccion;
    private Date fechaFinSeleccion;
    private Integer empresa;

    public ConvocatoriaDTO(Convocatoria convocatoria) {
        this.id = convocatoria.getId();
        this.titulo = convocatoria.getTitulo();
        this.descripcion = convocatoria.getDescripcion();
        this.imagen = convocatoria.getImagen();
        this.cantidadMaxPost = convocatoria.getCantidadMaxPost();
        this.estado = convocatoria.getEstado() == null ? "Por comenzar": convocatoria.getEstado();
        this.fechaInicioReclutamiento = convocatoria.getFechaInicioReclutamiento();
        this.fechaFinReclutamiento = convocatoria.getFechaFinReclutamiento();
        this.fechaInicioSeleccion = convocatoria.getFechaInicioSeleccion();
        this.fechaFinSeleccion = convocatoria.getFechaFinSeleccion();
        this.empresa = convocatoria.getEmpresa().getId();
    }
}
