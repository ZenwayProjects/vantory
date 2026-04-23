package com.vantory.validator.inventario.entidades;

import com.vantory.espacio.Espacio;
import com.vantory.espacio.repositories.EspacioRepository;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EspacioValidator implements BaseValidator {
    private final EspacioRepository espacioRepository;


    public Espacio validarEspacio(Long espacioId, Long empresaId){
        return espacioRepository.findByIdAndEmpresaId(espacioId, empresaId)
                .orElseThrow(()-> new NotFoundException("espacio.not-found", espacioId));
    }
}
