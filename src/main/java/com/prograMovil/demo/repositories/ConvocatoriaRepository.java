package com.prograMovil.demo.repositories;

import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConvocatoriaRepository extends JpaRepository<Convocatoria,Integer> {
    @Query("SELECT c FROM Convocatoria c WHERE c.empresa = ?1")
    List<Convocatoria> findAllByEmpresaId(Empresa empresa);
}
