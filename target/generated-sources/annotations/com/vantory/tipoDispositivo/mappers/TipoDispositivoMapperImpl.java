package com.vantory.tipoDispositivo.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoDispositivo.TipoDispositivo;
import com.vantory.tipoDispositivo.dtos.TipoDispositivoDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoDispositivoMapperImpl implements TipoDispositivoMapper {

    @Override
    public TipoDispositivoDTO toDto(TipoDispositivo tipoDispositivo) {
        if ( tipoDispositivo == null ) {
            return null;
        }

        TipoDispositivoDTO.TipoDispositivoDTOBuilder tipoDispositivoDTO = TipoDispositivoDTO.builder();

        tipoDispositivoDTO.estadoId( tipoDispositivoEstadoId( tipoDispositivo ) );
        tipoDispositivoDTO.empresaId( tipoDispositivoEmpresaId( tipoDispositivo ) );
        tipoDispositivoDTO.id( tipoDispositivo.getId() );
        tipoDispositivoDTO.nombre( tipoDispositivo.getNombre() );
        tipoDispositivoDTO.descripcion( tipoDispositivo.getDescripcion() );

        return tipoDispositivoDTO.build();
    }

    @Override
    public TipoDispositivo toEntity(TipoDispositivoDTO tipoDispositivoDTO) {
        if ( tipoDispositivoDTO == null ) {
            return null;
        }

        TipoDispositivo.TipoDispositivoBuilder tipoDispositivo = TipoDispositivo.builder();

        tipoDispositivo.estado( tipoDispositivoDTOToEstado( tipoDispositivoDTO ) );
        tipoDispositivo.empresa( tipoDispositivoDTOToEmpresa( tipoDispositivoDTO ) );
        tipoDispositivo.id( tipoDispositivoDTO.getId() );
        tipoDispositivo.nombre( tipoDispositivoDTO.getNombre() );
        tipoDispositivo.descripcion( tipoDispositivoDTO.getDescripcion() );

        return tipoDispositivo.build();
    }

    @Override
    public TipoDispositivoDTO toListDTO(TipoDispositivo tipoDispositivo) {
        if ( tipoDispositivo == null ) {
            return null;
        }

        TipoDispositivoDTO.TipoDispositivoDTOBuilder tipoDispositivoDTO = TipoDispositivoDTO.builder();

        tipoDispositivoDTO.estadoId( tipoDispositivoEstadoId( tipoDispositivo ) );
        tipoDispositivoDTO.id( tipoDispositivo.getId() );
        tipoDispositivoDTO.nombre( tipoDispositivo.getNombre() );
        tipoDispositivoDTO.descripcion( tipoDispositivo.getDescripcion() );

        return tipoDispositivoDTO.build();
    }

    private Long tipoDispositivoEstadoId(TipoDispositivo tipoDispositivo) {
        Estado estado = tipoDispositivo.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long tipoDispositivoEmpresaId(TipoDispositivo tipoDispositivo) {
        Empresa empresa = tipoDispositivo.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado tipoDispositivoDTOToEstado(TipoDispositivoDTO tipoDispositivoDTO) {
        if ( tipoDispositivoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoDispositivoDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoDispositivoDTOToEmpresa(TipoDispositivoDTO tipoDispositivoDTO) {
        if ( tipoDispositivoDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoDispositivoDTO.getEmpresaId() );

        return empresa.build();
    }
}
