package com.prograMovil.demo.services;

import com.prograMovil.demo.dtos.EmpresaDTO;

public interface EmpresaService {
    EmpresaDTO getEmpresaById(Integer idEmpresa);
    EmpresaDTO saveEmpresa(EmpresaDTO empresa);
    EmpresaDTO updateEmpresa(EmpresaDTO empresa);
}
