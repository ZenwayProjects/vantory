package com.vantory.tipoProduccion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoProduccion.TipoProduccion;
import com.vantory.tipoProduccion.dtos.TipoProduccionDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoProduccionMapperImpl implements TipoProduccionMapper {

    @Override
    public TipoProduccionDTO toDTO(TipoProduccion tipoProduccion) {
        if ( tipoProduccion == null ) {
            return null;
        }

        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoProduccionEstadoId( tipoProduccion );
        empresaId = tipoProduccionEmpresaId( tipoProduccion );
        id = tipoProduccion.getId();
        nombre = tipoProduccion.getNombre();
        descripcion = tipoProduccion.getDescripcion();

        TipoProduccionDTO tipoProduccionDTO = new TipoProduccionDTO( id, nombre, descripcion, estadoId, empresaId );

        return tipoProduccionDTO;
    }

    @Override
    public TipoProduccion toEntity(TipoProduccionDTO tipoProduccionDTO) {
        if ( tipoProduccionDTO == null ) {
            return null;
        }

        TipoProduccion.TipoProduccionBuilder tipoProduccion = TipoProduccion.builder();

        tipoProduccion.estado( tipoProduccionDTOToEstado( tipoProduccionDTO ) );
        tipoProduccion.empresa( tipoProduccionDTOToEmpresa( tipoProduccionDTO ) );
        tipoProduccion.id( tipoProduccionDTO.getId() );
        tipoProduccion.nombre( tipoProduccionDTO.getNombre() );
        tipoProduccion.descripcion( tipoProduccionDTO.getDescripcion() );

        return tipoProduccion.build();
    }

    @Override
    public TipoProduccionDTO toListDTO(TipoProduccion tipoProduccion) {
        if ( tipoProduccion == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoProduccionEstadoId( tipoProduccion );
        id = tipoProduccion.getId();
        nombre = tipoProduccion.getNombre();
        descripcion = tipoProduccion.getDescripcion();

        Long empresaId = null;

        TipoProduccionDTO tipoProduccionDTO = new TipoProduccionDTO( id, nombre, descripcion, estadoId, empresaId );

        return tipoProduccionDTO;
    }

    private Long tipoProduccionEstadoId(TipoProduccion tipoProduccion) {
        Estado estado = tipoProduccion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long tipoProduccionEmpresaId(TipoProduccion tipoProduccion) {
        Empresa empresa = tipoProduccion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado tipoProduccionDTOToEstado(TipoProduccionDTO tipoProduccionDTO) {
        if ( tipoProduccionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoProduccionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoProduccionDTOToEmpresa(TipoProduccionDTO tipoProduccionDTO) {
        if ( tipoProduccionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoProduccionDTO.getEmpresaId() );

        return empresa.build();
    }
}
