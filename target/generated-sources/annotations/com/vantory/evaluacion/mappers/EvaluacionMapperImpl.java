package com.vantory.evaluacion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.evaluacion.Evaluacion;
import com.vantory.evaluacion.dtos.EvaluacionDTO;
import com.vantory.tipoEvaluacion.TipoEvaluacion;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EvaluacionMapperImpl implements EvaluacionMapper {

    @Override
    public EvaluacionDTO toDTO(Evaluacion evaluacion) {
        if ( evaluacion == null ) {
            return null;
        }

        Long tipoEvaluacionId = null;
        Long empresaId = null;
        Long estadoId = null;
        Long id = null;
        LocalDateTime fechaHora = null;
        Integer idEntidadEvaluada = null;

        tipoEvaluacionId = evaluacionTipoEvaluacionId( evaluacion );
        empresaId = evaluacionEmpresaId( evaluacion );
        estadoId = evaluacionEstadoId( evaluacion );
        id = evaluacion.getId();
        fechaHora = evaluacion.getFechaHora();
        idEntidadEvaluada = evaluacion.getIdEntidadEvaluada();

        EvaluacionDTO evaluacionDTO = new EvaluacionDTO( id, fechaHora, idEntidadEvaluada, tipoEvaluacionId, estadoId, empresaId );

        return evaluacionDTO;
    }

    @Override
    public Evaluacion toEntity(EvaluacionDTO evaluacionDTO) {
        if ( evaluacionDTO == null ) {
            return null;
        }

        Evaluacion.EvaluacionBuilder evaluacion = Evaluacion.builder();

        evaluacion.tipoEvaluacion( evaluacionDTOToTipoEvaluacion( evaluacionDTO ) );
        evaluacion.empresa( evaluacionDTOToEmpresa( evaluacionDTO ) );
        evaluacion.estado( evaluacionDTOToEstado( evaluacionDTO ) );
        evaluacion.id( evaluacionDTO.getId() );
        evaluacion.fechaHora( evaluacionDTO.getFechaHora() );
        evaluacion.idEntidadEvaluada( evaluacionDTO.getIdEntidadEvaluada() );

        return evaluacion.build();
    }

    @Override
    public EvaluacionDTO toListDTO(Evaluacion evaluacion) {
        if ( evaluacion == null ) {
            return null;
        }

        Long tipoEvaluacionId = null;
        Long estadoId = null;
        Long id = null;
        LocalDateTime fechaHora = null;
        Integer idEntidadEvaluada = null;

        tipoEvaluacionId = evaluacionTipoEvaluacionId( evaluacion );
        estadoId = evaluacionEstadoId( evaluacion );
        id = evaluacion.getId();
        fechaHora = evaluacion.getFechaHora();
        idEntidadEvaluada = evaluacion.getIdEntidadEvaluada();

        Long empresaId = null;

        EvaluacionDTO evaluacionDTO = new EvaluacionDTO( id, fechaHora, idEntidadEvaluada, tipoEvaluacionId, estadoId, empresaId );

        return evaluacionDTO;
    }

    private Long evaluacionTipoEvaluacionId(Evaluacion evaluacion) {
        TipoEvaluacion tipoEvaluacion = evaluacion.getTipoEvaluacion();
        if ( tipoEvaluacion == null ) {
            return null;
        }
        return tipoEvaluacion.getId();
    }

    private Long evaluacionEmpresaId(Evaluacion evaluacion) {
        Empresa empresa = evaluacion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long evaluacionEstadoId(Evaluacion evaluacion) {
        Estado estado = evaluacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected TipoEvaluacion evaluacionDTOToTipoEvaluacion(EvaluacionDTO evaluacionDTO) {
        if ( evaluacionDTO == null ) {
            return null;
        }

        TipoEvaluacion.TipoEvaluacionBuilder tipoEvaluacion = TipoEvaluacion.builder();

        tipoEvaluacion.id( evaluacionDTO.getTipoEvaluacionId() );

        return tipoEvaluacion.build();
    }

    protected Empresa evaluacionDTOToEmpresa(EvaluacionDTO evaluacionDTO) {
        if ( evaluacionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( evaluacionDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Estado evaluacionDTOToEstado(EvaluacionDTO evaluacionDTO) {
        if ( evaluacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( evaluacionDTO.getEstadoId() );

        return estado.build();
    }
}
