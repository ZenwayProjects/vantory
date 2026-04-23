package com.vantory.tipoMedicion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.produccion.Produccion;
import com.vantory.tipoMedicion.TipoMedicion;
import com.vantory.tipoMedicion.dtos.TipoMedicionDTO;
import com.vantory.unidad.Unidad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoMedicionMapperImpl implements TipoMedicionMapper {

    @Override
    public TipoMedicionDTO toDto(TipoMedicion tipoMedicion) {
        if ( tipoMedicion == null ) {
            return null;
        }

        TipoMedicionDTO.TipoMedicionDTOBuilder tipoMedicionDTO = TipoMedicionDTO.builder();

        tipoMedicionDTO.unidadId( tipoMedicionUnidadId( tipoMedicion ) );
        tipoMedicionDTO.produccionId( tipoMedicionProduccionId( tipoMedicion ) );
        tipoMedicionDTO.estadoId( tipoMedicionEstadoId( tipoMedicion ) );
        tipoMedicionDTO.empresaId( tipoMedicionEmpresaId( tipoMedicion ) );
        tipoMedicionDTO.id( tipoMedicion.getId() );
        tipoMedicionDTO.nombre( tipoMedicion.getNombre() );
        tipoMedicionDTO.descripcion( tipoMedicion.getDescripcion() );

        return tipoMedicionDTO.build();
    }

    @Override
    public TipoMedicion toEntity(TipoMedicionDTO tipoMedicionDTO) {
        if ( tipoMedicionDTO == null ) {
            return null;
        }

        TipoMedicion.TipoMedicionBuilder tipoMedicion = TipoMedicion.builder();

        tipoMedicion.unidad( tipoMedicionDTOToUnidad( tipoMedicionDTO ) );
        tipoMedicion.produccion( tipoMedicionDTOToProduccion( tipoMedicionDTO ) );
        tipoMedicion.estado( tipoMedicionDTOToEstado( tipoMedicionDTO ) );
        tipoMedicion.empresa( tipoMedicionDTOToEmpresa( tipoMedicionDTO ) );
        tipoMedicion.id( tipoMedicionDTO.getId() );
        tipoMedicion.nombre( tipoMedicionDTO.getNombre() );
        tipoMedicion.descripcion( tipoMedicionDTO.getDescripcion() );

        return tipoMedicion.build();
    }

    @Override
    public TipoMedicionDTO toListDTO(TipoMedicion tipoMedicion) {
        if ( tipoMedicion == null ) {
            return null;
        }

        TipoMedicionDTO.TipoMedicionDTOBuilder tipoMedicionDTO = TipoMedicionDTO.builder();

        tipoMedicionDTO.unidadId( tipoMedicionUnidadId( tipoMedicion ) );
        tipoMedicionDTO.produccionId( tipoMedicionProduccionId( tipoMedicion ) );
        tipoMedicionDTO.estadoId( tipoMedicionEstadoId( tipoMedicion ) );
        tipoMedicionDTO.id( tipoMedicion.getId() );
        tipoMedicionDTO.nombre( tipoMedicion.getNombre() );
        tipoMedicionDTO.descripcion( tipoMedicion.getDescripcion() );

        return tipoMedicionDTO.build();
    }

    private Long tipoMedicionUnidadId(TipoMedicion tipoMedicion) {
        Unidad unidad = tipoMedicion.getUnidad();
        if ( unidad == null ) {
            return null;
        }
        return unidad.getId();
    }

    private Long tipoMedicionProduccionId(TipoMedicion tipoMedicion) {
        Produccion produccion = tipoMedicion.getProduccion();
        if ( produccion == null ) {
            return null;
        }
        return produccion.getId();
    }

    private Long tipoMedicionEstadoId(TipoMedicion tipoMedicion) {
        Estado estado = tipoMedicion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long tipoMedicionEmpresaId(TipoMedicion tipoMedicion) {
        Empresa empresa = tipoMedicion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Unidad tipoMedicionDTOToUnidad(TipoMedicionDTO tipoMedicionDTO) {
        if ( tipoMedicionDTO == null ) {
            return null;
        }

        Unidad.UnidadBuilder unidad = Unidad.builder();

        unidad.id( tipoMedicionDTO.getUnidadId() );

        return unidad.build();
    }

    protected Produccion tipoMedicionDTOToProduccion(TipoMedicionDTO tipoMedicionDTO) {
        if ( tipoMedicionDTO == null ) {
            return null;
        }

        Produccion.ProduccionBuilder produccion = Produccion.builder();

        produccion.id( tipoMedicionDTO.getProduccionId() );

        return produccion.build();
    }

    protected Estado tipoMedicionDTOToEstado(TipoMedicionDTO tipoMedicionDTO) {
        if ( tipoMedicionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoMedicionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoMedicionDTOToEmpresa(TipoMedicionDTO tipoMedicionDTO) {
        if ( tipoMedicionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoMedicionDTO.getEmpresaId() );

        return empresa.build();
    }
}
