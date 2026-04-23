package com.vantory.programacion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.programacion.Programacion;
import com.vantory.programacion.dtos.ProgramacionDTO;
import com.vantory.subSeccionDispositivo.SubseccionDispositivo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProgramacionMapperImpl implements ProgramacionMapper {

    @Override
    public ProgramacionDTO toDto(Programacion programacion) {
        if ( programacion == null ) {
            return null;
        }

        ProgramacionDTO.ProgramacionDTOBuilder programacionDTO = ProgramacionDTO.builder();

        programacionDTO.subseccionDispositivoId( programacionSubseccionDispositivoId( programacion ) );
        programacionDTO.estadoId( programacionEstadoId( programacion ) );
        programacionDTO.empresaId( programacionEmpresaId( programacion ) );
        programacionDTO.id( programacion.getId() );
        programacionDTO.descripcion( programacion.getDescripcion() );
        programacionDTO.comando( programacion.getComando() );
        programacionDTO.fechaHora( programacion.getFechaHora() );

        return programacionDTO.build();
    }

    @Override
    public Programacion toEntity(ProgramacionDTO programacionDTO) {
        if ( programacionDTO == null ) {
            return null;
        }

        Programacion.ProgramacionBuilder programacion = Programacion.builder();

        programacion.subseccionDispositivo( programacionDTOToSubseccionDispositivo( programacionDTO ) );
        programacion.estado( programacionDTOToEstado( programacionDTO ) );
        programacion.empresa( programacionDTOToEmpresa( programacionDTO ) );
        programacion.id( programacionDTO.getId() );
        programacion.descripcion( programacionDTO.getDescripcion() );
        programacion.comando( programacionDTO.getComando() );
        programacion.fechaHora( programacionDTO.getFechaHora() );

        return programacion.build();
    }

    @Override
    public ProgramacionDTO toListDTO(Programacion programacion) {
        if ( programacion == null ) {
            return null;
        }

        ProgramacionDTO.ProgramacionDTOBuilder programacionDTO = ProgramacionDTO.builder();

        programacionDTO.subseccionDispositivoId( programacionSubseccionDispositivoId( programacion ) );
        programacionDTO.estadoId( programacionEstadoId( programacion ) );
        programacionDTO.empresaId( programacionEmpresaId( programacion ) );
        programacionDTO.id( programacion.getId() );
        programacionDTO.descripcion( programacion.getDescripcion() );
        programacionDTO.comando( programacion.getComando() );
        programacionDTO.fechaHora( programacion.getFechaHora() );

        return programacionDTO.build();
    }

    private Long programacionSubseccionDispositivoId(Programacion programacion) {
        SubseccionDispositivo subseccionDispositivo = programacion.getSubseccionDispositivo();
        if ( subseccionDispositivo == null ) {
            return null;
        }
        return subseccionDispositivo.getId();
    }

    private Long programacionEstadoId(Programacion programacion) {
        Estado estado = programacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long programacionEmpresaId(Programacion programacion) {
        Empresa empresa = programacion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected SubseccionDispositivo programacionDTOToSubseccionDispositivo(ProgramacionDTO programacionDTO) {
        if ( programacionDTO == null ) {
            return null;
        }

        SubseccionDispositivo.SubseccionDispositivoBuilder subseccionDispositivo = SubseccionDispositivo.builder();

        subseccionDispositivo.id( programacionDTO.getSubseccionDispositivoId() );

        return subseccionDispositivo.build();
    }

    protected Estado programacionDTOToEstado(ProgramacionDTO programacionDTO) {
        if ( programacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( programacionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa programacionDTOToEmpresa(ProgramacionDTO programacionDTO) {
        if ( programacionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( programacionDTO.getEmpresaId() );

        return empresa.build();
    }
}
