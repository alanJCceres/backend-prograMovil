package com.prograMovil.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String resourceName,Integer id) {

        super(String.format("Elemento no encontrado: %s con id: %d",resourceName,id));
    }
}
