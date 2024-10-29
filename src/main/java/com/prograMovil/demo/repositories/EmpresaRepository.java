package com.prograMovil.demo.repositories;

import com.prograMovil.demo.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa,Integer> {
}
