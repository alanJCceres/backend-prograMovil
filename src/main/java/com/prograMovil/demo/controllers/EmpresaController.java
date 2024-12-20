package com.prograMovil.demo.controllers;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.ConvocatoriaForTableDTO;
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
    @GetMapping("/{idEmpresa}/convocatorias")
    public List<ConvocatoriaForTableDTO> getConvocatorias(@PathVariable Integer idEmpresa){
        return this.empresaService.getConvocatorias(idEmpresa);
    }
    @GetMapping("/{idEmpresa}/convocatoriasVigentes")
    public List<ConvocatoriaForTableDTO> getConvocatoriasVigentes(@PathVariable Integer idEmpresa, @RequestParam Boolean esVigente){
         return this.empresaService.getConvocatoriasFiltradas(idEmpresa, esVigente);
    }
    @PostMapping("/login")
    public Integer loginEmpresa(@RequestBody EmpresaDTO empresaDTO){
        return this.empresaService.loginEmpresa(empresaDTO);
    }
    @GetMapping("/{idEmpresa}")
    public EmpresaDTO getEmpresa(@PathVariable Integer idEmpresa){
        return empresaService.getEmpresaById(idEmpresa);
        /*
            {
        id:9, 
        type:"empresa"
        }
        */
    
    }
    @PutMapping("/{idEmpresa}")
    public ResponseEntity<String> updateEmpresa(@PathVariable Integer idEmpresa, @RequestBody EmpresaDTO empresaDTO){
        return this.empresaService.setEmpresa(idEmpresa, empresaDTO);
    }
}
