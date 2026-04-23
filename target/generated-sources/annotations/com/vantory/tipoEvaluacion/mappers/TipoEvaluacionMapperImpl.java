package com.vantory.tipoEvaluacion.mappers;

import com.vantory.estado.Estado;
import com.vantory.tipoEvaluacion.TipoEvaluacion;
import com.vantory.tipoEvaluacion.dtos.TipoEvaluacionDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:59-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoEvaluacionMapperImpl implements TipoEvaluacionMapper {

    @Override
    public TipoEvaluacionDTO toDTO(TipoEvaluacion tipoEvaluacion) {
        if ( tipoEvaluacion == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoEvaluacionEstadoId( tipoEvaluacion );
        id = tipoEvaluacion.getId();
        nombre = tipoEvaluacion.getNombre();
        descripcion = tipoEvaluacion.getDescripcion();

        TipoEvaluacionDTO tipoEvaluacionDTO = new TipoEvaluacionDTO( id, nombre, descripcion, estadoId );

        return tipoEvaluacionDTO;
    }

    @Override
    public TipoEvaluacion toEntity(TipoEvaluacionDTO tipoEvaluacionDTO) {
        if ( tipoEvaluacionDTO == null ) {
            return null;
        }

        TipoEvaluacion.TipoEvaluacionBuilder tipoEvaluacion = TipoEvaluacion.builder();

        tipoEvaluacion.estado( tipoEvaluacionDTOToEstado( tipoEvaluacionDTO ) );
        tipoEvaluacion.id( tipoEvaluacionDTO.getId() );
        tipoEvaluacion.nombre( tipoEvaluacionDTO.getNombre() );
        tipoEvaluacion.descripcion( tipoEvaluacionDTO.getDescripcion() );

        return tipoEvaluacion.build();
    }

    private Long tipoEvaluacionEstadoId(TipoEvaluacion tipoEvaluacion) {
        Estado estado = tipoEvaluacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Estado tipoEvaluacionDTOToEstado(TipoEvaluacionDTO tipoEvaluacionDTO) {
        if ( tipoEvaluacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoEvaluacionDTO.getEstadoId() );

        return estado.build();
    }
}
