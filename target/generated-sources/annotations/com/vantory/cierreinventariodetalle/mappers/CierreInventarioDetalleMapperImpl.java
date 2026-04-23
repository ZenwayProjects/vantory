package com.vantory.cierreinventariodetalle.mappers;

import com.vantory.almacen.Almacen;
import com.vantory.cierreinventario.CierreInventario;
import com.vantory.cierreinventariodetalle.CierreInventarioDetalle;
import com.vantory.cierreinventariodetalle.dtos.CierreInventarioDetalleResponseDTO;
import com.vantory.empresa.Empresa;
import com.vantory.presentacionProducto.PresentacionProducto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CierreInventarioDetalleMapperImpl implements CierreInventarioDetalleMapper {

    @Override
    public CierreInventarioDetalleResponseDTO toResponseDTO(CierreInventarioDetalle cierreInventarioDetalle) {
        if ( cierreInventarioDetalle == null ) {
            return null;
        }

        CierreInventarioDetalleResponseDTO.CierreInventarioDetalleResponseDTOBuilder cierreInventarioDetalleResponseDTO = CierreInventarioDetalleResponseDTO.builder();

        cierreInventarioDetalleResponseDTO.cierreInventarioId( cierreInventarioDetalleCierreInventarioId( cierreInventarioDetalle ) );
        cierreInventarioDetalleResponseDTO.productoPresentacionNombre( cierreInventarioDetallePresentacionProductoNombre( cierreInventarioDetalle ) );
        cierreInventarioDetalleResponseDTO.empresaNombre( cierreInventarioDetalleEmpresaNombre( cierreInventarioDetalle ) );
        cierreInventarioDetalleResponseDTO.almacenNombre( cierreInventarioDetalleAlmacenNombre( cierreInventarioDetalle ) );
        cierreInventarioDetalleResponseDTO.id( cierreInventarioDetalle.getId() );
        cierreInventarioDetalleResponseDTO.stock( cierreInventarioDetalle.getStock() );
        cierreInventarioDetalleResponseDTO.fechaCorte( cierreInventarioDetalle.getFechaCorte() );

        return cierreInventarioDetalleResponseDTO.build();
    }

    private Long cierreInventarioDetalleCierreInventarioId(CierreInventarioDetalle cierreInventarioDetalle) {
        CierreInventario cierreInventario = cierreInventarioDetalle.getCierreInventario();
        if ( cierreInventario == null ) {
            return null;
        }
        return cierreInventario.getId();
    }

    private String cierreInventarioDetallePresentacionProductoNombre(CierreInventarioDetalle cierreInventarioDetalle) {
        PresentacionProducto presentacionProducto = cierreInventarioDetalle.getPresentacionProducto();
        if ( presentacionProducto == null ) {
            return null;
        }
        return presentacionProducto.getNombre();
    }

    private String cierreInventarioDetalleEmpresaNombre(CierreInventarioDetalle cierreInventarioDetalle) {
        Empresa empresa = cierreInventarioDetalle.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getNombre();
    }

    private String cierreInventarioDetalleAlmacenNombre(CierreInventarioDetalle cierreInventarioDetalle) {
        Almacen almacen = cierreInventarioDetalle.getAlmacen();
        if ( almacen == null ) {
            return null;
        }
        return almacen.getNombre();
    }
}
