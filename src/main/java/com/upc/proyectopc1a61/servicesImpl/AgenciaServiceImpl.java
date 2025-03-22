package com.upc.proyectopc1a61.servicesImpl;

import com.upc.proyectopc1a61.dtos.AgenciaDto;
import com.upc.proyectopc1a61.entities.Agencia;
import com.upc.proyectopc1a61.mappers.AgenciaMapper;
import com.upc.proyectopc1a61.repositories.AgenciaRepository;
import com.upc.proyectopc1a61.services.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgenciaServiceImpl implements AgenciaService {

    private final AgenciaMapper agenciaMapper;
    private AgenciaRepository agenciaRepository;

    @Autowired
    public AgenciaServiceImpl(AgenciaRepository agenciaRepository, AgenciaMapper agenciaMapper) {
        this.agenciaRepository = agenciaRepository;
        this.agenciaMapper = agenciaMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<AgenciaDto> listarAgencias() {
        return agenciaRepository.findAll()
                .stream()
                .map(agenciaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AgenciaDto registrarAgencia(AgenciaDto agenciaDto) {

        Agencia agenciaVerificacion = agenciaRepository.findByTelefono(agenciaDto.getTelefono());
        if (agenciaVerificacion != null) {
            throw new RuntimeException("El teléfono introducido ya existe.");
        }

        // Lógica para mapear Dto -> Entidad
        Agencia agencia = agenciaMapper.toEntity(agenciaDto);

        // Se ingresa la entidad en la BD
        Agencia agenciaResponse = agenciaRepository.save(agencia);

        // Lógica para mapear Entidad -> Dto
        return agenciaMapper.toDto(agenciaResponse);
    }

}
