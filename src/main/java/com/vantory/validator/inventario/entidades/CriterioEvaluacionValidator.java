package com.vantory.validator.inventario.entidades;

import com.vantory.criterioEvaluacion.CriterioEvaluacion;
import com.vantory.criterioEvaluacion.repositirories.CriterioEvaluacionRepository;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CriterioEvaluacionValidator implements BaseValidator {

    private final CriterioEvaluacionRepository criterioEvaluacionRepository;


    public CriterioEvaluacion validarCriterioEvaluacionPorEmpresa(Long criterioEvId, Long empresaId){
        return criterioEvaluacionRepository.findByIdAndEmpresaId(criterioEvId, empresaId)
                .orElseThrow(()-> new NotFoundException("criterio-evaluacion.not-found", criterioEvId));
    }
}
