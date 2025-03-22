package com.upc.proyectopc1a61.services;

import com.upc.proyectopc1a61.dtos.AgenciaDto;
import com.upc.proyectopc1a61.dtos.AnuncioDto;
import com.upc.proyectopc1a61.entities.Agencia;

import java.util.List;

public interface AgenciaService {
    public List<AgenciaDto> listarAgencias();
    public AgenciaDto registrarAgencia(AgenciaDto agenciaDto);

}
