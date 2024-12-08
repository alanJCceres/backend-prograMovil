package com.prograMovil.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmailDTO {
    private String destinatario;
    private Integer idPostulante;
    private Integer idConvocatoria;
    private String tituloConvocatoria;
    private String estadoPostulante;

}
