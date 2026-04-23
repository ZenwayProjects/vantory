package com.vantory.validator.inventario.entidades;

import com.vantory.articuloOrdenCompra.ArticuloOrdenCompra;
import com.vantory.articuloOrdenCompra.repositories.ArticuloOrdenCompraRepository;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.ordenCompra.OrdenCompra;
import com.vantory.ordenCompra.repositories.OrdenCompraRepository;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrdenCompraValidator implements BaseValidator {

    private final OrdenCompraRepository ordenCompraRepository;
    private final ArticuloOrdenCompraRepository articuloOrdenCompraRepository;

    public OrdenCompra validarOrdenCompra(Long ordenCompraId, Long empresaId) {
        return ordenCompraRepository.findByIdAndEmpresaId(ordenCompraId, empresaId)
                .orElseThrow(() -> new NotFoundException("orden-compra.not-found", ordenCompraId));
    }

    public ArticuloOrdenCompra validarArticulosOrdenCompra(Long ordenCompraId, Long empresaId) {
        return articuloOrdenCompraRepository.findByIdAndEmpresaId(ordenCompraId, empresaId)
                .orElseThrow(() -> new NotFoundException("orden-compra.not-found", ordenCompraId));
    }

    public OrdenCompra validarOrdenCompraPorPedidoId(Long pedidoId, Long empresaId) {
        return ordenCompraRepository.findByPedidoIdAndEmpresaId(pedidoId, empresaId)
                .orElseThrow(() -> new NotFoundException("orden-compra.not-found"));
    }





}
