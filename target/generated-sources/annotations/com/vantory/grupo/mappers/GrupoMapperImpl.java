package com.vantory.grupo.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.grupo.Grupo;
import com.vantory.grupo.dtos.GrupoDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class GrupoMapperImpl implements GrupoMapper {

    @Override
    public GrupoDTO toDTO(Grupo grupo) {
        if ( grupo == null ) {
            return null;
        }

        Long empresaId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        empresaId = grupoEmpresaId( grupo );
        estadoId = grupoEstadoId( grupo );
        id = grupo.getId();
        nombre = grupo.getNombre();
        descripcion = grupo.getDescripcion();

        GrupoDTO grupoDTO = new GrupoDTO( id, nombre, empresaId, descripcion, estadoId );

        return grupoDTO;
    }

    @Override
    public Grupo toEntity(GrupoDTO grupoDTO) {
        if ( grupoDTO == null ) {
            return null;
        }

        Grupo.GrupoBuilder grupo = Grupo.builder();

        grupo.empresa( grupoDTOToEmpresa( grupoDTO ) );
        grupo.estado( grupoDTOToEstado( grupoDTO ) );
        grupo.id( grupoDTO.getId() );
        grupo.nombre( grupoDTO.getNombre() );
        grupo.descripcion( grupoDTO.getDescripcion() );

        return grupo.build();
    }

    @Override
    public GrupoDTO toListDto(Grupo grupo) {
        if ( grupo == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = grupoEstadoId( grupo );
        id = grupo.getId();
        nombre = grupo.getNombre();
        descripcion = grupo.getDescripcion();

        Long empresaId = null;

        GrupoDTO grupoDTO = new GrupoDTO( id, nombre, empresaId, descripcion, estadoId );

        return grupoDTO;
    }

    private Long grupoEmpresaId(Grupo grupo) {
        Empresa empresa = grupo.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long grupoEstadoId(Grupo grupo) {
        Estado estado = grupo.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Empresa grupoDTOToEmpresa(GrupoDTO grupoDTO) {
        if ( grupoDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( grupoDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Estado grupoDTOToEstado(GrupoDTO grupoDTO) {
        if ( grupoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( grupoDTO.getEstadoId() );

        return estado.build();
    }
}
