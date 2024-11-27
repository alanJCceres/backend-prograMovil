package com.prograMovil.demo.dtos;

import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Empresa;
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

    public EmpresaDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.nombre = empresa.getNombre();
        this.ubicacion = empresa.getUbicacion();
        this.imagen = empresa.getImagen();
        this.nit = empresa.getNit();
        this.usuario = empresa.getUsuario();
        this.contrasenia = empresa.getContrasenia();
        this.rol = empresa.getRol();
    }
}
