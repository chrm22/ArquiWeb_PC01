package com.upc.proyectopc1a61.dtos;

import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.upc.proyectopc1a61.entities.Anuncio}
 */
@Value
public class AnuncioDto implements Serializable {
    Long id;
    String nombre;
    float precio;
    String publicoObjetivo;
    Long duracion;
    LocalDate fechaPublicacion;
    Long agenciaId;
}