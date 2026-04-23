package com.vantory.ordenCompra.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.ordenCompra.OrdenCompra;
import com.vantory.ordenCompra.dtos.OrdenCompraCreateDTO;
import com.vantory.ordenCompra.dtos.OrdenCompraDTO;
import com.vantory.pedido.Pedido;
import com.vantory.proveedor.Proveedor;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class OrdenCompraMapperImpl implements OrdenCompraMapper {

    @Override
    public OrdenCompraDTO toDTO(OrdenCompra ordenCompra) {
        if ( ordenCompra == null ) {
            return null;
        }

        Long pedidoId = null;
        Long proveedorId = null;
        Long estadoId = null;
        Long id = null;
        String descripcion = null;
        LocalDateTime fechaHora = null;

        pedidoId = ordenCompraPedidoId( ordenCompra );
        proveedorId = ordenCompraProveedorId( ordenCompra );
        estadoId = ordenCompraEstadoId( ordenCompra );
        id = ordenCompra.getId();
        descripcion = ordenCompra.getDescripcion();
        fechaHora = ordenCompra.getFechaHora();

        Long empresaId = null;

        OrdenCompraDTO ordenCompraDTO = new OrdenCompraDTO( id, descripcion, fechaHora, pedidoId, proveedorId, estadoId, empresaId );

        return ordenCompraDTO;
    }

    @Override
    public OrdenCompra toEntity(OrdenCompraDTO ordenCompraDTO) {
        if ( ordenCompraDTO == null ) {
            return null;
        }

        OrdenCompra.OrdenCompraBuilder ordenCompra = OrdenCompra.builder();

        ordenCompra.pedido( ordenCompraDTOToPedido( ordenCompraDTO ) );
        ordenCompra.proveedor( ordenCompraDTOToProveedor( ordenCompraDTO ) );
        ordenCompra.estado( ordenCompraDTOToEstado( ordenCompraDTO ) );
        ordenCompra.empresa( ordenCompraDTOToEmpresa( ordenCompraDTO ) );
        ordenCompra.id( ordenCompraDTO.getId() );
        ordenCompra.descripcion( ordenCompraDTO.getDescripcion() );
        ordenCompra.fechaHora( ordenCompraDTO.getFechaHora() );

        return ordenCompra.build();
    }

    @Override
    public OrdenCompra toEntity(OrdenCompraCreateDTO ordenCompraCreateDTO) {
        if ( ordenCompraCreateDTO == null ) {
            return null;
        }

        OrdenCompra.OrdenCompraBuilder ordenCompra = OrdenCompra.builder();

        ordenCompra.pedido( ordenCompraCreateDTOToPedido( ordenCompraCreateDTO ) );
        ordenCompra.proveedor( ordenCompraCreateDTOToProveedor( ordenCompraCreateDTO ) );
        ordenCompra.descripcion( ordenCompraCreateDTO.getDescripcion() );
        ordenCompra.fechaHora( ordenCompraCreateDTO.getFechaHora() );

        return ordenCompra.build();
    }

    private Long ordenCompraPedidoId(OrdenCompra ordenCompra) {
        Pedido pedido = ordenCompra.getPedido();
        if ( pedido == null ) {
            return null;
        }
        return pedido.getId();
    }

    private Long ordenCompraProveedorId(OrdenCompra ordenCompra) {
        Proveedor proveedor = ordenCompra.getProveedor();
        if ( proveedor == null ) {
            return null;
        }
        return proveedor.getId();
    }

    private Long ordenCompraEstadoId(OrdenCompra ordenCompra) {
        Estado estado = ordenCompra.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Pedido ordenCompraDTOToPedido(OrdenCompraDTO ordenCompraDTO) {
        if ( ordenCompraDTO == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();

        pedido.id( ordenCompraDTO.getPedidoId() );

        return pedido.build();
    }

    protected Proveedor ordenCompraDTOToProveedor(OrdenCompraDTO ordenCompraDTO) {
        if ( ordenCompraDTO == null ) {
            return null;
        }

        Proveedor.ProveedorBuilder proveedor = Proveedor.builder();

        proveedor.id( ordenCompraDTO.getProveedorId() );

        return proveedor.build();
    }

    protected Estado ordenCompraDTOToEstado(OrdenCompraDTO ordenCompraDTO) {
        if ( ordenCompraDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( ordenCompraDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa ordenCompraDTOToEmpresa(OrdenCompraDTO ordenCompraDTO) {
        if ( ordenCompraDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( ordenCompraDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Pedido ordenCompraCreateDTOToPedido(OrdenCompraCreateDTO ordenCompraCreateDTO) {
        if ( ordenCompraCreateDTO == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();

        pedido.id( ordenCompraCreateDTO.getPedidoId() );

        return pedido.build();
    }

    protected Proveedor ordenCompraCreateDTOToProveedor(OrdenCompraCreateDTO ordenCompraCreateDTO) {
        if ( ordenCompraCreateDTO == null ) {
            return null;
        }

        Proveedor.ProveedorBuilder proveedor = Proveedor.builder();

        proveedor.id( ordenCompraCreateDTO.getProveedorId() );

        return proveedor.build();
    }
}
