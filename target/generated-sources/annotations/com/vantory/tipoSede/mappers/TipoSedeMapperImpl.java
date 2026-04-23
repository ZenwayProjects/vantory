package com.vantory.tipoSede.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoSede.TipoSede;
import com.vantory.tipoSede.dtos.TipoSedeDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoSedeMapperImpl implements TipoSedeMapper {

    @Override
    public TipoSedeDTO toDTO(TipoSede tipoSede) {
        if ( tipoSede == null ) {
            return null;
        }

        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoSedeEstadoId( tipoSede );
        empresaId = tipoSedeEmpresaId( tipoSede );
        id = tipoSede.getId();
        nombre = tipoSede.getNombre();
        descripcion = tipoSede.getDescripcion();

        TipoSedeDTO tipoSedeDTO = new TipoSedeDTO( id, nombre, descripcion, estadoId, empresaId );

        return tipoSedeDTO;
    }

    @Override
    public TipoSedeDTO toListDTO(TipoSede tipoSede) {
        if ( tipoSede == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoSedeEstadoId( tipoSede );
        id = tipoSede.getId();
        nombre = tipoSede.getNombre();
        descripcion = tipoSede.getDescripcion();

        Long empresaId = null;

        TipoSedeDTO tipoSedeDTO = new TipoSedeDTO( id, nombre, descripcion, estadoId, empresaId );

        return tipoSedeDTO;
    }

    @Override
    public TipoSede toEntity(TipoSedeDTO tipoSedeDTO) {
        if ( tipoSedeDTO == null ) {
            return null;
        }

        TipoSede.TipoSedeBuilder tipoSede = TipoSede.builder();

        tipoSede.estado( tipoSedeDTOToEstado( tipoSedeDTO ) );
        tipoSede.empresa( tipoSedeDTOToEmpresa( tipoSedeDTO ) );
        tipoSede.id( tipoSedeDTO.getId() );
        tipoSede.nombre( tipoSedeDTO.getNombre() );
        tipoSede.descripcion( tipoSedeDTO.getDescripcion() );

        return tipoSede.build();
    }

    private Long tipoSedeEstadoId(TipoSede tipoSede) {
        Estado estado = tipoSede.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long tipoSedeEmpresaId(TipoSede tipoSede) {
        Empresa empresa = tipoSede.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado tipoSedeDTOToEstado(TipoSedeDTO tipoSedeDTO) {
        if ( tipoSedeDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoSedeDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoSedeDTOToEmpresa(TipoSedeDTO tipoSedeDTO) {
        if ( tipoSedeDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoSedeDTO.getEmpresaId() );

        return empresa.build();
    }
}
