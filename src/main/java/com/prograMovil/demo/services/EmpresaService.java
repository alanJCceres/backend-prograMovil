package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.ConvocatoriaForTableDTO;
import com.prograMovil.demo.dtos.EmpresaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmpresaService {
    EmpresaDTO getEmpresaById(Integer idEmpresa);
    EmpresaDTO saveEmpresa(EmpresaDTO empresa);
    List<ConvocatoriaForTableDTO> getConvocatorias(Integer idEmpresa);
    List<ConvocatoriaForTableDTO> getConvocatoriasEstado(Integer idEmpresa,String estado);
    Integer loginEmpresa(EmpresaDTO empresa);
    ResponseEntity<String> setEmpresa(Integer idEmpresa, EmpresaDTO empresa);
    List<ConvocatoriaForTableDTO> getConvocatoriasFiltradas(Integer idEmpresa, Boolean esVigente);
}
