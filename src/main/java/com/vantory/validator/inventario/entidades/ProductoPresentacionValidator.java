package com.vantory.validator.inventario.entidades;

import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.presentacionProducto.PresentacionProducto;
import com.vantory.presentacionProducto.repositories.PresentacionProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductoPresentacionValidator {
    private final PresentacionProductoRepository presentacionProductoRepository;

    public PresentacionProducto validarProductoPresentacion(Long productoPresentacionId, Long empresaId){
        return presentacionProductoRepository
                .findByIdAndEmpresaId(productoPresentacionId,empresaId)
                .orElseThrow(() -> new BadRequestException("producto-presentacion.not-found", productoPresentacionId));
    }
}
