package com.prograMovil.demo.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO {
    private Integer id;
    private String nombre;
    private String ubicacion;
    private String imagen;
    private String nit;
    private String usuario;
    private String contrasenia;
    private String rol;
}
