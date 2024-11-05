package com.prograMovil.demo.controllers;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.EmpresaDTO;
import com.prograMovil.demo.services.implement.EmpresaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/convocatorias/{idEmpresa}")
    public List<ConvocatoriaDTO> getConvocatorias(@PathVariable Integer idEmpresa){
        return this.empresaService.getConvocatorias(idEmpresa);
    }
}
