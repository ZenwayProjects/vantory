package com.vantory.validator.inventario.entidades;

import com.vantory.produccion.exception.FechaInvalidaException;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.produccion.Produccion;
import com.vantory.produccion.repositories.ProduccionRepository;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProduccionValidator implements BaseValidator {

    private final ProduccionRepository produccionRepository;

    public Produccion validarProduccion(Long produccionId, Long empresaId) {
        return produccionRepository.findByIdAndEmpresaId(produccionId, empresaId)
                .orElseThrow(() -> new BadRequestException("produccion.not-found", produccionId));
    }

    public void validarFechasDeProduccion(Produccion produccion){
        if(produccion.getFechaInicio().isAfter(produccion.getFechaFinal())){
            throw new FechaInvalidaException("validation.fecha-rango.invalid");
        }
    }

}
