package com.prograMovil.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holaMundo")
public class HolaMundoController {
    @GetMapping()
    public String holaMundo() {
        return "Hola, mundo!";
    }
}
