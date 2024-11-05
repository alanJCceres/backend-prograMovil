package com.prograMovil.demo.repositories;

import com.prograMovil.demo.models.Postulante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostulanteRepository extends JpaRepository<Postulante,Integer> {
}
