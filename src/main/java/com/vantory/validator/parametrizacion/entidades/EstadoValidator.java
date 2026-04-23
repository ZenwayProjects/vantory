package com.vantory.validator.parametrizacion.entidades;

import com.vantory.validator.common.BaseValidator;
import com.vantory.validator.parametrizacion.constantes.EstadoCategorias;
import com.vantory.estado.Estado;
import com.vantory.estado.repositories.EstadoRepository;
import com.vantory.exceptionHandler.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstadoValidator implements BaseValidator {
    private final EstadoRepository estadoRepository;


    public Estado validarEstadoGeneral(Long estadoId) {
        return validarEstadoPorCategoria(
                estadoId,
                EstadoCategorias.GENERAL,
                "validation.general.estado.invalid-category"
        );
    }

    public Estado validarEstadoParaOrdenCompra(Long estadoId) {
        return validarEstadoPorCategoria(
                estadoId,
                EstadoCategorias.ORDEN_COMPRA,
                "validation.orden-compra.estado.invalid-category"
        );
    }


    public Estado validarEstadoParaPedido(Long estadoId) {
        return validarEstadoPorCategoria(
                estadoId,
                EstadoCategorias.PEDIDO,
                "validation.pedido.estado.invalid-category"
        );
    }

    public Estado validarEstadoParaFactura(Long estadoId) {
        return validarEstadoPorCategoria(
                estadoId,
                EstadoCategorias.FACTURA,
                "validation.facturacion.estado.invalid-category"
        );

    }
    public Estado validarEstadoParaCierre(Long estadoId) {
        return validarEstadoPorCategoria(
                estadoId,
                EstadoCategorias.CIERRE,
                "validation.cierre.estado.invalid-category"
        );

    }

    private Estado validarEstadoPorCategoria(Long estadoId, Long estadoCategoriaId, String mensajeErrorKey) {
        return estadoRepository.findByIdAndEstadoCategoriaId(estadoId, estadoCategoriaId)
                .orElseThrow(() -> new BadRequestException(
                        mensajeErrorKey, estadoId));
    }

}
