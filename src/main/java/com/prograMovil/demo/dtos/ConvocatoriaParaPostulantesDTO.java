package com.prograMovil.demo.dtos;

import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Empresa;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConvocatoriaParaPostulantesDTO {
    private Integer id;
    private String titulo;
    private String descripcion;
    private String imagen;
    private Integer cantidadMaxPost;
    private String fechaInicio;
    private String fechaFin;
    private EmpresaDTO empresa;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ConvocatoriaParaPostulantesDTO(Convocatoria convocatoria) {
        this.titulo = convocatoria.getTitulo();
        this.descripcion = convocatoria.getDescripcion();
        this.imagen = convocatoria.getImagen();
        this.cantidadMaxPost = convocatoria.getCantidadMaxPost();
        this.fechaInicio = convertAndFormatDate(convocatoria.getFechaInicio());
        this.fechaFin = convertAndFormatDate(convocatoria.getFechaFin());
        this.empresa = new EmpresaDTO(convocatoria.getEmpresa());
    }

    private String convertAndFormatDate(java.util.Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .format(formatter);
    }
}
