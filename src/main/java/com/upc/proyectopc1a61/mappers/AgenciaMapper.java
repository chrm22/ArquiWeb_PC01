package com.upc.proyectopc1a61.mappers;

import com.upc.proyectopc1a61.dtos.AgenciaDto;
import com.upc.proyectopc1a61.entities.Agencia;
import org.springframework.stereotype.Component;

@Component
public class AgenciaMapper {

    public AgenciaDto toDto(Agencia agencia) {
        return new AgenciaDto(
                agencia.getId(),
                agencia.getNombre(),
                agencia.getTelefono(),
                agencia.getDireccion()
        );
    }

    public Agencia toEntity(AgenciaDto agenciaDto) {
        Agencia agencia = new Agencia();

        agencia.setNombre(agenciaDto.getNombre());
        agencia.setTelefono(agenciaDto.getTelefono());
        agencia.setDireccion(agenciaDto.getDireccion());

        return agencia;
    }

}
