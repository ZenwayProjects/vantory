package com.vantory.validator.inventario.entidades;

import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.movimiento.Movimiento;
import com.vantory.movimiento.repositories.MovimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class MovimientoValidator {

    private final MovimientoRepository movimientoRepository;

    public Movimiento validarMovimiento(Long movimientoId) {
        return movimientoRepository.findById(movimientoId)
                .orElseThrow(() -> new NotFoundException("movimiento.not-found", movimientoId));
    }


}