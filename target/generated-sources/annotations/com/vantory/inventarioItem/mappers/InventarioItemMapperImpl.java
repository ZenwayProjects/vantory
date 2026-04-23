package com.vantory.inventarioItem.mappers;

import com.vantory.articuloKardex.ArticuloKardex;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.inventario.Inventario;
import com.vantory.inventarioItem.InventarioItem;
import com.vantory.inventarioItem.dtos.InventarioItemDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class InventarioItemMapperImpl implements InventarioItemMapper {

    @Override
    public InventarioItemDTO toDTO(InventarioItem inventarioItem) {
        if ( inventarioItem == null ) {
            return null;
        }

        Long estadoId = null;
        Long inventarioId = null;
        String productoIdentificadorId = null;
        Long id = null;
        String descripcion = null;
        String uuid = null;

        estadoId = inventarioItemEstadoId( inventarioItem );
        inventarioId = inventarioItemInventarioId( inventarioItem );
        productoIdentificadorId = inventarioItemArticuloKardexIdentificadorProducto( inventarioItem );
        id = inventarioItem.getId();
        descripcion = inventarioItem.getDescripcion();
        uuid = inventarioItem.getUuid();

        Long empresaId = null;

        InventarioItemDTO inventarioItemDTO = new InventarioItemDTO( id, inventarioId, descripcion, uuid, empresaId, estadoId, productoIdentificadorId );

        return inventarioItemDTO;
    }

    @Override
    public InventarioItem toEntity(InventarioItemDTO inventarioItemDTO) {
        if ( inventarioItemDTO == null ) {
            return null;
        }

        InventarioItem.InventarioItemBuilder inventarioItem = InventarioItem.builder();

        inventarioItem.estado( inventarioItemDTOToEstado( inventarioItemDTO ) );
        inventarioItem.inventario( inventarioItemDTOToInventario( inventarioItemDTO ) );
        inventarioItem.empresa( inventarioItemDTOToEmpresa( inventarioItemDTO ) );
        inventarioItem.articuloKardex( inventarioItemDTOToArticuloKardex( inventarioItemDTO ) );
        inventarioItem.id( inventarioItemDTO.getId() );
        inventarioItem.descripcion( inventarioItemDTO.getDescripcion() );
        inventarioItem.uuid( inventarioItemDTO.getUuid() );

        return inventarioItem.build();
    }

    private Long inventarioItemEstadoId(InventarioItem inventarioItem) {
        Estado estado = inventarioItem.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long inventarioItemInventarioId(InventarioItem inventarioItem) {
        Inventario inventario = inventarioItem.getInventario();
        if ( inventario == null ) {
            return null;
        }
        return inventario.getId();
    }

    private String inventarioItemArticuloKardexIdentificadorProducto(InventarioItem inventarioItem) {
        ArticuloKardex articuloKardex = inventarioItem.getArticuloKardex();
        if ( articuloKardex == null ) {
            return null;
        }
        return articuloKardex.getIdentificadorProducto();
    }

    protected Estado inventarioItemDTOToEstado(InventarioItemDTO inventarioItemDTO) {
        if ( inventarioItemDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( inventarioItemDTO.getEstadoId() );

        return estado.build();
    }

    protected Inventario inventarioItemDTOToInventario(InventarioItemDTO inventarioItemDTO) {
        if ( inventarioItemDTO == null ) {
            return null;
        }

        Inventario.InventarioBuilder inventario = Inventario.builder();

        inventario.id( inventarioItemDTO.getInventarioId() );

        return inventario.build();
    }

    protected Empresa inventarioItemDTOToEmpresa(InventarioItemDTO inventarioItemDTO) {
        if ( inventarioItemDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( inventarioItemDTO.getEmpresaId() );

        return empresa.build();
    }

    protected ArticuloKardex inventarioItemDTOToArticuloKardex(InventarioItemDTO inventarioItemDTO) {
        if ( inventarioItemDTO == null ) {
            return null;
        }

        ArticuloKardex.ArticuloKardexBuilder articuloKardex = ArticuloKardex.builder();

        articuloKardex.identificadorProducto( inventarioItemDTO.getProductoIdentificadorId() );

        return articuloKardex.build();
    }
}
