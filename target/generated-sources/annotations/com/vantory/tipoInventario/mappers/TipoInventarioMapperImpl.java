package com.vantory.tipoInventario.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoInventario.TipoInventario;
import com.vantory.tipoInventario.dtos.TipoInventarioDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class TipoInventarioMapperImpl implements TipoInventarioMapper {

    @Override
    public TipoInventarioDTO toDTO(TipoInventario tipoInventario) {
        if ( tipoInventario == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = tipoInventarioEstadoId( tipoInventario );
        id = tipoInventario.getId();
        nombre = tipoInventario.getNombre();
        descripcion = tipoInventario.getDescripcion();

        Long empresaId = null;

        TipoInventarioDTO tipoInventarioDTO = new TipoInventarioDTO( id, nombre, descripcion, estadoId, empresaId );

        return tipoInventarioDTO;
    }

    @Override
    public TipoInventario toEntity(TipoInventarioDTO tipoInventarioDTO) {
        if ( tipoInventarioDTO == null ) {
            return null;
        }

        TipoInventario.TipoInventarioBuilder tipoInventario = TipoInventario.builder();

        tipoInventario.estado( tipoInventarioDTOToEstado( tipoInventarioDTO ) );
        tipoInventario.empresa( tipoInventarioDTOToEmpresa( tipoInventarioDTO ) );
        tipoInventario.id( tipoInventarioDTO.getId() );
        tipoInventario.nombre( tipoInventarioDTO.getNombre() );
        tipoInventario.descripcion( tipoInventarioDTO.getDescripcion() );

        return tipoInventario.build();
    }

    private Long tipoInventarioEstadoId(TipoInventario tipoInventario) {
        Estado estado = tipoInventario.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Estado tipoInventarioDTOToEstado(TipoInventarioDTO tipoInventarioDTO) {
        if ( tipoInventarioDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( tipoInventarioDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa tipoInventarioDTOToEmpresa(TipoInventarioDTO tipoInventarioDTO) {
        if ( tipoInventarioDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( tipoInventarioDTO.getEmpresaId() );

        return empresa.build();
    }
}
