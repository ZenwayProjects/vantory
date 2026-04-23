package com.vantory.validator.inventario.entidades;

import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.kardex.Kardex;
import com.vantory.kardex.repositories.KardexRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KardexValidator {

    private final KardexRepository kardexRepository;

    public Kardex validarKardex(Long kardexId, Long empresaId) {
        return kardexRepository.findByIdAndEmpresaId(kardexId, empresaId)
                .orElseThrow(() -> new NotFoundException("kardex.not-found", kardexId));
    }

    public Kardex validarKardexPorOrdenCompra(Long ordenCompraId, Long empresaId) {
        return kardexRepository.findByOrdenCompraIdAndEmpresaId(ordenCompraId, empresaId)
                .orElseThrow(() -> new NotFoundException("kardex.not-found", ordenCompraId));
    }


}
