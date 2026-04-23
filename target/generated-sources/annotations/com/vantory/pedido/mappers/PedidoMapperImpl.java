package com.vantory.pedido.mappers;

import com.vantory.almacen.Almacen;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.pedido.Pedido;
import com.vantory.pedido.dtos.PedidoDTO;
import com.vantory.produccion.Produccion;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PedidoMapperImpl implements PedidoMapper {

    @Override
    public PedidoDTO toDto(Pedido pedido) {
        if ( pedido == null ) {
            return null;
        }

        Long almacenId = null;
        Long produccionId = null;
        Long estadoId = null;
        Long id = null;
        LocalDateTime fechaHora = null;
        String descripcion = null;

        almacenId = pedidoAlmacenId( pedido );
        produccionId = pedidoProduccionId( pedido );
        estadoId = pedidoEstadoId( pedido );
        id = pedido.getId();
        fechaHora = pedido.getFechaHora();
        descripcion = pedido.getDescripcion();

        Long empresaId = null;

        PedidoDTO pedidoDTO = new PedidoDTO( id, fechaHora, descripcion, almacenId, produccionId, estadoId, empresaId );

        return pedidoDTO;
    }

    @Override
    public Pedido toEntity(PedidoDTO pedidoDTO) {
        if ( pedidoDTO == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();

        pedido.almacen( pedidoDTOToAlmacen( pedidoDTO ) );
        pedido.produccion( pedidoDTOToProduccion( pedidoDTO ) );
        pedido.estado( pedidoDTOToEstado( pedidoDTO ) );
        pedido.empresa( pedidoDTOToEmpresa( pedidoDTO ) );
        pedido.id( pedidoDTO.getId() );
        pedido.fechaHora( pedidoDTO.getFechaHora() );
        pedido.descripcion( pedidoDTO.getDescripcion() );

        return pedido.build();
    }

    private Long pedidoAlmacenId(Pedido pedido) {
        Almacen almacen = pedido.getAlmacen();
        if ( almacen == null ) {
            return null;
        }
        return almacen.getId();
    }

    private Long pedidoProduccionId(Pedido pedido) {
        Produccion produccion = pedido.getProduccion();
        if ( produccion == null ) {
            return null;
        }
        return produccion.getId();
    }

    private Long pedidoEstadoId(Pedido pedido) {
        Estado estado = pedido.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Almacen pedidoDTOToAlmacen(PedidoDTO pedidoDTO) {
        if ( pedidoDTO == null ) {
            return null;
        }

        Almacen.AlmacenBuilder almacen = Almacen.builder();

        almacen.id( pedidoDTO.getAlmacenId() );

        return almacen.build();
    }

    protected Produccion pedidoDTOToProduccion(PedidoDTO pedidoDTO) {
        if ( pedidoDTO == null ) {
            return null;
        }

        Produccion.ProduccionBuilder produccion = Produccion.builder();

        produccion.id( pedidoDTO.getProduccionId() );

        return produccion.build();
    }

    protected Estado pedidoDTOToEstado(PedidoDTO pedidoDTO) {
        if ( pedidoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( pedidoDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa pedidoDTOToEmpresa(PedidoDTO pedidoDTO) {
        if ( pedidoDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( pedidoDTO.getEmpresaId() );

        return empresa.build();
    }
}
