package com.upc.proyectopc1a61.servicesImpl;

import com.upc.proyectopc1a61.dtos.AnuncioDto;
import com.upc.proyectopc1a61.entities.Agencia;
import com.upc.proyectopc1a61.entities.Anuncio;
import com.upc.proyectopc1a61.mappers.AnuncioMapper;
import com.upc.proyectopc1a61.repositories.AgenciaRepository;
import com.upc.proyectopc1a61.repositories.AnuncioRepository;
import com.upc.proyectopc1a61.services.AnuncioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnuncioServiceImpl implements AnuncioService {

    private final AnuncioMapper anuncioMapper;
    private AnuncioRepository anuncioRepository;
    private AgenciaRepository agenciaRepository;

    @Autowired
    public AnuncioServiceImpl(AnuncioRepository anuncioRepository, AgenciaRepository agenciaRepository, AnuncioMapper anuncioMapper) {
        this.anuncioRepository = anuncioRepository;
        this.agenciaRepository = agenciaRepository;
        this.anuncioMapper = anuncioMapper;
    }

    @Override
    public AnuncioDto registrarAnuncio(AnuncioDto anuncioDto) {

        Agencia agencia = agenciaRepository.findById(anuncioDto.getAgenciaId())
                .orElseThrow(() -> new RuntimeException("Agencia no encontrada"));

        // Lógica para mapear Dto -> Entidad
        Anuncio anuncio = anuncioMapper.toEntity(anuncioDto);
        anuncio.setAgencia(agencia);

        // Se guarda el anuncio en la BD
        Anuncio anuncioResponse = anuncioRepository.save(anuncio);

        // Lógica para mapear Entidad -> Dto
        return anuncioMapper.toDto(anuncioResponse);
    }
}
