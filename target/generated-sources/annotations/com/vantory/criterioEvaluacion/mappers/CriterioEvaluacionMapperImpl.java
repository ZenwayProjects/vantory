package com.vantory.criterioEvaluacion.mappers;

import com.vantory.criterioEvaluacion.CriterioEvaluacion;
import com.vantory.criterioEvaluacion.dtos.CriterioEvaluacionDTO;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.tipoEvaluacion.TipoEvaluacion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CriterioEvaluacionMapperImpl implements CriterioEvaluacionMapper {

    @Override
    public CriterioEvaluacionDTO toDTO(CriterioEvaluacion criterioEvaluacion) {
        if ( criterioEvaluacion == null ) {
            return null;
        }

        Long tipoEvaluacionId = null;
        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        tipoEvaluacionId = criterioEvaluacionTipoEvaluacionId( criterioEvaluacion );
        estadoId = criterioEvaluacionEstadoId( criterioEvaluacion );
        empresaId = criterioEvaluacionEmpresaId( criterioEvaluacion );
        id = criterioEvaluacion.getId();
        nombre = criterioEvaluacion.getNombre();
        descripcion = criterioEvaluacion.getDescripcion();

        CriterioEvaluacionDTO criterioEvaluacionDTO = new CriterioEvaluacionDTO( id, nombre, descripcion, tipoEvaluacionId, estadoId, empresaId );

        return criterioEvaluacionDTO;
    }

    @Override
    public CriterioEvaluacion toEntity(CriterioEvaluacionDTO criterioEvaluacionDTO) {
        if ( criterioEvaluacionDTO == null ) {
            return null;
        }

        CriterioEvaluacion.CriterioEvaluacionBuilder criterioEvaluacion = CriterioEvaluacion.builder();

        criterioEvaluacion.tipoEvaluacion( criterioEvaluacionDTOToTipoEvaluacion( criterioEvaluacionDTO ) );
        criterioEvaluacion.estado( criterioEvaluacionDTOToEstado( criterioEvaluacionDTO ) );
        criterioEvaluacion.empresa( criterioEvaluacionDTOToEmpresa( criterioEvaluacionDTO ) );
        criterioEvaluacion.id( criterioEvaluacionDTO.getId() );
        criterioEvaluacion.nombre( criterioEvaluacionDTO.getNombre() );
        criterioEvaluacion.descripcion( criterioEvaluacionDTO.getDescripcion() );

        return criterioEvaluacion.build();
    }

    @Override
    public CriterioEvaluacionDTO toListDTO(CriterioEvaluacion criterioEvaluacion) {
        if ( criterioEvaluacion == null ) {
            return null;
        }

        Long tipoEvaluacionId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        tipoEvaluacionId = criterioEvaluacionTipoEvaluacionId( criterioEvaluacion );
        estadoId = criterioEvaluacionEstadoId( criterioEvaluacion );
        id = criterioEvaluacion.getId();
        nombre = criterioEvaluacion.getNombre();
        descripcion = criterioEvaluacion.getDescripcion();

        Long empresaId = null;

        CriterioEvaluacionDTO criterioEvaluacionDTO = new CriterioEvaluacionDTO( id, nombre, descripcion, tipoEvaluacionId, estadoId, empresaId );

        return criterioEvaluacionDTO;
    }

    private Long criterioEvaluacionTipoEvaluacionId(CriterioEvaluacion criterioEvaluacion) {
        TipoEvaluacion tipoEvaluacion = criterioEvaluacion.getTipoEvaluacion();
        if ( tipoEvaluacion == null ) {
            return null;
        }
        return tipoEvaluacion.getId();
    }

    private Long criterioEvaluacionEstadoId(CriterioEvaluacion criterioEvaluacion) {
        Estado estado = criterioEvaluacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long criterioEvaluacionEmpresaId(CriterioEvaluacion criterioEvaluacion) {
        Empresa empresa = criterioEvaluacion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected TipoEvaluacion criterioEvaluacionDTOToTipoEvaluacion(CriterioEvaluacionDTO criterioEvaluacionDTO) {
        if ( criterioEvaluacionDTO == null ) {
            return null;
        }

        TipoEvaluacion.TipoEvaluacionBuilder tipoEvaluacion = TipoEvaluacion.builder();

        tipoEvaluacion.id( criterioEvaluacionDTO.getTipoEvaluacionId() );

        return tipoEvaluacion.build();
    }

    protected Estado criterioEvaluacionDTOToEstado(CriterioEvaluacionDTO criterioEvaluacionDTO) {
        if ( criterioEvaluacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( criterioEvaluacionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa criterioEvaluacionDTOToEmpresa(CriterioEvaluacionDTO criterioEvaluacionDTO) {
        if ( criterioEvaluacionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( criterioEvaluacionDTO.getEmpresaId() );

        return empresa.build();
    }
}
