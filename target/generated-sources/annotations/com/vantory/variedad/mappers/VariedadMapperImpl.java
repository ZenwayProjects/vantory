package com.vantory.variedad.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoProduccion.TipoProduccion;
import com.vantory.variedad.Variedad;
import com.vantory.variedad.dtos.VariedadDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class VariedadMapperImpl implements VariedadMapper {

    @Override
    public VariedadDTO toDto(Variedad variedad) {
        if ( variedad == null ) {
            return null;
        }

        VariedadDTO.VariedadDTOBuilder variedadDTO = VariedadDTO.builder();

        variedadDTO.tipoProduccionId( variedadTipoProduccionId( variedad ) );
        variedadDTO.estadoId( variedadEstadoId( variedad ) );
        variedadDTO.empresaId( variedadEmpresaId( variedad ) );
        variedadDTO.id( variedad.getId() );
        variedadDTO.nombre( variedad.getNombre() );
        variedadDTO.descripcion( variedad.getDescripcion() );

        return variedadDTO.build();
    }

    @Override
    public Variedad toEntity(VariedadDTO variedadDTO) {
        if ( variedadDTO == null ) {
            return null;
        }

        Variedad.VariedadBuilder variedad = Variedad.builder();

        variedad.tipoProduccion( variedadDTOToTipoProduccion( variedadDTO ) );
        variedad.estado( variedadDTOToEstado( variedadDTO ) );
        variedad.empresa( variedadDTOToEmpresa( variedadDTO ) );
        variedad.id( variedadDTO.getId() );
        variedad.nombre( variedadDTO.getNombre() );
        variedad.descripcion( variedadDTO.getDescripcion() );

        return variedad.build();
    }

    @Override
    public VariedadDTO toListDTO(Variedad variedad) {
        if ( variedad == null ) {
            return null;
        }

        VariedadDTO.VariedadDTOBuilder variedadDTO = VariedadDTO.builder();

        variedadDTO.tipoProduccionId( variedadTipoProduccionId( variedad ) );
        variedadDTO.estadoId( variedadEstadoId( variedad ) );
        variedadDTO.id( variedad.getId() );
        variedadDTO.nombre( variedad.getNombre() );
        variedadDTO.descripcion( variedad.getDescripcion() );

        return variedadDTO.build();
    }

    private Long variedadTipoProduccionId(Variedad variedad) {
        TipoProduccion tipoProduccion = variedad.getTipoProduccion();
        if ( tipoProduccion == null ) {
            return null;
        }
        return tipoProduccion.getId();
    }

    private Long variedadEstadoId(Variedad variedad) {
        Estado estado = variedad.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long variedadEmpresaId(Variedad variedad) {
        Empresa empresa = variedad.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected TipoProduccion variedadDTOToTipoProduccion(VariedadDTO variedadDTO) {
        if ( variedadDTO == null ) {
            return null;
        }

        TipoProduccion.TipoProduccionBuilder tipoProduccion = TipoProduccion.builder();

        tipoProduccion.id( variedadDTO.getTipoProduccionId() );

        return tipoProduccion.build();
    }

    protected Estado variedadDTOToEstado(VariedadDTO variedadDTO) {
        if ( variedadDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( variedadDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa variedadDTOToEmpresa(VariedadDTO variedadDTO) {
        if ( variedadDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( variedadDTO.getEmpresaId() );

        return empresa.build();
    }
}
