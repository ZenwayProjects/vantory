package com.vantory.productopresentacionstock.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.presentacionProducto.PresentacionProducto;
import com.vantory.productopresentacionstock.ProductoPresentacionStock;
import com.vantory.productopresentacionstock.dtos.ProductoPresentacionStockResponseDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductoPresentacionStockMapperImpl implements ProductoPresentacionStockMapper {

    @Override
    public ProductoPresentacionStockResponseDTO toResponseDTO(ProductoPresentacionStock entity) {
        if ( entity == null ) {
            return null;
        }

        ProductoPresentacionStockResponseDTO productoPresentacionStockResponseDTO = new ProductoPresentacionStockResponseDTO();

        productoPresentacionStockResponseDTO.setProductoPresentacionId( entityProductoPresentacionId( entity ) );
        productoPresentacionStockResponseDTO.setProductoPresentacionNombre( entityProductoPresentacionNombre( entity ) );
        productoPresentacionStockResponseDTO.setEmpresaId( entityEmpresaId( entity ) );
        productoPresentacionStockResponseDTO.setId( entity.getId() );
        productoPresentacionStockResponseDTO.setStock( entity.getStock() );
        productoPresentacionStockResponseDTO.setFechaHora( entity.getFechaHora() );

        return productoPresentacionStockResponseDTO;
    }

    private Long entityProductoPresentacionId(ProductoPresentacionStock productoPresentacionStock) {
        PresentacionProducto productoPresentacion = productoPresentacionStock.getProductoPresentacion();
        if ( productoPresentacion == null ) {
            return null;
        }
        return productoPresentacion.getId();
    }

    private String entityProductoPresentacionNombre(ProductoPresentacionStock productoPresentacionStock) {
        PresentacionProducto productoPresentacion = productoPresentacionStock.getProductoPresentacion();
        if ( productoPresentacion == null ) {
            return null;
        }
        return productoPresentacion.getNombre();
    }

    private Long entityEmpresaId(ProductoPresentacionStock productoPresentacionStock) {
        Empresa empresa = productoPresentacionStock.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }
}
