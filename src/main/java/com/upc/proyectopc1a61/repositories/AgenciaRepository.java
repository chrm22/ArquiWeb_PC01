package com.upc.proyectopc1a61.repositories;

import com.upc.proyectopc1a61.entities.Agencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenciaRepository extends JpaRepository<Agencia, Long> {

    public Agencia findByTelefono(String telefono);
}