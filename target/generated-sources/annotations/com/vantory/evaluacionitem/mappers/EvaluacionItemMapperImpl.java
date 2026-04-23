package com.vantory.evaluacionitem.mappers;

import com.vantory.criterioEvaluacion.CriterioEvaluacion;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.evaluacion.Evaluacion;
import com.vantory.evaluacionitem.EvaluacionItem;
import com.vantory.evaluacionitem.dtos.EvaluacionItemCreateDTO;
import com.vantory.evaluacionitem.dtos.EvaluacionItemResponseDTO;
import com.vantory.evaluacionitem.dtos.EvaluacionItemUpdateDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:59-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EvaluacionItemMapperImpl implements EvaluacionItemMapper {

    @Override
    public EvaluacionItem toEntity(EvaluacionItemCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        EvaluacionItem.EvaluacionItemBuilder evaluacionItem = EvaluacionItem.builder();

        evaluacionItem.valor( dto.getValor() );
        evaluacionItem.descripcion( dto.getDescripcion() );

        return evaluacionItem.build();
    }

    @Override
    public EvaluacionItemResponseDTO toResponseDTO(EvaluacionItem entity) {
        if ( entity == null ) {
            return null;
        }

        EvaluacionItemResponseDTO evaluacionItemResponseDTO = new EvaluacionItemResponseDTO();

        evaluacionItemResponseDTO.setEstadoId( entityEstadoId( entity ) );
        evaluacionItemResponseDTO.setEmpresaId( entityEmpresaId( entity ) );
        evaluacionItemResponseDTO.setEvaluacionId( entityEvaluacionId( entity ) );
        evaluacionItemResponseDTO.setCriterioEvaluacionId( entityCriterioEvaluacionId( entity ) );
        evaluacionItemResponseDTO.setId( entity.getId() );
        evaluacionItemResponseDTO.setValor( entity.getValor() );
        evaluacionItemResponseDTO.setDescripcion( entity.getDescripcion() );

        return evaluacionItemResponseDTO;
    }

    @Override
    public void updateEntityFromDTO(EvaluacionItemUpdateDTO dto, EvaluacionItem entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getValor() != null ) {
            entity.setValor( dto.getValor() );
        }
        if ( dto.getDescripcion() != null ) {
            entity.setDescripcion( dto.getDescripcion() );
        }
    }

    private Long entityEstadoId(EvaluacionItem evaluacionItem) {
        Estado estado = evaluacionItem.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long entityEmpresaId(EvaluacionItem evaluacionItem) {
        Empresa empresa = evaluacionItem.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long entityEvaluacionId(EvaluacionItem evaluacionItem) {
        Evaluacion evaluacion = evaluacionItem.getEvaluacion();
        if ( evaluacion == null ) {
            return null;
        }
        return evaluacion.getId();
    }

    private Long entityCriterioEvaluacionId(EvaluacionItem evaluacionItem) {
        CriterioEvaluacion criterioEvaluacion = evaluacionItem.getCriterioEvaluacion();
        if ( criterioEvaluacion == null ) {
            return null;
        }
        return criterioEvaluacion.getId();
    }
}
