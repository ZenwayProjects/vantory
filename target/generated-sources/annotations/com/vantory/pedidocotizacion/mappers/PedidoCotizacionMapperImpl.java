package com.vantory.pedidocotizacion.mappers;

import com.vantory.estado.Estado;
import com.vantory.pedido.Pedido;
import com.vantory.pedidocotizacion.PedidoCotizacion;
import com.vantory.pedidocotizacion.dtos.PedidoCotizacionRequestDTO;
import com.vantory.pedidocotizacion.dtos.PedidoCotizacionResponseDTO;
import com.vantory.proveedor.Proveedor;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PedidoCotizacionMapperImpl implements PedidoCotizacionMapper {

    @Override
    public PedidoCotizacionResponseDTO toDTO(PedidoCotizacion pedidoCotizacion) {
        if ( pedidoCotizacion == null ) {
            return null;
        }

        Long pedidoId = null;
        Long proveedorId = null;
        Long estadoId = null;
        Long id = null;
        String descripcion = null;
        String archivo = null;

        pedidoId = pedidoCotizacionPedidoId( pedidoCotizacion );
        proveedorId = pedidoCotizacionProveedorId( pedidoCotizacion );
        estadoId = pedidoCotizacionEstadoId( pedidoCotizacion );
        id = pedidoCotizacion.getId();
        descripcion = pedidoCotizacion.getDescripcion();
        archivo = pedidoCotizacion.getArchivo();

        PedidoCotizacionResponseDTO pedidoCotizacionResponseDTO = new PedidoCotizacionResponseDTO( id, descripcion, archivo, pedidoId, proveedorId, estadoId );

        return pedidoCotizacionResponseDTO;
    }

    @Override
    public PedidoCotizacion toEntity(PedidoCotizacionRequestDTO pedidoCotizacionRequestDTO) {
        if ( pedidoCotizacionRequestDTO == null ) {
            return null;
        }

        PedidoCotizacion.PedidoCotizacionBuilder pedidoCotizacion = PedidoCotizacion.builder();

        pedidoCotizacion.descripcion( pedidoCotizacionRequestDTO.descripcion() );
        pedidoCotizacion.archivo( pedidoCotizacionRequestDTO.archivo() );

        return pedidoCotizacion.build();
    }

    private Long pedidoCotizacionPedidoId(PedidoCotizacion pedidoCotizacion) {
        Pedido pedido = pedidoCotizacion.getPedido();
        if ( pedido == null ) {
            return null;
        }
        return pedido.getId();
    }

    private Long pedidoCotizacionProveedorId(PedidoCotizacion pedidoCotizacion) {
        Proveedor proveedor = pedidoCotizacion.getProveedor();
        if ( proveedor == null ) {
            return null;
        }
        return proveedor.getId();
    }

    private Long pedidoCotizacionEstadoId(PedidoCotizacion pedidoCotizacion) {
        Estado estado = pedidoCotizacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }
}
