package com.upc.proyectopc1a61.mappers;

import com.upc.proyectopc1a61.dtos.AnuncioDto;
import com.upc.proyectopc1a61.entities.Anuncio;
import org.springframework.stereotype.Component;

@Component
public class AnuncioMapper {

    public AnuncioDto toDto(Anuncio anuncio) {
        return new AnuncioDto(
                anuncio.getId(),
                anuncio.getNombre(),
                anuncio.getPrecio(),
                anuncio.getPublicoObjetivo(),
                anuncio.getDuracion(),
                anuncio.getFechaPublicacion(),
                anuncio.getAgencia().getId()
        );
    }

    public Anuncio toEntity(AnuncioDto anuncioDto) {
        Anuncio anuncio = new Anuncio();

        anuncio.setNombre(anuncioDto.getNombre());
        anuncio.setPrecio(anuncioDto.getPrecio());
        anuncio.setDuracion(anuncioDto.getDuracion());
        anuncio.setFechaPublicacion(anuncioDto.getFechaPublicacion());
        anuncio.setPublicoObjetivo(anuncioDto.getPublicoObjetivo());

        return anuncio;
    }
}
