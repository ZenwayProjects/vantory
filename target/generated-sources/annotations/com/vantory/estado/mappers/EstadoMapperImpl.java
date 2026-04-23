package com.vantory.estado.mappers;

import com.vantory.estado.Estado;
import com.vantory.estado.dtos.EstadoDTO;
import com.vantory.estadoCategoria.EstadoCategoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EstadoMapperImpl implements EstadoMapper {

    @Override
    public EstadoDTO toDTO(Estado estado) {
        if ( estado == null ) {
            return null;
        }

        Long estadoCategoriaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        String acronimo = null;

        estadoCategoriaId = estadoEstadoCategoriaId( estado );
        id = estado.getId();
        nombre = estado.getNombre();
        descripcion = estado.getDescripcion();
        acronimo = estado.getAcronimo();

        EstadoDTO estadoDTO = new EstadoDTO( id, nombre, descripcion, acronimo, estadoCategoriaId );

        return estadoDTO;
    }

    @Override
    public Estado toEntity(EstadoDTO estadoDTO) {
        if ( estadoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.estadoCategoria( estadoDTOToEstadoCategoria( estadoDTO ) );
        estado.id( estadoDTO.getId() );
        estado.nombre( estadoDTO.getNombre() );
        estado.descripcion( estadoDTO.getDescripcion() );
        estado.acronimo( estadoDTO.getAcronimo() );

        return estado.build();
    }

    @Override
    public EstadoDTO toShortDTO(Estado estado) {
        if ( estado == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        Long estadoCategoriaId = null;

        id = estado.getId();
        nombre = estado.getNombre();
        estadoCategoriaId = estadoEstadoCategoriaId( estado );

        String descripcion = null;
        String acronimo = null;

        EstadoDTO estadoDTO = new EstadoDTO( id, nombre, descripcion, acronimo, estadoCategoriaId );

        return estadoDTO;
    }

    private Long estadoEstadoCategoriaId(Estado estado) {
        EstadoCategoria estadoCategoria = estado.getEstadoCategoria();
        if ( estadoCategoria == null ) {
            return null;
        }
        return estadoCategoria.getId();
    }

    protected EstadoCategoria estadoDTOToEstadoCategoria(EstadoDTO estadoDTO) {
        if ( estadoDTO == null ) {
            return null;
        }

        EstadoCategoria.EstadoCategoriaBuilder estadoCategoria = EstadoCategoria.builder();

        estadoCategoria.id( estadoDTO.getEstadoCategoriaId() );

        return estadoCategoria.build();
    }
}
