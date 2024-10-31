package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.EmpresaDTO;

public interface ConvocatoriaService {
    ConvocatoriaDTO getConvocatoriaById(Integer idConvocatoria);
    ConvocatoriaDTO saveConvocatoria(ConvocatoriaDTO convocatoria);
    ConvocatoriaDTO updateConvocatoria(ConvocatoriaDTO convocatoria);
}
