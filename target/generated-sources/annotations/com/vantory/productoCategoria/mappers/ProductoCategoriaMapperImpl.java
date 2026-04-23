package com.vantory.productoCategoria.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.productoCategoria.ProductoCategoria;
import com.vantory.productoCategoria.dtos.ProductoCategoriaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductoCategoriaMapperImpl implements ProductoCategoriaMapper {

    @Override
    public ProductoCategoriaDTO toDTO(ProductoCategoria productoCategoria) {
        if ( productoCategoria == null ) {
            return null;
        }

        ProductoCategoriaDTO productoCategoriaDTO = new ProductoCategoriaDTO();

        productoCategoriaDTO.setEstadoId( productoCategoriaEstadoId( productoCategoria ) );
        productoCategoriaDTO.setEmpresaId( productoCategoriaEmpresaId( productoCategoria ) );
        productoCategoriaDTO.setId( productoCategoria.getId() );
        productoCategoriaDTO.setNombre( productoCategoria.getNombre() );
        productoCategoriaDTO.setDescripcion( productoCategoria.getDescripcion() );

        return productoCategoriaDTO;
    }

    @Override
    public ProductoCategoria toEntity(ProductoCategoriaDTO productoCategoriaDTO) {
        if ( productoCategoriaDTO == null ) {
            return null;
        }

        ProductoCategoria.ProductoCategoriaBuilder productoCategoria = ProductoCategoria.builder();

        productoCategoria.estado( productoCategoriaDTOToEstado( productoCategoriaDTO ) );
        productoCategoria.empresa( productoCategoriaDTOToEmpresa( productoCategoriaDTO ) );
        productoCategoria.id( productoCategoriaDTO.getId() );
        productoCategoria.nombre( productoCategoriaDTO.getNombre() );
        productoCategoria.descripcion( productoCategoriaDTO.getDescripcion() );

        return productoCategoria.build();
    }

    @Override
    public ProductoCategoriaDTO toListDto(ProductoCategoria productoCategoria) {
        if ( productoCategoria == null ) {
            return null;
        }

        ProductoCategoriaDTO productoCategoriaDTO = new ProductoCategoriaDTO();

        productoCategoriaDTO.setEstadoId( productoCategoriaEstadoId( productoCategoria ) );
        productoCategoriaDTO.setId( productoCategoria.getId() );
        productoCategoriaDTO.setNombre( productoCategoria.getNombre() );
        productoCategoriaDTO.setDescripcion( productoCategoria.getDescripcion() );

        return productoCategoriaDTO;
    }

    private Long productoCategoriaEstadoId(ProductoCategoria productoCategoria) {
        Estado estado = productoCategoria.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long productoCategoriaEmpresaId(ProductoCategoria productoCategoria) {
        Empresa empresa = productoCategoria.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado productoCategoriaDTOToEstado(ProductoCategoriaDTO productoCategoriaDTO) {
        if ( productoCategoriaDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( productoCategoriaDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa productoCategoriaDTOToEmpresa(ProductoCategoriaDTO productoCategoriaDTO) {
        if ( productoCategoriaDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( productoCategoriaDTO.getEmpresaId() );

        return empresa.build();
    }
}
