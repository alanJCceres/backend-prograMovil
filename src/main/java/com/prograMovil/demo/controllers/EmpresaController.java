package com.prograMovil.demo.controllers;

import com.prograMovil.demo.dtos.EmpresaDTO;
import com.prograMovil.demo.services.implement.EmpresaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private EmpresaServiceImpl empresaService;
    @PostMapping
    public ResponseEntity<EmpresaDTO> createEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        EmpresaDTO empresaDTO1 = empresaService.saveEmpresa(empresaDTO);
        return new ResponseEntity<>(empresaDTO1, HttpStatus.CREATED);
    }
}
