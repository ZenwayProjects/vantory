package com.vantory.validator.parametrizacion.entidades;

import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.tipoProduccion.TipoProduccion;
import com.vantory.tipoProduccion.repositories.TipoProduccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipoProduccionValidator {

    private final TipoProduccionRepository tipoProduccionRepository;


    public TipoProduccion validarTipoProduccion(Long tipoProduccionId, Long empresaId) {
        return tipoProduccionRepository.findByIdAndEmpresaId(tipoProduccionId, empresaId)
                .orElseThrow(() -> new BadRequestException("tipo-produccion.not-found", tipoProduccionId));
    }
}
