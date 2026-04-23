package com.vantory.validator.inventario.entidades;

import com.vantory.evaluacion.Evaluacion;
import com.vantory.evaluacion.repositories.EvaluacionRepository;
import com.vantory.exceptionHandler.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EvaluacionValidator {
    private final EvaluacionRepository evaluacionRepository;


    public Evaluacion validarEvaluacionPorEmpresa(Long evaluacionId, Long empresaId){
        return evaluacionRepository.findByIdAndEmpresaId(evaluacionId, empresaId)
                .orElseThrow(()-> new NotFoundException("evaluacion.not-found", evaluacionId));
    }
}
