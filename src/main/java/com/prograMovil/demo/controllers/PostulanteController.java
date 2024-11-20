package com.prograMovil.demo.controllers;

import com.prograMovil.demo.dtos.EmpresaDTO;
import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.repositories.PostulanteRepository;
import com.prograMovil.demo.services.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postulantes")
public class PostulanteController {
    @Autowired
    private PostulanteService postulanteService;
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
}
