package com.vantory.ocupacion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.evaluacion.Evaluacion;
import com.vantory.ocupacion.Ocupacion;
import com.vantory.ocupacion.dtos.OcupacionDTO;
import com.vantory.tipoActividad.TipoActividad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class OcupacionMapperImpl implements OcupacionMapper {

    @Override
    public OcupacionDTO toDTO(Ocupacion ocupacion) {
        if ( ocupacion == null ) {
            return null;
        }

        OcupacionDTO.OcupacionDTOBuilder ocupacionDTO = OcupacionDTO.builder();

        ocupacionDTO.tipoActividadId( ocupacionTipoActividadId( ocupacion ) );
        ocupacionDTO.evaluacionId( ocupacionEvaluacionId( ocupacion ) );
        ocupacionDTO.estadoId( ocupacionEstadoId( ocupacion ) );
        ocupacionDTO.empresaId( ocupacionEmpresaId( ocupacion ) );
        ocupacionDTO.id( ocupacion.getId() );
        ocupacionDTO.nombre( ocupacion.getNombre() );

        return ocupacionDTO.build();
    }

    @Override
    public Ocupacion toEntity(OcupacionDTO ocupacionDTO) {
        if ( ocupacionDTO == null ) {
            return null;
        }

        Ocupacion.OcupacionBuilder ocupacion = Ocupacion.builder();

        ocupacion.tipoActividad( ocupacionDTOToTipoActividad( ocupacionDTO ) );
        ocupacion.evaluacion( ocupacionDTOToEvaluacion( ocupacionDTO ) );
        ocupacion.estado( ocupacionDTOToEstado( ocupacionDTO ) );
        ocupacion.empresa( ocupacionDTOToEmpresa( ocupacionDTO ) );
        ocupacion.id( ocupacionDTO.getId() );
        ocupacion.nombre( ocupacionDTO.getNombre() );

        return ocupacion.build();
    }

    @Override
    public OcupacionDTO toListDTO(Ocupacion ocupacion) {
        if ( ocupacion == null ) {
            return null;
        }

        OcupacionDTO.OcupacionDTOBuilder ocupacionDTO = OcupacionDTO.builder();

        ocupacionDTO.tipoActividadId( ocupacionTipoActividadId( ocupacion ) );
        ocupacionDTO.evaluacionId( ocupacionEvaluacionId( ocupacion ) );
        ocupacionDTO.estadoId( ocupacionEstadoId( ocupacion ) );
        ocupacionDTO.id( ocupacion.getId() );
        ocupacionDTO.nombre( ocupacion.getNombre() );

        return ocupacionDTO.build();
    }

    private Long ocupacionTipoActividadId(Ocupacion ocupacion) {
        TipoActividad tipoActividad = ocupacion.getTipoActividad();
        if ( tipoActividad == null ) {
            return null;
        }
        return tipoActividad.getId();
    }

    private Long ocupacionEvaluacionId(Ocupacion ocupacion) {
        Evaluacion evaluacion = ocupacion.getEvaluacion();
        if ( evaluacion == null ) {
            return null;
        }
        return evaluacion.getId();
    }

    private Long ocupacionEstadoId(Ocupacion ocupacion) {
        Estado estado = ocupacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long ocupacionEmpresaId(Ocupacion ocupacion) {
        Empresa empresa = ocupacion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected TipoActividad ocupacionDTOToTipoActividad(OcupacionDTO ocupacionDTO) {
        if ( ocupacionDTO == null ) {
            return null;
        }

        TipoActividad.TipoActividadBuilder tipoActividad = TipoActividad.builder();

        tipoActividad.id( ocupacionDTO.getTipoActividadId() );

        return tipoActividad.build();
    }

    protected Evaluacion ocupacionDTOToEvaluacion(OcupacionDTO ocupacionDTO) {
        if ( ocupacionDTO == null ) {
            return null;
        }

        Evaluacion.EvaluacionBuilder evaluacion = Evaluacion.builder();

        evaluacion.id( ocupacionDTO.getEvaluacionId() );

        return evaluacion.build();
    }

    protected Estado ocupacionDTOToEstado(OcupacionDTO ocupacionDTO) {
        if ( ocupacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( ocupacionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa ocupacionDTOToEmpresa(OcupacionDTO ocupacionDTO) {
        if ( ocupacionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( ocupacionDTO.getEmpresaId() );

        return empresa.build();
    }
}
