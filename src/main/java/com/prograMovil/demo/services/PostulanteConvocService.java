package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.models.Convocatoria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostulanteConvocService {
    void setAceptado(Integer idConvocatoria,Integer idPostulante, boolean aceptado);
    ResponseEntity<String> postularse(Integer idPostulante,Integer idConvocatoria,String pathCurriculum);
    List<ConvocatoriaDTO> getAllConvocatorias(Integer idPostulante);
}
