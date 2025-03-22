package com.upc.proyectopc1a61.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.upc.proyectopc1a61.entities.Agencia}
 */
@Value
public class AgenciaDto implements Serializable {
    Long id;
    String nombre;
    String telefono;
    String direccion;
}