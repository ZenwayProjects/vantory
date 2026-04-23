package com.vantory.tipoMovimiento.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.movimiento.Movimiento;
import com.vantory.tipoMovimiento.TipoMovimiento;
import com.vantory.tipoMovimiento.dtos.TipoMovimientoDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoMovimientoMapperImpl implements TipoMovimientoMapper {

    @Override
    public TipoMovimientoDTO toDto(TipoMovimiento tipoMovimiento) {
        if ( tipoMovimiento == null ) {
            return null;
        }

        Long estadoId = null;
        Long empresaId = null;
        Long movimientoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoMovimientoEstadoId( tipoMovimiento );
        empresaId = tipoMovimientoEmpresaId( tipoMovimiento );
        movimientoId = tipoMovimientoMovimientoId( tipoMovimiento );
        id = tipoMovimiento.getId();
        nombre = tipoMovimiento.getNombre();
        descripcion = tipoMovimiento.getDescripcion();

        TipoMovimientoDTO tipoMovimientoDTO = new TipoMovimientoDTO( id, nombre, descripcion, estadoId, empresaId, movimientoId );

        return tipoMovimientoDTO;
    }

    @Override
    public TipoMovimiento toEntity(TipoMovimientoDTO tipoMovimientoDTO) {
        if ( tipoMovimientoDTO == null ) {
            return null;
        }

        TipoMovimiento.TipoMovimientoBuilder tipoMovimiento = TipoMovimiento.builder();

        tipoMovimiento.estado( tipoMovimientoDTOToEstado( tipoMovimientoDTO ) );
        tipoMovimiento.empresa( tipoMovimientoDTOToEmpresa( tipoMovimientoDTO ) );
        tipoMovimiento.movimiento( tipoMovimientoDTOToMovimiento( tipoMovimientoDTO ) );
        tipoMovimiento.id( tipoMovimientoDTO.getId() );
        tipoMovimiento.nombre( tipoMovimientoDTO.getNombre() );
        tipoMovimiento.descripcion( tipoMovimientoDTO.getDescripcion() );

        return tipoMovimiento.build();
    }

    private Long tipoMovimientoEstadoId(TipoMovimiento tipoMovimiento) {
        Estado estado = tipoMovimiento.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long tipoMovimientoEmpresaId(TipoMovimiento tipoMovimiento) {
        Empresa empresa = tipoMovimiento.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long tipoMovimientoMovimientoId(TipoMovimiento tipoMovimiento) {
        Movimiento movimiento = tipoMovimiento.getMovimiento();
        if ( movimiento == null ) {
            return null;
        }
        return movimiento.getId();
    }

    protected Estado tipoMovimientoDTOToEstado(TipoMovimientoDTO tipoMovimientoDTO) {
        if ( tipoMovimientoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoMovimientoDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoMovimientoDTOToEmpresa(TipoMovimientoDTO tipoMovimientoDTO) {
        if ( tipoMovimientoDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoMovimientoDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Movimiento tipoMovimientoDTOToMovimiento(TipoMovimientoDTO tipoMovimientoDTO) {
        if ( tipoMovimientoDTO == null ) {
            return null;
        }

        Movimiento.MovimientoBuilder movimiento = Movimiento.builder();

        movimiento.id( tipoMovimientoDTO.getMovimientoId() );

        return movimiento.build();
    }
}
