package com.prograMovil.demo.models;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Convocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    @OneToMany(mappedBy = "convocatoria")
    private List<PostulanteConvocatoria> postulantes;

    public Convocatoria(ConvocatoriaDTO convocatoriaDTO){
            this.titulo = convocatoriaDTO.getTitulo();
            this.descripcion = convocatoriaDTO.getDescripcion();
            this.imagen = convocatoriaDTO.getImagen();
            this.cantidadMaxPost = convocatoriaDTO.getCantidadMaxPost();
            this.estado = convocatoriaDTO.getEstado() == null ? "Por comenzar" : convocatoriaDTO.getEstado();
            this.fechaInicioReclutamiento = convocatoriaDTO.getFechaInicioReclutamiento();
            this.fechaFinReclutamiento = convocatoriaDTO.getFechaFinReclutamiento();
            this.fechaInicioSeleccion = convocatoriaDTO.getFechaInicioSeleccion();
            this.fechaFinSeleccion = convocatoriaDTO.getFechaFinSeleccion();
    }
}
