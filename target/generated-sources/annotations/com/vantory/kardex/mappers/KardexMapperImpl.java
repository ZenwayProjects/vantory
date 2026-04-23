package com.vantory.kardex.mappers;

import com.vantory.almacen.Almacen;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.kardex.Kardex;
import com.vantory.kardex.dtos.KardexDTO;
import com.vantory.ordenCompra.OrdenCompra;
import com.vantory.pedido.Pedido;
import com.vantory.produccion.Produccion;
import com.vantory.tipoMovimiento.TipoMovimiento;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class KardexMapperImpl implements KardexMapper {

    @Override
    public KardexDTO toDto(Kardex kardex) {
        if ( kardex == null ) {
            return null;
        }

        KardexDTO kardexDTO = new KardexDTO();

        kardexDTO.setAlmacenId( kardexAlmacenId( kardex ) );
        kardexDTO.setProduccionId( kardexProduccionId( kardex ) );
        kardexDTO.setTipoMovimientoId( kardexTipoMovimientoId( kardex ) );
        kardexDTO.setEstadoId( kardexEstadoId( kardex ) );
        kardexDTO.setEmpresaId( kardexEmpresaId( kardex ) );
        kardexDTO.setClienteProveedorId( kardexClienteProveedorId( kardex ) );
        kardexDTO.setPedidoId( kardexPedidoId( kardex ) );
        kardexDTO.setOrdenCompraId( kardexOrdenCompraId( kardex ) );
        kardexDTO.setId( kardex.getId() );
        kardexDTO.setFechaHora( kardex.getFechaHora() );
        kardexDTO.setDescripcion( kardex.getDescripcion() );

        return kardexDTO;
    }

    @Override
    public Kardex toEntity(KardexDTO kardexDTO) {
        if ( kardexDTO == null ) {
            return null;
        }

        Kardex.KardexBuilder kardex = Kardex.builder();

        kardex.almacen( kardexDTOToAlmacen( kardexDTO ) );
        kardex.produccion( kardexDTOToProduccion( kardexDTO ) );
        kardex.tipoMovimiento( kardexDTOToTipoMovimiento( kardexDTO ) );
        kardex.estado( kardexDTOToEstado( kardexDTO ) );
        kardex.empresa( kardexDTOToEmpresa( kardexDTO ) );
        kardex.pedido( kardexDTOToPedido( kardexDTO ) );
        kardex.ordenCompra( kardexDTOToOrdenCompra( kardexDTO ) );
        kardex.id( kardexDTO.getId() );
        kardex.fechaHora( kardexDTO.getFechaHora() );
        kardex.descripcion( kardexDTO.getDescripcion() );

        return kardex.build();
    }

    @Override
    public void updateEntityFromDto(KardexDTO dto, Kardex entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getFechaHora() != null ) {
            entity.setFechaHora( dto.getFechaHora() );
        }
        if ( dto.getDescripcion() != null ) {
            entity.setDescripcion( dto.getDescripcion() );
        }
    }

    private Long kardexAlmacenId(Kardex kardex) {
        Almacen almacen = kardex.getAlmacen();
        if ( almacen == null ) {
            return null;
        }
        return almacen.getId();
    }

    private Long kardexProduccionId(Kardex kardex) {
        Produccion produccion = kardex.getProduccion();
        if ( produccion == null ) {
            return null;
        }
        return produccion.getId();
    }

    private Long kardexTipoMovimientoId(Kardex kardex) {
        TipoMovimiento tipoMovimiento = kardex.getTipoMovimiento();
        if ( tipoMovimiento == null ) {
            return null;
        }
        return tipoMovimiento.getId();
    }

    private Long kardexEstadoId(Kardex kardex) {
        Estado estado = kardex.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long kardexEmpresaId(Kardex kardex) {
        Empresa empresa = kardex.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long kardexClienteProveedorId(Kardex kardex) {
        Empresa clienteProveedor = kardex.getClienteProveedor();
        if ( clienteProveedor == null ) {
            return null;
        }
        return clienteProveedor.getId();
    }

    private Long kardexPedidoId(Kardex kardex) {
        Pedido pedido = kardex.getPedido();
        if ( pedido == null ) {
            return null;
        }
        return pedido.getId();
    }

    private Long kardexOrdenCompraId(Kardex kardex) {
        OrdenCompra ordenCompra = kardex.getOrdenCompra();
        if ( ordenCompra == null ) {
            return null;
        }
        return ordenCompra.getId();
    }

    protected Almacen kardexDTOToAlmacen(KardexDTO kardexDTO) {
        if ( kardexDTO == null ) {
            return null;
        }

        Almacen.AlmacenBuilder almacen = Almacen.builder();

        almacen.id( kardexDTO.getAlmacenId() );

        return almacen.build();
    }

    protected Produccion kardexDTOToProduccion(KardexDTO kardexDTO) {
        if ( kardexDTO == null ) {
            return null;
        }

        Produccion.ProduccionBuilder produccion = Produccion.builder();

        produccion.id( kardexDTO.getProduccionId() );

        return produccion.build();
    }

    protected TipoMovimiento kardexDTOToTipoMovimiento(KardexDTO kardexDTO) {
        if ( kardexDTO == null ) {
            return null;
        }

        TipoMovimiento.TipoMovimientoBuilder tipoMovimiento = TipoMovimiento.builder();

        tipoMovimiento.id( kardexDTO.getTipoMovimientoId() );

        return tipoMovimiento.build();
    }

    protected Estado kardexDTOToEstado(KardexDTO kardexDTO) {
        if ( kardexDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( kardexDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa kardexDTOToEmpresa(KardexDTO kardexDTO) {
        if ( kardexDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( kardexDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Pedido kardexDTOToPedido(KardexDTO kardexDTO) {
        if ( kardexDTO == null ) {
            return null;
        }

        Pedido.PedidoBuilder pedido = Pedido.builder();

        pedido.id( kardexDTO.getPedidoId() );

        return pedido.build();
    }

    protected OrdenCompra kardexDTOToOrdenCompra(KardexDTO kardexDTO) {
        if ( kardexDTO == null ) {
            return null;
        }

        OrdenCompra.OrdenCompraBuilder ordenCompra = OrdenCompra.builder();

        ordenCompra.id( kardexDTO.getOrdenCompraId() );

        return ordenCompra.build();
    }
}
