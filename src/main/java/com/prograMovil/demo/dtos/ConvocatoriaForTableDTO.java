package com.prograMovil.demo.dtos;

import com.prograMovil.demo.models.Convocatoria;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConvocatoriaForTableDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private Integer cantidadMaxPost;
    private Date fechaInicioReclutamiento;
    private Date fechaFinReclutamiento;
    private Date fechaInicioSeleccion;
    private Date fechaFinSeleccion;
    private String estado;
    private Integer empresa;
    private Long postulantes;
    //private boolean vigente;

    public ConvocatoriaForTableDTO(Convocatoria convocatoria, Long postulantes) {
        this.id = convocatoria.getId();
        this.titulo = convocatoria.getTitulo();
        this.descripcion = convocatoria.getDescripcion();
        this.imagen = convocatoria.getImagen();
        this.cantidadMaxPost = convocatoria.getCantidadMaxPost();
        this.fechaInicioReclutamiento = convocatoria.getFechaInicioReclutamiento();
        this.fechaFinReclutamiento = convocatoria.getFechaFinReclutamiento();
        this.fechaInicioSeleccion = convocatoria.getFechaInicioSeleccion();
        this.fechaFinSeleccion = convocatoria.getFechaFinSeleccion();
        this.estado = convocatoria.getEstado();
        this.empresa = convocatoria.getEmpresa().getId();
        this.postulantes = postulantes;
    }
}
