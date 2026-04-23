package com.vantory.produccionDesarrollo.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.fase.Fase;
import com.vantory.produccionDesarrollo.ProduccionDesarrollo;
import com.vantory.produccionDesarrollo.dtos.ProduccionDesarrolloDTO;
import com.vantory.tipoMedicion.TipoMedicion;
import com.vantory.variedad.Variedad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProduccionDesarrolloMapperImpl implements ProduccionDesarrolloMapper {

    @Override
    public ProduccionDesarrolloDTO toDto(ProduccionDesarrollo produccionDesarrollo) {
        if ( produccionDesarrollo == null ) {
            return null;
        }

        ProduccionDesarrolloDTO.ProduccionDesarrolloDTOBuilder produccionDesarrolloDTO = ProduccionDesarrolloDTO.builder();

        produccionDesarrolloDTO.variedadId( produccionDesarrolloVariedadId( produccionDesarrollo ) );
        produccionDesarrolloDTO.faseId( produccionDesarrolloFaseId( produccionDesarrollo ) );
        produccionDesarrolloDTO.tipoMedicionId( produccionDesarrolloTipoMedicionId( produccionDesarrollo ) );
        produccionDesarrolloDTO.estadoId( produccionDesarrolloEstadoId( produccionDesarrollo ) );
        produccionDesarrolloDTO.empresaId( produccionDesarrolloEmpresaId( produccionDesarrollo ) );
        produccionDesarrolloDTO.id( produccionDesarrollo.getId() );
        produccionDesarrolloDTO.descripcion( produccionDesarrollo.getDescripcion() );
        if ( produccionDesarrollo.getValor() != null ) {
            produccionDesarrolloDTO.valor( produccionDesarrollo.getValor().intValue() );
        }

        return produccionDesarrolloDTO.build();
    }

    @Override
    public ProduccionDesarrollo toEntity(ProduccionDesarrolloDTO produccionDesarrolloDTO) {
        if ( produccionDesarrolloDTO == null ) {
            return null;
        }

        ProduccionDesarrollo.ProduccionDesarrolloBuilder produccionDesarrollo = ProduccionDesarrollo.builder();

        produccionDesarrollo.variedad( produccionDesarrolloDTOToVariedad( produccionDesarrolloDTO ) );
        produccionDesarrollo.fase( produccionDesarrolloDTOToFase( produccionDesarrolloDTO ) );
        produccionDesarrollo.tipoMedicion( produccionDesarrolloDTOToTipoMedicion( produccionDesarrolloDTO ) );
        produccionDesarrollo.estado( produccionDesarrolloDTOToEstado( produccionDesarrolloDTO ) );
        produccionDesarrollo.empresa( produccionDesarrolloDTOToEmpresa( produccionDesarrolloDTO ) );
        produccionDesarrollo.id( produccionDesarrolloDTO.getId() );
        produccionDesarrollo.descripcion( produccionDesarrolloDTO.getDescripcion() );
        if ( produccionDesarrolloDTO.getValor() != null ) {
            produccionDesarrollo.valor( produccionDesarrolloDTO.getValor().doubleValue() );
        }

        return produccionDesarrollo.build();
    }

    @Override
    public ProduccionDesarrolloDTO toListDTO(ProduccionDesarrollo produccionDesarrollo) {
        if ( produccionDesarrollo == null ) {
            return null;
        }

        ProduccionDesarrolloDTO.ProduccionDesarrolloDTOBuilder produccionDesarrolloDTO = ProduccionDesarrolloDTO.builder();

        produccionDesarrolloDTO.variedadId( produccionDesarrolloVariedadId( produccionDesarrollo ) );
        produccionDesarrolloDTO.faseId( produccionDesarrolloFaseId( produccionDesarrollo ) );
        produccionDesarrolloDTO.tipoMedicionId( produccionDesarrolloTipoMedicionId( produccionDesarrollo ) );
        produccionDesarrolloDTO.estadoId( produccionDesarrolloEstadoId( produccionDesarrollo ) );
        produccionDesarrolloDTO.id( produccionDesarrollo.getId() );
        produccionDesarrolloDTO.descripcion( produccionDesarrollo.getDescripcion() );
        if ( produccionDesarrollo.getValor() != null ) {
            produccionDesarrolloDTO.valor( produccionDesarrollo.getValor().intValue() );
        }

        return produccionDesarrolloDTO.build();
    }

    private Long produccionDesarrolloVariedadId(ProduccionDesarrollo produccionDesarrollo) {
        Variedad variedad = produccionDesarrollo.getVariedad();
        if ( variedad == null ) {
            return null;
        }
        return variedad.getId();
    }

    private Long produccionDesarrolloFaseId(ProduccionDesarrollo produccionDesarrollo) {
        Fase fase = produccionDesarrollo.getFase();
        if ( fase == null ) {
            return null;
        }
        return fase.getId();
    }

    private Long produccionDesarrolloTipoMedicionId(ProduccionDesarrollo produccionDesarrollo) {
        TipoMedicion tipoMedicion = produccionDesarrollo.getTipoMedicion();
        if ( tipoMedicion == null ) {
            return null;
        }
        return tipoMedicion.getId();
    }

    private Long produccionDesarrolloEstadoId(ProduccionDesarrollo produccionDesarrollo) {
        Estado estado = produccionDesarrollo.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long produccionDesarrolloEmpresaId(ProduccionDesarrollo produccionDesarrollo) {
        Empresa empresa = produccionDesarrollo.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Variedad produccionDesarrolloDTOToVariedad(ProduccionDesarrolloDTO produccionDesarrolloDTO) {
        if ( produccionDesarrolloDTO == null ) {
            return null;
        }

        Variedad.VariedadBuilder variedad = Variedad.builder();

        variedad.id( produccionDesarrolloDTO.getVariedadId() );

        return variedad.build();
    }

    protected Fase produccionDesarrolloDTOToFase(ProduccionDesarrolloDTO produccionDesarrolloDTO) {
        if ( produccionDesarrolloDTO == null ) {
            return null;
        }

        Fase.FaseBuilder fase = Fase.builder();

        fase.id( produccionDesarrolloDTO.getFaseId() );

        return fase.build();
    }

    protected TipoMedicion produccionDesarrolloDTOToTipoMedicion(ProduccionDesarrolloDTO produccionDesarrolloDTO) {
        if ( produccionDesarrolloDTO == null ) {
            return null;
        }

        TipoMedicion.TipoMedicionBuilder tipoMedicion = TipoMedicion.builder();

        tipoMedicion.id( produccionDesarrolloDTO.getTipoMedicionId() );

        return tipoMedicion.build();
    }

    protected Estado produccionDesarrolloDTOToEstado(ProduccionDesarrolloDTO produccionDesarrolloDTO) {
        if ( produccionDesarrolloDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( produccionDesarrolloDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa produccionDesarrolloDTOToEmpresa(ProduccionDesarrolloDTO produccionDesarrolloDTO) {
        if ( produccionDesarrolloDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( produccionDesarrolloDTO.getEmpresaId() );

        return empresa.build();
    }
}
