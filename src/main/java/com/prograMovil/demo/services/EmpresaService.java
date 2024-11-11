package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.EmpresaDTO;

import java.util.List;

public interface EmpresaService {
    EmpresaDTO getEmpresaById(Integer idEmpresa);
    EmpresaDTO saveEmpresa(EmpresaDTO empresa);
    EmpresaDTO updateEmpresa(EmpresaDTO empresa);
    List<ConvocatoriaDTO> getConvocatorias(Integer idEmpresa);
    Integer loginEmpresa(EmpresaDTO empresa);
}
