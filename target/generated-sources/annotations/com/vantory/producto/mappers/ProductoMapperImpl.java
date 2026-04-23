package com.vantory.producto.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.producto.Producto;
import com.vantory.producto.dtos.ProductoRequestDTO;
import com.vantory.producto.dtos.ProductoResponseDTO;
import com.vantory.productoCategoria.ProductoCategoria;
import com.vantory.unidad.Unidad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:59-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductoMapperImpl implements ProductoMapper {

    @Override
    public ProductoResponseDTO toDto(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        Long productoCategoriaId = null;
        String productoCategoriaNombre = null;
        Long estadoId = null;
        String estadoNombre = null;
        Long unidadMinimaId = null;
        String unidadMinimaNombre = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        Integer cantidadMinima = null;
        Boolean esOrganico = null;

        productoCategoriaId = productoProductoCategoriaId( producto );
        productoCategoriaNombre = productoProductoCategoriaNombre( producto );
        estadoId = productoEstadoId( producto );
        estadoNombre = productoEstadoNombre( producto );
        unidadMinimaId = productoUnidadMinimaId( producto );
        unidadMinimaNombre = productoUnidadMinimaNombre( producto );
        id = producto.getId();
        nombre = producto.getNombre();
        descripcion = producto.getDescripcion();
        cantidadMinima = producto.getCantidadMinima();
        esOrganico = producto.getEsOrganico();

        ProductoResponseDTO productoResponseDTO = new ProductoResponseDTO( id, nombre, productoCategoriaId, productoCategoriaNombre, descripcion, estadoId, estadoNombre, unidadMinimaId, unidadMinimaNombre, cantidadMinima, esOrganico );

        return productoResponseDTO;
    }

    @Override
    public Producto toEntity(ProductoRequestDTO productoRequestDTO) {
        if ( productoRequestDTO == null ) {
            return null;
        }

        Producto.ProductoBuilder producto = Producto.builder();

        producto.productoCategoria( productoRequestDTOToProductoCategoria( productoRequestDTO ) );
        producto.estado( productoRequestDTOToEstado( productoRequestDTO ) );
        producto.empresa( productoRequestDTOToEmpresa( productoRequestDTO ) );
        producto.unidadMinima( productoRequestDTOToUnidad( productoRequestDTO ) );
        producto.nombre( productoRequestDTO.nombre() );
        producto.descripcion( productoRequestDTO.descripcion() );
        producto.cantidadMinima( productoRequestDTO.cantidadMinima() );
        producto.esOrganico( productoRequestDTO.esOrganico() );

        return producto.build();
    }

    private Long productoProductoCategoriaId(Producto producto) {
        ProductoCategoria productoCategoria = producto.getProductoCategoria();
        if ( productoCategoria == null ) {
            return null;
        }
        return productoCategoria.getId();
    }

    private String productoProductoCategoriaNombre(Producto producto) {
        ProductoCategoria productoCategoria = producto.getProductoCategoria();
        if ( productoCategoria == null ) {
            return null;
        }
        return productoCategoria.getNombre();
    }

    private Long productoEstadoId(Producto producto) {
        Estado estado = producto.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private String productoEstadoNombre(Producto producto) {
        Estado estado = producto.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getNombre();
    }

    private Long productoUnidadMinimaId(Producto producto) {
        Unidad unidadMinima = producto.getUnidadMinima();
        if ( unidadMinima == null ) {
            return null;
        }
        return unidadMinima.getId();
    }

    private String productoUnidadMinimaNombre(Producto producto) {
        Unidad unidadMinima = producto.getUnidadMinima();
        if ( unidadMinima == null ) {
            return null;
        }
        return unidadMinima.getNombre();
    }

    protected ProductoCategoria productoRequestDTOToProductoCategoria(ProductoRequestDTO productoRequestDTO) {
        if ( productoRequestDTO == null ) {
            return null;
        }

        ProductoCategoria.ProductoCategoriaBuilder productoCategoria = ProductoCategoria.builder();

        productoCategoria.id( productoRequestDTO.productoCategoriaId() );

        return productoCategoria.build();
    }

    protected Estado productoRequestDTOToEstado(ProductoRequestDTO productoRequestDTO) {
        if ( productoRequestDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( productoRequestDTO.estadoId() );

        return estado.build();
    }

    protected Empresa productoRequestDTOToEmpresa(ProductoRequestDTO productoRequestDTO) {
        if ( productoRequestDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( productoRequestDTO.empresaId() );

        return empresa.build();
    }

    protected Unidad productoRequestDTOToUnidad(ProductoRequestDTO productoRequestDTO) {
        if ( productoRequestDTO == null ) {
            return null;
        }

        Unidad.UnidadBuilder unidad = Unidad.builder();

        unidad.id( productoRequestDTO.unidadMinimaId() );

        return unidad.build();
    }
}
