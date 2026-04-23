package com.vantory.tipoModelo.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoModelo.TipoModelo;
import com.vantory.tipoModelo.dtos.TipoModeloDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoModeloMapperImpl implements TipoModeloMapper {

    @Override
    public TipoModeloDTO toDto(TipoModelo tipoModelo) {
        if ( tipoModelo == null ) {
            return null;
        }

        TipoModeloDTO.TipoModeloDTOBuilder tipoModeloDTO = TipoModeloDTO.builder();

        tipoModeloDTO.estadoId( tipoModeloEstadoId( tipoModelo ) );
        tipoModeloDTO.empresaId( tipoModeloEmpresaId( tipoModelo ) );
        tipoModeloDTO.id( tipoModelo.getId() );
        tipoModeloDTO.nombre( tipoModelo.getNombre() );
        tipoModeloDTO.descripcion( tipoModelo.getDescripcion() );

        return tipoModeloDTO.build();
    }

    @Override
    public TipoModelo toEntity(TipoModeloDTO tipoModeloDTO) {
        if ( tipoModeloDTO == null ) {
            return null;
        }

        TipoModelo.TipoModeloBuilder tipoModelo = TipoModelo.builder();

        tipoModelo.estado( tipoModeloDTOToEstado( tipoModeloDTO ) );
        tipoModelo.empresa( tipoModeloDTOToEmpresa( tipoModeloDTO ) );
        tipoModelo.id( tipoModeloDTO.getId() );
        tipoModelo.nombre( tipoModeloDTO.getNombre() );
        tipoModelo.descripcion( tipoModeloDTO.getDescripcion() );

        return tipoModelo.build();
    }

    @Override
    public TipoModeloDTO toListDTO(TipoModelo tipoModelo) {
        if ( tipoModelo == null ) {
            return null;
        }

        TipoModeloDTO.TipoModeloDTOBuilder tipoModeloDTO = TipoModeloDTO.builder();

        tipoModeloDTO.estadoId( tipoModeloEstadoId( tipoModelo ) );
        tipoModeloDTO.id( tipoModelo.getId() );
        tipoModeloDTO.nombre( tipoModelo.getNombre() );
        tipoModeloDTO.descripcion( tipoModelo.getDescripcion() );

        return tipoModeloDTO.build();
    }

    private Long tipoModeloEstadoId(TipoModelo tipoModelo) {
        Estado estado = tipoModelo.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long tipoModeloEmpresaId(TipoModelo tipoModelo) {
        Empresa empresa = tipoModelo.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado tipoModeloDTOToEstado(TipoModeloDTO tipoModeloDTO) {
        if ( tipoModeloDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoModeloDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoModeloDTOToEmpresa(TipoModeloDTO tipoModeloDTO) {
        if ( tipoModeloDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoModeloDTO.getEmpresaId() );

        return empresa.build();
    }
}
