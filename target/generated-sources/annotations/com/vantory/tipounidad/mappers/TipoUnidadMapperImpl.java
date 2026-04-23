package com.vantory.tipounidad.mappers;

import com.vantory.estado.Estado;
import com.vantory.tipounidad.TipoUnidad;
import com.vantory.tipounidad.dtos.TipoUnidadDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoUnidadMapperImpl implements TipoUnidadMapper {

    @Override
    public TipoUnidadDTO toDTO(TipoUnidad unidad) {
        if ( unidad == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = unidadEstadoId( unidad );
        id = unidad.getId();
        nombre = unidad.getNombre();
        descripcion = unidad.getDescripcion();

        TipoUnidadDTO tipoUnidadDTO = new TipoUnidadDTO( id, nombre, descripcion, estadoId );

        return tipoUnidadDTO;
    }

    @Override
    public TipoUnidad toEntity(TipoUnidadDTO tipoUnidadDTO) {
        if ( tipoUnidadDTO == null ) {
            return null;
        }

        TipoUnidad.TipoUnidadBuilder tipoUnidad = TipoUnidad.builder();

        tipoUnidad.estado( tipoUnidadDTOToEstado( tipoUnidadDTO ) );
        tipoUnidad.id( tipoUnidadDTO.getId() );
        tipoUnidad.nombre( tipoUnidadDTO.getNombre() );
        tipoUnidad.descripcion( tipoUnidadDTO.getDescripcion() );

        return tipoUnidad.build();
    }

    private Long unidadEstadoId(TipoUnidad tipoUnidad) {
        Estado estado = tipoUnidad.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Estado tipoUnidadDTOToEstado(TipoUnidadDTO tipoUnidadDTO) {
        if ( tipoUnidadDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoUnidadDTO.getEstadoId() );

        return estado.build();
    }
}
