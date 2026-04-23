package com.vantory.validator.inventario.entidades;

import com.vantory.cierreinventariodetalle.CierreInventarioDetalle;
import com.vantory.cierreinventariodetalle.repositories.CierreInventarioDetalleRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CierreInventarioDetalleValidator implements BaseValidator {

    private final CierreInventarioDetalleRepository cierreInventarioDetalleRepository;

    public CierreInventarioDetalle validarCierreDetalle(Long cierreInventarioDetalleId, Long empresaId){
        return cierreInventarioDetalleRepository.findByIdAndEmpresaId(cierreInventarioDetalleId, empresaId)
                .orElseThrow(()-> new BadRequestException("cierre-inventario-detalle.not-found", cierreInventarioDetalleId));
    }



}
