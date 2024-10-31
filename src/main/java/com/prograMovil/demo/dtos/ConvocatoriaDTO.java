package com.prograMovil.demo.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ConvocatoriaDTO {
    private String titulo;
    private String descripcion;
    private String imagen;
    private Integer cantidadMaxPost;
    private Date fechaInicio;
    private Date fechaFin;
    private EmpresaDTO empresa;
}
