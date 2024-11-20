package com.prograMovil.demo.controllers;

import com.prograMovil.demo.dtos.EmpresaDTO;
import com.prograMovil.demo.dtos.PostulanteConvocatoriaDTO;
import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.repositories.PostulanteRepository;
import com.prograMovil.demo.services.PostulanteConvocService;
import com.prograMovil.demo.services.PostulanteService;
import com.prograMovil.demo.services.implement.PostulanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postulantes")
public class PostulanteController {
    @Autowired
    private PostulanteService postulanteService;
    @Autowired
    private PostulanteConvocService postulanteConvocService;

    @PostMapping("/login")
    public Integer loginPostulante(@RequestBody PostulanteDTO postulante) {
        return this.postulanteService.loginPostulante(postulante);
    }
    @PostMapping
    public ResponseEntity<PostulanteDTO> createPostulante(@RequestBody PostulanteDTO postulante) {
        PostulanteDTO postulanteDTO = postulanteService.savePostulante(postulante);
        return new ResponseEntity<>(postulanteDTO, HttpStatus.CREATED);
    }
    @GetMapping("/{idPostulante}")
    public PostulanteDTO getPostulante(@PathVariable Integer idPostulante) {
        return this.postulanteService.getPostulante(idPostulante);
    }
    @PatchMapping("/{idPostulante}")
    public ResponseEntity<String> setPostulante(@PathVariable Integer idPostulante, @RequestBody PostulanteDTO postulante) {
            return postulanteService.setPostulante(idPostulante, postulante);
    }
    @PostMapping("/{idPostulante}/postularse/{idConvocatoria}")
    public ResponseEntity<String> postularse(@PathVariable Integer idPostulante, @PathVariable Integer idConvocatoria, @RequestBody PostulanteConvocatoriaDTO postulanteConvocatoria) {
        String curriculum = postulanteConvocatoria.getCurriculum();
        return postulanteConvocService.postularse(idPostulante, idConvocatoria, curriculum);
    }
}
