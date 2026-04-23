package com.vantory.modelo.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.modelo.Modelo;
import com.vantory.modelo.dtos.ModeloDTO;
import com.vantory.producto.Producto;
import com.vantory.tipoModelo.TipoModelo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ModeloMapperImpl implements ModeloMapper {

    @Override
    public ModeloDTO toDto(Modelo modelo) {
        if ( modelo == null ) {
            return null;
        }

        ModeloDTO.ModeloDTOBuilder modeloDTO = ModeloDTO.builder();

        modeloDTO.productoId( modeloProductoId( modelo ) );
        modeloDTO.tipoModeloId( modeloTipoModeloId( modelo ) );
        modeloDTO.estadoId( modeloEstadoId( modelo ) );
        modeloDTO.empresaId( modeloEmpresaId( modelo ) );
        modeloDTO.id( modelo.getId() );
        modeloDTO.nombre( modelo.getNombre() );
        modeloDTO.descripcion( modelo.getDescripcion() );
        modeloDTO.url( modelo.getUrl() );
        modeloDTO.fechaHoraInicio( modelo.getFechaHoraInicio() );
        modeloDTO.fechaHoraFin( modelo.getFechaHoraFin() );
        modeloDTO.fechaHoraCreacion( modelo.getFechaHoraCreacion() );

        return modeloDTO.build();
    }

    @Override
    public Modelo toEntity(ModeloDTO modeloDTO) {
        if ( modeloDTO == null ) {
            return null;
        }

        Modelo.ModeloBuilder modelo = Modelo.builder();

        modelo.producto( modeloDTOToProducto( modeloDTO ) );
        modelo.tipoModelo( modeloDTOToTipoModelo( modeloDTO ) );
        modelo.estado( modeloDTOToEstado( modeloDTO ) );
        modelo.empresa( modeloDTOToEmpresa( modeloDTO ) );
        modelo.id( modeloDTO.getId() );
        modelo.nombre( modeloDTO.getNombre() );
        modelo.descripcion( modeloDTO.getDescripcion() );
        modelo.url( modeloDTO.getUrl() );
        modelo.fechaHoraInicio( modeloDTO.getFechaHoraInicio() );
        modelo.fechaHoraFin( modeloDTO.getFechaHoraFin() );
        modelo.fechaHoraCreacion( modeloDTO.getFechaHoraCreacion() );

        return modelo.build();
    }

    @Override
    public ModeloDTO toListDTO(Modelo modelo) {
        if ( modelo == null ) {
            return null;
        }

        ModeloDTO.ModeloDTOBuilder modeloDTO = ModeloDTO.builder();

        modeloDTO.productoId( modeloProductoId( modelo ) );
        modeloDTO.tipoModeloId( modeloTipoModeloId( modelo ) );
        modeloDTO.estadoId( modeloEstadoId( modelo ) );
        modeloDTO.id( modelo.getId() );
        modeloDTO.nombre( modelo.getNombre() );
        modeloDTO.descripcion( modelo.getDescripcion() );
        modeloDTO.url( modelo.getUrl() );
        modeloDTO.fechaHoraInicio( modelo.getFechaHoraInicio() );
        modeloDTO.fechaHoraFin( modelo.getFechaHoraFin() );
        modeloDTO.fechaHoraCreacion( modelo.getFechaHoraCreacion() );

        return modeloDTO.build();
    }

    private Long modeloProductoId(Modelo modelo) {
        Producto producto = modelo.getProducto();
        if ( producto == null ) {
            return null;
        }
        return producto.getId();
    }

    private Long modeloTipoModeloId(Modelo modelo) {
        TipoModelo tipoModelo = modelo.getTipoModelo();
        if ( tipoModelo == null ) {
            return null;
        }
        return tipoModelo.getId();
    }

    private Long modeloEstadoId(Modelo modelo) {
        Estado estado = modelo.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long modeloEmpresaId(Modelo modelo) {
        Empresa empresa = modelo.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Producto modeloDTOToProducto(ModeloDTO modeloDTO) {
        if ( modeloDTO == null ) {
            return null;
        }

        Producto.ProductoBuilder producto = Producto.builder();

        producto.id( modeloDTO.getProductoId() );

        return producto.build();
    }

    protected TipoModelo modeloDTOToTipoModelo(ModeloDTO modeloDTO) {
        if ( modeloDTO == null ) {
            return null;
        }

        TipoModelo.TipoModeloBuilder tipoModelo = TipoModelo.builder();

        tipoModelo.id( modeloDTO.getTipoModeloId() );

        return tipoModelo.build();
    }

    protected Estado modeloDTOToEstado(ModeloDTO modeloDTO) {
        if ( modeloDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( modeloDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa modeloDTOToEmpresa(ModeloDTO modeloDTO) {
        if ( modeloDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( modeloDTO.getEmpresaId() );

        return empresa.build();
    }
}
