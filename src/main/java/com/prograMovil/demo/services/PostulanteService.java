package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.models.Postulante;
import org.springframework.http.ResponseEntity;

public interface PostulanteService {
    PostulanteDTO getPostulante(Integer id);
    PostulanteDTO savePostulante(PostulanteDTO postulante);
    Integer loginPostulante(PostulanteDTO postulante);
    ResponseEntity<String> setPostulante(Integer idPostulante, PostulanteDTO postulante);
}
