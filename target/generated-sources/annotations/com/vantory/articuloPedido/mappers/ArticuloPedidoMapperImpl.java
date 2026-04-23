package com.vantory.articuloPedido.mappers;

import com.vantory.articuloPedido.ArticuloPedido;
import com.vantory.articuloPedido.dtos.ArticuloPedidoDTO;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.pedido.Pedido;
import com.vantory.presentacionProducto.PresentacionProducto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ArticuloPedidoMapperImpl implements ArticuloPedidoMapper {

    @Override
    public ArticuloPedidoDTO toDTO(ArticuloPedido articuloPedido) {
        if ( articuloPedido == null ) {
            return null;
        }

        Long pedidoId = null;
        Long presentacionProductoId = null;
        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        Double cantidad = null;

        pedidoId = articuloPedidoPedidoId( articuloPedido );
        presentacionProductoId = articuloPedidoPresentacionProductoId( articuloPedido );
        estadoId = articuloPedidoEstadoId( articuloPedido );
        empresaId = articuloPedidoEmpresaId( articuloPedido );
        id = articuloPedido.getId();
        cantidad = articuloPedido.getCantidad();

        ArticuloPedidoDTO articuloPedidoDTO = new ArticuloPedidoDTO( id, cantidad, pedidoId, presentacionProductoId, estadoId, empresaId );

        return articuloPedidoDTO;
    }

    @Override
    public ArticuloPedido toEntity(ArticuloPedidoDTO articuloPedidoDTO) {
        if ( articuloPedidoDTO == null ) {
            return null;
        }

        ArticuloPedido.ArticuloPedidoBuilder articuloPedido = ArticuloPedido.builder();

        articuloPedido.pedido( articuloPedidoDTOToPedido( articuloPedidoDTO ) );
        articuloPedido.presentacionProducto( articuloPedidoDTOToPresentacionProducto( articuloPedidoDTO ) );
        articuloPedido.estado( articuloPedidoDTOToEstado( articuloPedidoDTO ) );
        articuloPedido.empresa( articuloPedidoDTOToEmpresa( articuloPedidoDTO ) );
        articuloPedido.id( articuloPedidoDTO.getId() );
        articuloPedido.cantidad( articuloPedidoDTO.getCantidad() );

        return articuloPedido.build();
    }

    @Override
    public ArticuloPedidoDTO toListDTO(ArticuloPedido articuloPedido) {
        if ( articuloPedido == null ) {
            return null;
        }

        Long pedidoId = null;
        Long presentacionProductoId = null;
        Long estadoId = null;
        Long id = null;
        Double cantidad = null;

        pedidoId = articuloPedidoPedidoId( articuloPedido );
        presentacionProductoId = articuloPedidoPresentacionProductoId( articuloPedido );
        estadoId = articuloPedidoEstadoId( articuloPedido );
        id = articuloPedido.getId();
        cantidad = articuloPedido.getCantidad();

        Long empresaId = null;

        ArticuloPedidoDTO articuloPedidoDTO = new ArticuloPedidoDTO( id, cantidad, pedidoId, presentacionProductoId, estadoId, empresaId );

        return articuloPedidoDTO;
    }

    private Long articuloPedidoPedidoId(ArticuloPedido articuloPedido) {
        Pedido pedido = articuloPedido.getPedido();
        if ( pedido == null ) {
            return null;
        }
        return pedido.getId();
    }

    private Long articuloPedidoPresentacionProductoId(ArticuloPedido articuloPedido) {
        PresentacionProducto presentacionProducto = articuloPedido.getPresentacionProducto();
        if ( presentacionProducto == null ) {
            return null;
        }
        return presentacionProducto.getId();
    }

    private Long articuloPedidoEstadoId(ArticuloPedido articuloPedido) {
        Estado estado = articuloPedido.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long articuloPedidoEmpresaId(ArticuloPedido articuloPedido) {
        Empresa empresa = articuloPedido.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Pedido articuloPedidoDTOToPedido(ArticuloPedidoDTO articuloPedidoDTO) {
        if ( articuloPedidoDTO == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();

        pedido.id( articuloPedidoDTO.getPedidoId() );

        return pedido.build();
    }

    protected PresentacionProducto articuloPedidoDTOToPresentacionProducto(ArticuloPedidoDTO articuloPedidoDTO) {
        if ( articuloPedidoDTO == null ) {
            return null;
        }

        PresentacionProducto.PresentacionProductoBuilder presentacionProducto = PresentacionProducto.builder();

        presentacionProducto.id( articuloPedidoDTO.getPresentacionProductoId() );

        return presentacionProducto.build();
    }

    protected Estado articuloPedidoDTOToEstado(ArticuloPedidoDTO articuloPedidoDTO) {
        if ( articuloPedidoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( articuloPedidoDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa articuloPedidoDTOToEmpresa(ArticuloPedidoDTO articuloPedidoDTO) {
        if ( articuloPedidoDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( articuloPedidoDTO.getEmpresaId() );

        return empresa.build();
    }
}
