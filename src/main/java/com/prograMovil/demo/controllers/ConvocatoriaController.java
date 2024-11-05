package com.prograMovil.demo.controllers;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.services.implement.ConvocatoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/convocatorias")
public class ConvocatoriaController {
    @Autowired
    private ConvocatoriaServiceImpl convocatoriaService;
    @PostMapping
    public ResponseEntity<ConvocatoriaDTO> saveConvocatoria(@RequestBody ConvocatoriaDTO convocatoria) {
        ConvocatoriaDTO convocatoriaDTO = convocatoriaService.saveConvocatoria(convocatoria);
        return new ResponseEntity<>(convocatoriaDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ConvocatoriaDTO getConvocatoria(@PathVariable Integer id) {
        return convocatoriaService.getConvocatoriaById(id);
    }
}
