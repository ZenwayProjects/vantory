package com.vantory.espacioOcupacion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.espacio.Espacio;
import com.vantory.espacioOcupacion.EspacioOcupacion;
import com.vantory.espacioOcupacion.dtos.EspacioOcupacionDTO;
import com.vantory.estado.Estado;
import com.vantory.ocupacion.Ocupacion;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EspacioOcupacionMapperImpl implements EspacioOcupacionMapper {

    @Override
    public EspacioOcupacionDTO toDTO(EspacioOcupacion espacioOcupacion) {
        if ( espacioOcupacion == null ) {
            return null;
        }

        Long espacioId = null;
        Long ocupacionId = null;
        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        LocalDateTime fechaInicio = null;
        LocalDateTime fechaFin = null;

        espacioId = espacioOcupacionEspacioId( espacioOcupacion );
        ocupacionId = espacioOcupacionOcupacionId( espacioOcupacion );
        estadoId = espacioOcupacionEstadoId( espacioOcupacion );
        empresaId = espacioOcupacionEmpresaId( espacioOcupacion );
        id = espacioOcupacion.getId();
        fechaInicio = espacioOcupacion.getFechaInicio();
        fechaFin = espacioOcupacion.getFechaFin();

        EspacioOcupacionDTO espacioOcupacionDTO = new EspacioOcupacionDTO( id, espacioId, ocupacionId, fechaInicio, fechaFin, estadoId, empresaId );

        return espacioOcupacionDTO;
    }

    @Override
    public EspacioOcupacion toEntity(EspacioOcupacionDTO espacioOcupacionDTO) {
        if ( espacioOcupacionDTO == null ) {
            return null;
        }

        EspacioOcupacion.EspacioOcupacionBuilder espacioOcupacion = EspacioOcupacion.builder();

        espacioOcupacion.espacio( espacioOcupacionDTOToEspacio( espacioOcupacionDTO ) );
        espacioOcupacion.ocupacion( espacioOcupacionDTOToOcupacion( espacioOcupacionDTO ) );
        espacioOcupacion.estado( espacioOcupacionDTOToEstado( espacioOcupacionDTO ) );
        espacioOcupacion.empresa( espacioOcupacionDTOToEmpresa( espacioOcupacionDTO ) );
        espacioOcupacion.id( espacioOcupacionDTO.getId() );
        espacioOcupacion.fechaInicio( espacioOcupacionDTO.getFechaInicio() );
        espacioOcupacion.fechaFin( espacioOcupacionDTO.getFechaFin() );

        return espacioOcupacion.build();
    }

    private Long espacioOcupacionEspacioId(EspacioOcupacion espacioOcupacion) {
        Espacio espacio = espacioOcupacion.getEspacio();
        if ( espacio == null ) {
            return null;
        }
        return espacio.getId();
    }

    private Long espacioOcupacionOcupacionId(EspacioOcupacion espacioOcupacion) {
        Ocupacion ocupacion = espacioOcupacion.getOcupacion();
        if ( ocupacion == null ) {
            return null;
        }
        return ocupacion.getId();
    }

    private Long espacioOcupacionEstadoId(EspacioOcupacion espacioOcupacion) {
        Estado estado = espacioOcupacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long espacioOcupacionEmpresaId(EspacioOcupacion espacioOcupacion) {
        Empresa empresa = espacioOcupacion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Espacio espacioOcupacionDTOToEspacio(EspacioOcupacionDTO espacioOcupacionDTO) {
        if ( espacioOcupacionDTO == null ) {
            return null;
        }

        Espacio.EspacioBuilder espacio = Espacio.builder();

        espacio.id( espacioOcupacionDTO.getEspacioId() );

        return espacio.build();
    }

    protected Ocupacion espacioOcupacionDTOToOcupacion(EspacioOcupacionDTO espacioOcupacionDTO) {
        if ( espacioOcupacionDTO == null ) {
            return null;
        }

        Ocupacion.OcupacionBuilder ocupacion = Ocupacion.builder();

        ocupacion.id( espacioOcupacionDTO.getOcupacionId() );

        return ocupacion.build();
    }

    protected Estado espacioOcupacionDTOToEstado(EspacioOcupacionDTO espacioOcupacionDTO) {
        if ( espacioOcupacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( espacioOcupacionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa espacioOcupacionDTOToEmpresa(EspacioOcupacionDTO espacioOcupacionDTO) {
        if ( espacioOcupacionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( espacioOcupacionDTO.getEmpresaId() );

        return empresa.build();
    }
}
