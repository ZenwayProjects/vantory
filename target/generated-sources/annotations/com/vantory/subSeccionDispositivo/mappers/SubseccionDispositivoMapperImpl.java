package com.vantory.subSeccionDispositivo.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.subSeccionDispositivo.SubseccionDispositivo;
import com.vantory.subSeccionDispositivo.dtos.SubseccionDispositivoDTO;
import com.vantory.subseccion.Subseccion;
import com.vantory.tipoDispositivo.TipoDispositivo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SubseccionDispositivoMapperImpl implements SubseccionDispositivoMapper {

    @Override
    public SubseccionDispositivoDTO toDto(SubseccionDispositivo subseccionDispositivo) {
        if ( subseccionDispositivo == null ) {
            return null;
        }

        SubseccionDispositivoDTO.SubseccionDispositivoDTOBuilder subseccionDispositivoDTO = SubseccionDispositivoDTO.builder();

        subseccionDispositivoDTO.subseccionId( subseccionDispositivoSubseccionId( subseccionDispositivo ) );
        subseccionDispositivoDTO.tipoDispositivoId( subseccionDispositivoTipoDispositivoId( subseccionDispositivo ) );
        subseccionDispositivoDTO.estadoId( subseccionDispositivoEstadoId( subseccionDispositivo ) );
        subseccionDispositivoDTO.empresaId( subseccionDispositivoEmpresaId( subseccionDispositivo ) );
        subseccionDispositivoDTO.id( subseccionDispositivo.getId() );
        subseccionDispositivoDTO.nombre( subseccionDispositivo.getNombre() );
        subseccionDispositivoDTO.descripcion( subseccionDispositivo.getDescripcion() );

        return subseccionDispositivoDTO.build();
    }

    @Override
    public SubseccionDispositivo toEntity(SubseccionDispositivoDTO subSeccionDispositivoDTO) {
        if ( subSeccionDispositivoDTO == null ) {
            return null;
        }

        SubseccionDispositivo.SubseccionDispositivoBuilder subseccionDispositivo = SubseccionDispositivo.builder();

        subseccionDispositivo.subseccion( subseccionDispositivoDTOToSubseccion( subSeccionDispositivoDTO ) );
        subseccionDispositivo.tipoDispositivo( subseccionDispositivoDTOToTipoDispositivo( subSeccionDispositivoDTO ) );
        subseccionDispositivo.estado( subseccionDispositivoDTOToEstado( subSeccionDispositivoDTO ) );
        subseccionDispositivo.empresa( subseccionDispositivoDTOToEmpresa( subSeccionDispositivoDTO ) );
        subseccionDispositivo.id( subSeccionDispositivoDTO.getId() );
        subseccionDispositivo.nombre( subSeccionDispositivoDTO.getNombre() );
        subseccionDispositivo.descripcion( subSeccionDispositivoDTO.getDescripcion() );

        return subseccionDispositivo.build();
    }

    @Override
    public SubseccionDispositivoDTO toListDTO(SubseccionDispositivo subseccionDispositivo) {
        if ( subseccionDispositivo == null ) {
            return null;
        }

        SubseccionDispositivoDTO.SubseccionDispositivoDTOBuilder subseccionDispositivoDTO = SubseccionDispositivoDTO.builder();

        subseccionDispositivoDTO.subseccionId( subseccionDispositivoSubseccionId( subseccionDispositivo ) );
        subseccionDispositivoDTO.tipoDispositivoId( subseccionDispositivoTipoDispositivoId( subseccionDispositivo ) );
        subseccionDispositivoDTO.estadoId( subseccionDispositivoEstadoId( subseccionDispositivo ) );
        subseccionDispositivoDTO.id( subseccionDispositivo.getId() );
        subseccionDispositivoDTO.nombre( subseccionDispositivo.getNombre() );
        subseccionDispositivoDTO.descripcion( subseccionDispositivo.getDescripcion() );

        return subseccionDispositivoDTO.build();
    }

    private Long subseccionDispositivoSubseccionId(SubseccionDispositivo subseccionDispositivo) {
        Subseccion subseccion = subseccionDispositivo.getSubseccion();
        if ( subseccion == null ) {
            return null;
        }
        return subseccion.getId();
    }

    private Long subseccionDispositivoTipoDispositivoId(SubseccionDispositivo subseccionDispositivo) {
        TipoDispositivo tipoDispositivo = subseccionDispositivo.getTipoDispositivo();
        if ( tipoDispositivo == null ) {
            return null;
        }
        return tipoDispositivo.getId();
    }

    private Long subseccionDispositivoEstadoId(SubseccionDispositivo subseccionDispositivo) {
        Estado estado = subseccionDispositivo.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long subseccionDispositivoEmpresaId(SubseccionDispositivo subseccionDispositivo) {
        Empresa empresa = subseccionDispositivo.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Subseccion subseccionDispositivoDTOToSubseccion(SubseccionDispositivoDTO subseccionDispositivoDTO) {
        if ( subseccionDispositivoDTO == null ) {
            return null;
        }

        Subseccion.SubseccionBuilder subseccion = Subseccion.builder();

        subseccion.id( subseccionDispositivoDTO.getSubseccionId() );

        return subseccion.build();
    }

    protected TipoDispositivo subseccionDispositivoDTOToTipoDispositivo(SubseccionDispositivoDTO subseccionDispositivoDTO) {
        if ( subseccionDispositivoDTO == null ) {
            return null;
        }

        TipoDispositivo.TipoDispositivoBuilder tipoDispositivo = TipoDispositivo.builder();

        tipoDispositivo.id( subseccionDispositivoDTO.getTipoDispositivoId() );

        return tipoDispositivo.build();
    }

    protected Estado subseccionDispositivoDTOToEstado(SubseccionDispositivoDTO subseccionDispositivoDTO) {
        if ( subseccionDispositivoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( subseccionDispositivoDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa subseccionDispositivoDTOToEmpresa(SubseccionDispositivoDTO subseccionDispositivoDTO) {
        if ( subseccionDispositivoDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( subseccionDispositivoDTO.getEmpresaId() );

        return empresa.build();
    }
}
