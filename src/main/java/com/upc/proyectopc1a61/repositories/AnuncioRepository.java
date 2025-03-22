package com.upc.proyectopc1a61.repositories;

import com.upc.proyectopc1a61.entities.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {
}