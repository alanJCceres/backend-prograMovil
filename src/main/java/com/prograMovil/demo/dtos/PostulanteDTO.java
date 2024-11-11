package com.prograMovil.demo.dtos;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostulanteDTO {
    private Integer id;
    private String nombre;
    private String apellido;
    private String carrera;
    private String descripcion;
    private String celular;
    private String correo;
    private String usuario;
    private String contrasenia;
    private String rol;
    private PostulanteConvocatoriaDTO datosAdicionales;
}
