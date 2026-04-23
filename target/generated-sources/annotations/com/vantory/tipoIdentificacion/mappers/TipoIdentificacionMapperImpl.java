package com.vantory.tipoIdentificacion.mappers;

import com.vantory.estado.Estado;
import com.vantory.tipoIdentificacion.TipoIdentificacion;
import com.vantory.tipoIdentificacion.dtos.TipoIdentificacionDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoIdentificacionMapperImpl implements TipoIdentificacionMapper {

    @Override
    public TipoIdentificacionDTO toDTO(TipoIdentificacion tipoIdentificacion) {
        if ( tipoIdentificacion == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoIdentificacionEstadoId( tipoIdentificacion );
        id = tipoIdentificacion.getId();
        nombre = tipoIdentificacion.getNombre();
        descripcion = tipoIdentificacion.getDescripcion();

        TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO( id, nombre, descripcion, estadoId );

        return tipoIdentificacionDTO;
    }

    @Override
    public TipoIdentificacion toEntity(TipoIdentificacionDTO tipoIdentificacionDTO) {
        if ( tipoIdentificacionDTO == null ) {
            return null;
        }

        TipoIdentificacion.TipoIdentificacionBuilder tipoIdentificacion = TipoIdentificacion.builder();

        tipoIdentificacion.estado( tipoIdentificacionDTOToEstado( tipoIdentificacionDTO ) );
        tipoIdentificacion.id( tipoIdentificacionDTO.getId() );
        tipoIdentificacion.nombre( tipoIdentificacionDTO.getNombre() );
        tipoIdentificacion.descripcion( tipoIdentificacionDTO.getDescripcion() );

        return tipoIdentificacion.build();
    }

    private Long tipoIdentificacionEstadoId(TipoIdentificacion tipoIdentificacion) {
        Estado estado = tipoIdentificacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Estado tipoIdentificacionDTOToEstado(TipoIdentificacionDTO tipoIdentificacionDTO) {
        if ( tipoIdentificacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoIdentificacionDTO.getEstadoId() );

        return estado.build();
    }
}
