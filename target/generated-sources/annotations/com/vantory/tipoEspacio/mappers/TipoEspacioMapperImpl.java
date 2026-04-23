package com.vantory.tipoEspacio.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoEspacio.TipoEspacio;
import com.vantory.tipoEspacio.dtos.TipoEspacioDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoEspacioMapperImpl implements TipoEspacioMapper {

    @Override
    public TipoEspacioDTO toDTO(TipoEspacio tipoEspacio) {
        if ( tipoEspacio == null ) {
            return null;
        }

        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoEspacioEstadoId( tipoEspacio );
        empresaId = tipoEspacioEmpresaId( tipoEspacio );
        id = tipoEspacio.getId();
        nombre = tipoEspacio.getNombre();
        descripcion = tipoEspacio.getDescripcion();

        TipoEspacioDTO tipoEspacioDTO = new TipoEspacioDTO( id, nombre, descripcion, estadoId, empresaId );

        return tipoEspacioDTO;
    }

    @Override
    public TipoEspacio toEntity(TipoEspacioDTO tipoEspacioDTO) {
        if ( tipoEspacioDTO == null ) {
            return null;
        }

        TipoEspacio.TipoEspacioBuilder tipoEspacio = TipoEspacio.builder();

        tipoEspacio.estado( tipoEspacioDTOToEstado( tipoEspacioDTO ) );
        tipoEspacio.empresa( tipoEspacioDTOToEmpresa( tipoEspacioDTO ) );
        tipoEspacio.id( tipoEspacioDTO.getId() );
        tipoEspacio.nombre( tipoEspacioDTO.getNombre() );
        tipoEspacio.descripcion( tipoEspacioDTO.getDescripcion() );

        return tipoEspacio.build();
    }

    @Override
    public TipoEspacioDTO toListDto(TipoEspacio tipoEspacio) {
        if ( tipoEspacio == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoEspacioEstadoId( tipoEspacio );
        id = tipoEspacio.getId();
        nombre = tipoEspacio.getNombre();
        descripcion = tipoEspacio.getDescripcion();

        Long empresaId = null;

        TipoEspacioDTO tipoEspacioDTO = new TipoEspacioDTO( id, nombre, descripcion, estadoId, empresaId );

        return tipoEspacioDTO;
    }

    private Long tipoEspacioEstadoId(TipoEspacio tipoEspacio) {
        Estado estado = tipoEspacio.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long tipoEspacioEmpresaId(TipoEspacio tipoEspacio) {
        Empresa empresa = tipoEspacio.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado tipoEspacioDTOToEstado(TipoEspacioDTO tipoEspacioDTO) {
        if ( tipoEspacioDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoEspacioDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoEspacioDTOToEmpresa(TipoEspacioDTO tipoEspacioDTO) {
        if ( tipoEspacioDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoEspacioDTO.getEmpresaId() );

        return empresa.build();
    }
}
