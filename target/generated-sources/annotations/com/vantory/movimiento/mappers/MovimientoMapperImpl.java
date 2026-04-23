package com.vantory.movimiento.mappers;

import com.vantory.estado.Estado;
import com.vantory.movimiento.Movimiento;
import com.vantory.movimiento.dtos.MovimientoDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class MovimientoMapperImpl implements MovimientoMapper {

    @Override
    public MovimientoDTO toDTO(Movimiento movimiento) {
        if ( movimiento == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;

        estadoId = movimientoEstadoId( movimiento );
        id = movimiento.getId();
        nombre = movimiento.getNombre();

        MovimientoDTO movimientoDTO = new MovimientoDTO( id, nombre, estadoId );

        return movimientoDTO;
    }

    @Override
    public Movimiento toEntity(MovimientoDTO movimientoDTO) {
        if ( movimientoDTO == null ) {
            return null;
        }

        Movimiento.MovimientoBuilder movimiento = Movimiento.builder();

        movimiento.estado( movimientoDTOToEstado( movimientoDTO ) );
        movimiento.id( movimientoDTO.getId() );
        movimiento.nombre( movimientoDTO.getNombre() );

        return movimiento.build();
    }

    private Long movimientoEstadoId(Movimiento movimiento) {
        Estado estado = movimiento.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Estado movimientoDTOToEstado(MovimientoDTO movimientoDTO) {
        if ( movimientoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( movimientoDTO.getEstadoId() );

        return estado.build();
    }
}
