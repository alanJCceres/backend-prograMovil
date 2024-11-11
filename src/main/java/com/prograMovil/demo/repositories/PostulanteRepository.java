package com.prograMovil.demo.repositories;

import com.prograMovil.demo.models.Postulante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostulanteRepository extends JpaRepository<Postulante,Integer> {
    public Optional<Postulante> findByUsuarioAndContrasenia(String usuario, String contrasenia);
}
