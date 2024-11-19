package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.models.Postulante;

public interface PostulanteService {
    PostulanteDTO getPostulante(Integer id);
    PostulanteDTO savePostulante(PostulanteDTO postulante);
    Integer loginPostulante(PostulanteDTO postulante);
    void setPostulante(PostulanteDTO postulante);
}
