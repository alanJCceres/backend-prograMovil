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

public class ConvocatoriaDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private Integer cantidadMaxPost;
    private Date fechaInicio;
    private Date fechaFin;
    private Integer empresa;

    public ConvocatoriaDTO(Convocatoria convocatoria) {
        this.titulo = convocatoria.getTitulo();
        this.descripcion = convocatoria.getDescripcion();
        this.imagen = convocatoria.getImagen();
        this.cantidadMaxPost = convocatoria.getCantidadMaxPost();
        this.fechaInicio = convocatoria.getFechaInicio();
        this.fechaFin = convocatoria.getFechaFin();
        this.empresa = convocatoria.getEmpresa().getId();
    }
}
