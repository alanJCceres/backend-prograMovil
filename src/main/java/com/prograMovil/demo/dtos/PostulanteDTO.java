package com.prograMovil.demo.dtos;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostulanteDTO {
    private String id;
    private String nombre;
    private String apellido;
    private String carrera;
    private String descripcion;
    private String celular;
    private String correo;
    private String rol;
}
