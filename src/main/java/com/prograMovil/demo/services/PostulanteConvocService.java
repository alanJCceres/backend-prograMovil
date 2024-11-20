package com.prograMovil.demo.services;

import org.springframework.http.ResponseEntity;

public interface PostulanteConvocService {
    void setAceptado(Integer idConvocatoria,Integer idPostulante, boolean aceptado);
    ResponseEntity<String> postularse(Integer idPostulante,Integer idConvocatoria,String pathCurriculum);
}
