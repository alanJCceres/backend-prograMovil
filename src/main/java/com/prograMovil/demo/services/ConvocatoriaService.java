package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.EmpresaDTO;
import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.models.Postulante;

import java.util.List;

public interface ConvocatoriaService {
    ConvocatoriaDTO getConvocatoriaById(Integer idConvocatoria);
    ConvocatoriaDTO saveConvocatoria(ConvocatoriaDTO convocatoria);
    ConvocatoriaDTO updateConvocatoria(ConvocatoriaDTO convocatoria);
    List<PostulanteDTO> getPostulantes(Integer idConvoctoria);
    PostulanteDTO getPostulante(Integer idConvocatoria, Integer idPostulante);
}
