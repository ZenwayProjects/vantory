package com.vantory.presentacionProducto.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.marca.Marca;
import com.vantory.presentacion.Presentacion;
import com.vantory.presentacionProducto.PresentacionProducto;
import com.vantory.presentacionProducto.dtos.PresentacionProductoDTO;
import com.vantory.producto.Producto;
import com.vantory.unidad.Unidad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PresentacionProductoMapperImpl implements PresentacionProductoMapper {

    @Override
    public PresentacionProductoDTO toDto(PresentacionProducto presentacionProducto) {
        if ( presentacionProducto == null ) {
            return null;
        }

        Long productoId = null;
        Long unidadId = null;
        Long estadoId = null;
        Long marcaId = null;
        Long presentacionId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        Double cantidad = null;
        Boolean desgregar = null;

        productoId = presentacionProductoProductoId( presentacionProducto );
        unidadId = presentacionProductoUnidadId( presentacionProducto );
        estadoId = presentacionProductoEstadoId( presentacionProducto );
        marcaId = presentacionProductoMarcaId( presentacionProducto );
        presentacionId = presentacionProductoPresentacionId( presentacionProducto );
        id = presentacionProducto.getId();
        nombre = presentacionProducto.getNombre();
        descripcion = presentacionProducto.getDescripcion();
        cantidad = presentacionProducto.getCantidad();
        desgregar = presentacionProducto.getDesgregar();

        Long empresaId = null;

        PresentacionProductoDTO presentacionProductoDTO = new PresentacionProductoDTO( id, productoId, nombre, unidadId, descripcion, estadoId, cantidad, marcaId, presentacionId, empresaId, desgregar );

        return presentacionProductoDTO;
    }

    @Override
    public PresentacionProducto toEntity(PresentacionProductoDTO presentacionProductoDTO) {
        if ( presentacionProductoDTO == null ) {
            return null;
        }

        PresentacionProducto.PresentacionProductoBuilder presentacionProducto = PresentacionProducto.builder();

        presentacionProducto.producto( presentacionProductoDTOToProducto( presentacionProductoDTO ) );
        presentacionProducto.unidad( presentacionProductoDTOToUnidad( presentacionProductoDTO ) );
        presentacionProducto.estado( presentacionProductoDTOToEstado( presentacionProductoDTO ) );
        presentacionProducto.marca( presentacionProductoDTOToMarca( presentacionProductoDTO ) );
        presentacionProducto.presentacion( presentacionProductoDTOToPresentacion( presentacionProductoDTO ) );
        presentacionProducto.empresa( presentacionProductoDTOToEmpresa( presentacionProductoDTO ) );
        presentacionProducto.id( presentacionProductoDTO.getId() );
        presentacionProducto.nombre( presentacionProductoDTO.getNombre() );
        presentacionProducto.descripcion( presentacionProductoDTO.getDescripcion() );
        presentacionProducto.cantidad( presentacionProductoDTO.getCantidad() );
        presentacionProducto.desgregar( presentacionProductoDTO.getDesgregar() );

        return presentacionProducto.build();
    }

    private Long presentacionProductoProductoId(PresentacionProducto presentacionProducto) {
        Producto producto = presentacionProducto.getProducto();
        if ( producto == null ) {
            return null;
        }
        return producto.getId();
    }

    private Long presentacionProductoUnidadId(PresentacionProducto presentacionProducto) {
        Unidad unidad = presentacionProducto.getUnidad();
        if ( unidad == null ) {
            return null;
        }
        return unidad.getId();
    }

    private Long presentacionProductoEstadoId(PresentacionProducto presentacionProducto) {
        Estado estado = presentacionProducto.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long presentacionProductoMarcaId(PresentacionProducto presentacionProducto) {
        Marca marca = presentacionProducto.getMarca();
        if ( marca == null ) {
            return null;
        }
        return marca.getId();
    }

    private Long presentacionProductoPresentacionId(PresentacionProducto presentacionProducto) {
        Presentacion presentacion = presentacionProducto.getPresentacion();
        if ( presentacion == null ) {
            return null;
        }
        return presentacion.getId();
    }

    protected Producto presentacionProductoDTOToProducto(PresentacionProductoDTO presentacionProductoDTO) {
        if ( presentacionProductoDTO == null ) {
            return null;
        }

        Producto.ProductoBuilder producto = Producto.builder();

        producto.id( presentacionProductoDTO.getProductoId() );

        return producto.build();
    }

    protected Unidad presentacionProductoDTOToUnidad(PresentacionProductoDTO presentacionProductoDTO) {
        if ( presentacionProductoDTO == null ) {
            return null;
        }

        Unidad.UnidadBuilder unidad = Unidad.builder();

        unidad.id( presentacionProductoDTO.getUnidadId() );

        return unidad.build();
    }

    protected Estado presentacionProductoDTOToEstado(PresentacionProductoDTO presentacionProductoDTO) {
        if ( presentacionProductoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( presentacionProductoDTO.getEstadoId() );

        return estado.build();
    }

    protected Marca presentacionProductoDTOToMarca(PresentacionProductoDTO presentacionProductoDTO) {
        if ( presentacionProductoDTO == null ) {
            return null;
        }

        Marca.MarcaBuilder marca = Marca.builder();

        marca.id( presentacionProductoDTO.getMarcaId() );

        return marca.build();
    }

    protected Presentacion presentacionProductoDTOToPresentacion(PresentacionProductoDTO presentacionProductoDTO) {
        if ( presentacionProductoDTO == null ) {
            return null;
        }

        Presentacion presentacion = new Presentacion();

        presentacion.setId( presentacionProductoDTO.getPresentacionId() );

        return presentacion;
    }

    protected Empresa presentacionProductoDTOToEmpresa(PresentacionProductoDTO presentacionProductoDTO) {
        if ( presentacionProductoDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( presentacionProductoDTO.getEmpresaId() );

        return empresa.build();
    }
}
