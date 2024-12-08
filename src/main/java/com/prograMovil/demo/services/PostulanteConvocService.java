package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.PostulanteConvocatoriaDTO;
import com.prograMovil.demo.models.Convocatoria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostulanteConvocService {
    void setEstado(Integer idConvocatoria,Integer idPostulante, String estado);
    Boolean postularse(Integer idPostulante,Integer idConvocatoria,String pathCurriculum);
    List<PostulanteConvocatoriaDTO> getAllConvocatorias(Integer idPostulante);
}
