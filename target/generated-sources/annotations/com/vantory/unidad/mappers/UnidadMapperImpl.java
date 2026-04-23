package com.vantory.unidad.mappers;

import com.vantory.estado.Estado;
import com.vantory.tipounidad.TipoUnidad;
import com.vantory.unidad.Unidad;
import com.vantory.unidad.dtos.UnidadDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UnidadMapperImpl implements UnidadMapper {

    @Override
    public UnidadDTO toDTO(Unidad unidad) {
        if ( unidad == null ) {
            return null;
        }

        Long estadoId = null;
        Long tipoUnidadId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = unidadEstadoId( unidad );
        tipoUnidadId = unidadTipoUnidadId( unidad );
        id = unidad.getId();
        nombre = unidad.getNombre();
        descripcion = unidad.getDescripcion();

        UnidadDTO unidadDTO = new UnidadDTO( id, nombre, descripcion, estadoId, tipoUnidadId );

        return unidadDTO;
    }

    @Override
    public Unidad toEntity(UnidadDTO unidadDTO) {
        if ( unidadDTO == null ) {
            return null;
        }

        Unidad.UnidadBuilder unidad = Unidad.builder();

        unidad.estado( unidadDTOToEstado( unidadDTO ) );
        unidad.tipoUnidad( unidadDTOToTipoUnidad( unidadDTO ) );
        unidad.id( unidadDTO.getId() );
        unidad.nombre( unidadDTO.getNombre() );
        unidad.descripcion( unidadDTO.getDescripcion() );

        return unidad.build();
    }

    private Long unidadEstadoId(Unidad unidad) {
        Estado estado = unidad.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long unidadTipoUnidadId(Unidad unidad) {
        TipoUnidad tipoUnidad = unidad.getTipoUnidad();
        if ( tipoUnidad == null ) {
            return null;
        }
        return tipoUnidad.getId();
    }

    protected Estado unidadDTOToEstado(UnidadDTO unidadDTO) {
        if ( unidadDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( unidadDTO.getEstadoId() );

        return estado.build();
    }

    protected TipoUnidad unidadDTOToTipoUnidad(UnidadDTO unidadDTO) {
        if ( unidadDTO == null ) {
            return null;
        }

        TipoUnidad.TipoUnidadBuilder tipoUnidad = TipoUnidad.builder();

        tipoUnidad.id( unidadDTO.getTipoUnidadId() );

        return tipoUnidad.build();
    }
}
