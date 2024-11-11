package com.prograMovil.demo.repositories;

import com.prograMovil.demo.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
    public Optional<Empresa> findByUsuarioAndContrasenia(String usuario, String contrasenia);
}
