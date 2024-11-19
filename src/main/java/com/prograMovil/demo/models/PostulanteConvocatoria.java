package com.prograMovil.demo.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class PostulanteConvocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean aceptado;
    private String curriculum;
    @ManyToOne(fetch = FetchType.LAZY)
    private Postulante postulante;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "convocatoria_id")
    private Convocatoria convocatoria;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
    public PostulanteConvocatoria() {}

    public PostulanteConvocatoria(Integer id, boolean aceptado, String curriculum, Postulante postulante, Convocatoria convocatoria, Date createdAt, Date updatedAt) {
        this.id = id;
        this.aceptado = aceptado;
        this.curriculum = curriculum;
        this.postulante = postulante;
        this.convocatoria = convocatoria;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public Postulante getPostulante() {
        return postulante;
    }

    public void setPostulante(Postulante postulante) {
        this.postulante = postulante;
    }

    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
