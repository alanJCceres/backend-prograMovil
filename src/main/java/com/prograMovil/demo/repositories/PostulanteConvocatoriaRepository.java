package com.prograMovil.demo.repositories;

import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Postulante;
import com.prograMovil.demo.models.PostulanteConvocatoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PostulanteConvocatoriaRepository extends JpaRepository<PostulanteConvocatoria, Integer> {
    public Optional<PostulanteConvocatoria> findByConvocatoriaAndPostulante(Convocatoria convocatoria, Postulante postulante);
    //@Query("SELECT pc.convocatoria FROM PostulanteConvocatoria pc WHERE pc.postulante = :postulante")
    @Query("SELECT pc FROM PostulanteConvocatoria pc " +
            "JOIN FETCH pc.convocatoria c " +
            "WHERE pc.postulante.id = :postulanteId")
    List<PostulanteConvocatoria> findConvocatoriasByPostulante(@Param("postulanteId") Integer postulanteId);

}
