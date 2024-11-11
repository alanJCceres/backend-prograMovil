package com.prograMovil.demo.services.implement;

import com.prograMovil.demo.dtos.PostulanteConvocatoriaDTO;
import com.prograMovil.demo.models.PostulanteConvocatoria;
import org.springframework.stereotype.Service;

@Service
public class PostulanteConvocImpl {
    public PostulanteConvocatoriaDTO toDTO(PostulanteConvocatoria postulante) {
        PostulanteConvocatoriaDTO dto = new PostulanteConvocatoriaDTO();
        dto.setAceptado(postulante.isAceptado());
        dto.setCurriculum(postulante.getCurriculum());
        return dto;
    }
    public PostulanteConvocatoria toEntity(PostulanteConvocatoriaDTO dto) {
        PostulanteConvocatoria postulante = new PostulanteConvocatoria();
        postulante.setAceptado(dto.isAceptado());
        postulante.setCurriculum(dto.getCurriculum());
        return postulante;
    }
}
