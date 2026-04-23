package com.vantory.tipoBloque.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoBloque.TipoBloque;
import com.vantory.tipoBloque.dtos.TipoBloqueDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoBloqueMapperImpl implements TipoBloqueMapper {

    @Override
    public TipoBloqueDTO toDTO(TipoBloque tipoBloque) {
        if ( tipoBloque == null ) {
            return null;
        }

        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoBloqueEstadoId( tipoBloque );
        empresaId = tipoBloqueEmpresaId( tipoBloque );
        id = tipoBloque.getId();
        nombre = tipoBloque.getNombre();
        descripcion = tipoBloque.getDescripcion();

        TipoBloqueDTO tipoBloqueDTO = new TipoBloqueDTO( id, nombre, descripcion, estadoId, empresaId );

        return tipoBloqueDTO;
    }

    @Override
    public TipoBloqueDTO toMinimalDTO(TipoBloque tipoBloque) {
        if ( tipoBloque == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;

        id = tipoBloque.getId();
        nombre = tipoBloque.getNombre();

        Long empresaId = null;
        Long estadoId = null;
        String descripcion = null;

        TipoBloqueDTO tipoBloqueDTO = new TipoBloqueDTO( id, nombre, descripcion, estadoId, empresaId );

        return tipoBloqueDTO;
    }

    @Override
    public TipoBloque toEntity(TipoBloqueDTO tipoBloqueDTO) {
        if ( tipoBloqueDTO == null ) {
            return null;
        }

        TipoBloque.TipoBloqueBuilder tipoBloque = TipoBloque.builder();

        tipoBloque.estado( tipoBloqueDTOToEstado( tipoBloqueDTO ) );
        tipoBloque.empresa( tipoBloqueDTOToEmpresa( tipoBloqueDTO ) );
        tipoBloque.id( tipoBloqueDTO.getId() );
        tipoBloque.nombre( tipoBloqueDTO.getNombre() );
        tipoBloque.descripcion( tipoBloqueDTO.getDescripcion() );

        TipoBloque tipoBloqueResult = tipoBloque.build();

        setEstadoAfterMapping( tipoBloqueResult, tipoBloqueDTO );

        return tipoBloqueResult;
    }

    private Long tipoBloqueEstadoId(TipoBloque tipoBloque) {
        Estado estado = tipoBloque.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long tipoBloqueEmpresaId(TipoBloque tipoBloque) {
        Empresa empresa = tipoBloque.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado tipoBloqueDTOToEstado(TipoBloqueDTO tipoBloqueDTO) {
        if ( tipoBloqueDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoBloqueDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoBloqueDTOToEmpresa(TipoBloqueDTO tipoBloqueDTO) {
        if ( tipoBloqueDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoBloqueDTO.getEmpresaId() );

        return empresa.build();
    }
}
