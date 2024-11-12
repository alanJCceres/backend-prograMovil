package com.prograMovil.demo.controllers;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@RestController
@RequestMapping("/imagen")
public class ImagenController {

    @PostMapping
    public ResponseEntity<String> subirImagen(@RequestParam("file") MultipartFile imagen) {
        if (imagen.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("El archivo no debe estar vacío.");
        }

        Path directorioImagenes = Paths.get("src//main//resources//uploads");
        String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

        try {
            byte[] img = imagen.getBytes();
            Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename().trim());
            Files.write(rutaCompleta, img);
            return ResponseEntity.ok(imagen.getOriginalFilename().trim());
        } catch (IOException e) {
            log.error("Error al subir la imagen", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error interno al subir la imagen.");
        }
    }

    @GetMapping("/obtener-imagen/{nombreImagen:.+}")
    public ResponseEntity<?> obtenerImagen(@PathVariable String nombreImagen) {
        try {
            Path directorioImagenes = Paths.get("src//main//resources//uploads");
            Path filePath = directorioImagenes.resolve(nombreImagen);
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (MalformedURLException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
