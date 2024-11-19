package com.prograMovil.demo.repositories;

import com.prograMovil.demo.dtos.ConvocatoriaForTableDTO;
import com.prograMovil.demo.models.Convocatoria;
import com.prograMovil.demo.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ConvocatoriaRepository extends JpaRepository<Convocatoria,Integer> {
    @Query("SELECT c FROM Convocatoria c WHERE c.empresa = ?1")
    List<Convocatoria> findAllByEmpresaId(Empresa empresa);

    @Query("SELECT new com.prograMovil.demo.dtos.ConvocatoriaForTableDTO(c , count(p.id))  " +
            " FROM Convocatoria c " +
            " LEFT JOIN PostulanteConvocatoria p " +
            " ON c.id = p.convocatoria.id" +
            " WHERE c.empresa = ?1 " +
            "GROUP BY c.id"
    )
    List<ConvocatoriaForTableDTO> findAllDtoByEmpresaId(Empresa empresa);
}
