package com.vantory.validator.parametrizacion.entidades;

import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.subseccion.Subseccion;
import com.vantory.subseccion.repositories.SubseccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubseccionValidator {
    private final SubseccionRepository subseccionRepository;


    public Subseccion validarSubseccion(Long subseccionId, Long empresaId){
        return subseccionRepository
                .findByIdAndEmpresaId(subseccionId, empresaId)
                .orElseThrow(() -> new NotFoundException("subseccion.not-found", empresaId));
    }
}
