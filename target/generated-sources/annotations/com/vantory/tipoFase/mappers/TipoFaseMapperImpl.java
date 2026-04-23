package com.vantory.tipoFase.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoFase.TipoFase;
import com.vantory.tipoFase.dtos.TipoFaseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoFaseMapperImpl implements TipoFaseMapper {

    @Override
    public TipoFaseDTO toDto(TipoFase tipoFase) {
        if ( tipoFase == null ) {
            return null;
        }

        TipoFaseDTO.TipoFaseDTOBuilder tipoFaseDTO = TipoFaseDTO.builder();

        tipoFaseDTO.estadoId( tipoFaseEstadoId( tipoFase ) );
        tipoFaseDTO.empresaId( tipoFaseEmpresaId( tipoFase ) );
        tipoFaseDTO.id( tipoFase.getId() );
        tipoFaseDTO.nombre( tipoFase.getNombre() );
        tipoFaseDTO.descripcion( tipoFase.getDescripcion() );

        return tipoFaseDTO.build();
    }

    @Override
    public TipoFase toEntity(TipoFaseDTO tipoFaseDTO) {
        if ( tipoFaseDTO == null ) {
            return null;
        }

        TipoFase.TipoFaseBuilder tipoFase = TipoFase.builder();

        tipoFase.estado( tipoFaseDTOToEstado( tipoFaseDTO ) );
        tipoFase.empresa( tipoFaseDTOToEmpresa( tipoFaseDTO ) );
        tipoFase.id( tipoFaseDTO.getId() );
        tipoFase.nombre( tipoFaseDTO.getNombre() );
        tipoFase.descripcion( tipoFaseDTO.getDescripcion() );

        return tipoFase.build();
    }

    @Override
    public TipoFaseDTO toListDTO(TipoFase tipoFase) {
        if ( tipoFase == null ) {
            return null;
        }

        TipoFaseDTO.TipoFaseDTOBuilder tipoFaseDTO = TipoFaseDTO.builder();

        tipoFaseDTO.estadoId( tipoFaseEstadoId( tipoFase ) );
        tipoFaseDTO.id( tipoFase.getId() );
        tipoFaseDTO.nombre( tipoFase.getNombre() );
        tipoFaseDTO.descripcion( tipoFase.getDescripcion() );

        return tipoFaseDTO.build();
    }

    private Long tipoFaseEstadoId(TipoFase tipoFase) {
        Estado estado = tipoFase.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long tipoFaseEmpresaId(TipoFase tipoFase) {
        Empresa empresa = tipoFase.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado tipoFaseDTOToEstado(TipoFaseDTO tipoFaseDTO) {
        if ( tipoFaseDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoFaseDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoFaseDTOToEmpresa(TipoFaseDTO tipoFaseDTO) {
        if ( tipoFaseDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoFaseDTO.getEmpresaId() );

        return empresa.build();
    }
}
