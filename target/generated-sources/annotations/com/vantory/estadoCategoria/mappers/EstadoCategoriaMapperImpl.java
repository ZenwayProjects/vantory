package com.vantory.estadoCategoria.mappers;

import com.vantory.estadoCategoria.EstadoCategoria;
import com.vantory.estadoCategoria.dtos.EstadoCategoriaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EstadoCategoriaMapperImpl implements EstadoCategoriaMapper {

    @Override
    public EstadoCategoriaDTO toDTO(EstadoCategoria estadoCategoria) {
        if ( estadoCategoria == null ) {
            return null;
        }

        EstadoCategoriaDTO estadoCategoriaDTO = new EstadoCategoriaDTO();

        estadoCategoriaDTO.setId( estadoCategoria.getId() );
        estadoCategoriaDTO.setNombre( estadoCategoria.getNombre() );
        estadoCategoriaDTO.setDescripcion( estadoCategoria.getDescripcion() );

        return estadoCategoriaDTO;
    }

    @Override
    public EstadoCategoria toEntity(EstadoCategoriaDTO estadoCategoriaDTO) {
        if ( estadoCategoriaDTO == null ) {
            return null;
        }

        EstadoCategoria.EstadoCategoriaBuilder estadoCategoria = EstadoCategoria.builder();

        estadoCategoria.id( estadoCategoriaDTO.getId() );
        estadoCategoria.nombre( estadoCategoriaDTO.getNombre() );
        estadoCategoria.descripcion( estadoCategoriaDTO.getDescripcion() );

        return estadoCategoria.build();
    }
}
