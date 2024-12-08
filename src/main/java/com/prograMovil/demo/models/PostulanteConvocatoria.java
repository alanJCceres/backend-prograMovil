package com.prograMovil.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class PostulanteConvocatoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String estado;
    private String curriculum;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "postulante_id")
    private Postulante postulante;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "convocatoria_id")
    private Convocatoria convocatoria;
    @CreatedDate
    private Date createdAt;
    @LastModifiedDate
    private Date updatedAt;
}
