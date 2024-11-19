package com.prograMovil.demo.controllers;

import com.prograMovil.demo.dtos.EmpresaDTO;
import com.prograMovil.demo.dtos.PostulanteDTO;
import com.prograMovil.demo.repositories.PostulanteRepository;
import com.prograMovil.demo.services.PostulanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
