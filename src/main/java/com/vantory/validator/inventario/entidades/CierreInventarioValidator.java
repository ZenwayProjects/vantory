package com.vantory.validator.inventario.entidades;

import com.vantory.cierreinventario.CierreInventario;
import com.vantory.cierreinventario.repositories.CierreInventarioRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class CierreInventarioValidator implements BaseValidator {

    private final CierreInventarioRepository cierreInventarioRepository;

    public CierreInventario validarCierreInventario(Long cierreInventarioId, Long empresaId){
        return cierreInventarioRepository.findByIdAndEmpresaId(cierreInventarioId, empresaId)
                .orElseThrow(()-> new BadRequestException("cierre-inventario.not-found", cierreInventarioId));
    }

    public void validarDuplicado(Long empresaId, Long almacenId, LocalDate fechaInicio, LocalDate fechaCorte) {

        boolean existe = cierreInventarioRepository.existeCierreEnMes(
                empresaId,
                almacenId,
                fechaInicio,
                fechaCorte
        );

        if (existe) {
            throw new IllegalStateException(
                    "Ya existe un cierre de inventario para el almacén " + almacenId +
                            " en el rango " + fechaInicio + " - " + fechaCorte
            );
        }
    }

}
