package com.vantory.validator.parametrizacion.entidades;

import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.tipoMovimiento.TipoMovimiento;
import com.vantory.tipoMovimiento.repositories.TipoMovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipoMovimientoValidator {

    private final TipoMovimientoRepository tipoMovimientoRepository;


    public TipoMovimiento validarTipoMovimiento(Long tipoMovimientoId, Long empresaId) {
        return tipoMovimientoRepository.findByIdAndEmpresaId(tipoMovimientoId, empresaId)
                .orElseThrow(() -> new BadRequestException("tipo-movimiento.not-found", tipoMovimientoId));
    }
}
