package com.prograMovil.demo.repositories;

import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Postulante;
import com.prograMovil.demo.models.PostulanteConvocatoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostulanteConvocatoriaRepository extends JpaRepository<PostulanteConvocatoria, Integer> {
    public Optional<PostulanteConvocatoria> findByConvocatoriaAndPostulante(Convocatoria convocatoria, Postulante postulante);
}
