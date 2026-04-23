package com.vantory.fase.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.fase.Fase;
import com.vantory.fase.dtos.FaseDTO;
import com.vantory.tipoFase.TipoFase;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class FaseMapperImpl implements FaseMapper {

    @Override
    public FaseDTO toDto(Fase fase) {
        if ( fase == null ) {
            return null;
        }

        FaseDTO.FaseDTOBuilder faseDTO = FaseDTO.builder();

        faseDTO.tipoFaseId( faseTipoFaseId( fase ) );
        faseDTO.estadoId( faseEstadoId( fase ) );
        faseDTO.empresaId( faseEmpresaId( fase ) );
        faseDTO.id( fase.getId() );
        faseDTO.nombre( fase.getNombre() );
        faseDTO.descripcion( fase.getDescripcion() );

        return faseDTO.build();
    }

    @Override
    public Fase toEntity(FaseDTO faseDTO) {
        if ( faseDTO == null ) {
            return null;
        }

        Fase.FaseBuilder fase = Fase.builder();

        fase.tipoFase( faseDTOToTipoFase( faseDTO ) );
        fase.estado( faseDTOToEstado( faseDTO ) );
        fase.empresa( faseDTOToEmpresa( faseDTO ) );
        fase.id( faseDTO.getId() );
        fase.nombre( faseDTO.getNombre() );
        fase.descripcion( faseDTO.getDescripcion() );

        return fase.build();
    }

    @Override
    public FaseDTO toListDTO(Fase fase) {
        if ( fase == null ) {
            return null;
        }

        FaseDTO.FaseDTOBuilder faseDTO = FaseDTO.builder();

        faseDTO.tipoFaseId( faseTipoFaseId( fase ) );
        faseDTO.estadoId( faseEstadoId( fase ) );
        faseDTO.id( fase.getId() );
        faseDTO.nombre( fase.getNombre() );
        faseDTO.descripcion( fase.getDescripcion() );

        return faseDTO.build();
    }

    private Long faseTipoFaseId(Fase fase) {
        TipoFase tipoFase = fase.getTipoFase();
        if ( tipoFase == null ) {
            return null;
        }
        return tipoFase.getId();
    }

    private Long faseEstadoId(Fase fase) {
        Estado estado = fase.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long faseEmpresaId(Fase fase) {
        Empresa empresa = fase.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected TipoFase faseDTOToTipoFase(FaseDTO faseDTO) {
        if ( faseDTO == null ) {
            return null;
        }

        TipoFase.TipoFaseBuilder tipoFase = TipoFase.builder();

        tipoFase.id( faseDTO.getTipoFaseId() );

        return tipoFase.build();
    }

    protected Estado faseDTOToEstado(FaseDTO faseDTO) {
        if ( faseDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( faseDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa faseDTOToEmpresa(FaseDTO faseDTO) {
        if ( faseDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( faseDTO.getEmpresaId() );

        return empresa.build();
    }
}
