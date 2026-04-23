package com.vantory.validator.inventario.entidades;

import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.pedido.Pedido;
import com.vantory.pedido.repositories.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PedidoValidator {

    private final PedidoRepository pedidoRepository;

    public Pedido validarPedido(Long pedidoId, Long empresaId){
        return pedidoRepository.findByIdAndEmpresaId(pedidoId, empresaId)
                .orElseThrow(()-> new NotFoundException("pedido.not-found", pedidoId));
    }
}
