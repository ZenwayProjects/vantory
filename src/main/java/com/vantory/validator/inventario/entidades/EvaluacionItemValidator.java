package com.vantory.validator.inventario.entidades;

import com.vantory.evaluacionitem.EvaluacionItem;
import com.vantory.evaluacionitem.repositories.EvaluacionItemRepository;
import com.vantory.exceptionHandler.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EvaluacionItemValidator {
    private final EvaluacionItemRepository evaluacionItemRepository;


    public EvaluacionItem validarEvaluacionItemPorEmpresa(Long evaluacionItemId, Long empresaId){
        return evaluacionItemRepository.findByIdAndEmpresaId(evaluacionItemId, empresaId)
                .orElseThrow(()-> new NotFoundException("evaluacion-item.not-found", evaluacionItemId));
    }
}
