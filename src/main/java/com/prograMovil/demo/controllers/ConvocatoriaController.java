package com.prograMovil.demo.controllers;

import com.prograMovil.demo.dtos.ConvocatoriaDTO;
import com.prograMovil.demo.dtos.ConvocatoriaParaPostulantesDTO;
import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.services.implement.ConvocatoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return this.convocatoriaService.getConvocatoriaById(id);
    }
    @GetMapping("/{idConvocatoria}/postulantes")
    public List<PostulanteDTO> getPostulantes(@PathVariable Integer idConvocatoria,@RequestParam(required = false) String estadoPostulantes){
        if (estadoPostulantes != null) {
            return this.convocatoriaService.getPostulantesEstado(idConvocatoria,estadoPostulantes);
        } else {
            return this.convocatoriaService.getPostulantes(idConvocatoria);
        }
    }
    @GetMapping("/{idConvocatoria}/postulantes/{idPostulante}")
    public PostulanteDTO getPostulante(@PathVariable Integer idConvocatoria, @PathVariable Integer idPostulante) {
        return this.convocatoriaService.getPostulante(idConvocatoria, idPostulante);
    }
    @GetMapping
    public List<ConvocatoriaParaPostulantesDTO> getAllConvocatorias(){
        return this.convocatoriaService.getAllConvocatoriasParaPostulantes();
    }
    @GetMapping("/postulante/{idConvocatoria}")
    public ConvocatoriaParaPostulantesDTO getConvocatoriaWithEmpresa(@PathVariable Integer idConvocatoria) {
        return this.convocatoriaService.getConvocatoriaWithEmpresaById(idConvocatoria);
    }
}
