package com.vantory.productoLocalizacion.mappers;

import com.vantory.articuloKardex.ArticuloKardex;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.productoLocalizacion.ProductoLocalizacion;
import com.vantory.productoLocalizacion.dtos.ProductoLocalizacionDTO;
import com.vantory.subseccion.Subseccion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProductoLocalizacionMapperImpl implements ProductoLocalizacionMapper {

    @Override
    public ProductoLocalizacionDTO toDto(ProductoLocalizacion productoLocalizacion) {
        if ( productoLocalizacion == null ) {
            return null;
        }

        ProductoLocalizacionDTO productoLocalizacionDTO = new ProductoLocalizacionDTO();

        productoLocalizacionDTO.setEmpresaId( productoLocalizacionEmpresaId( productoLocalizacion ) );
        productoLocalizacionDTO.setEstadoId( productoLocalizacionEstadoId( productoLocalizacion ) );
        productoLocalizacionDTO.setSubseccionId( productoLocalizacionSubseccionId( productoLocalizacion ) );
        productoLocalizacionDTO.setArticuloKardexId( productoLocalizacionArticuloKardexId( productoLocalizacion ) );
        productoLocalizacionDTO.setId( productoLocalizacion.getId() );

        return productoLocalizacionDTO;
    }

    @Override
    public ProductoLocalizacion toEntity(ProductoLocalizacionDTO productoLocalizacionDTO) {
        if ( productoLocalizacionDTO == null ) {
            return null;
        }

        ProductoLocalizacion productoLocalizacion = new ProductoLocalizacion();

        productoLocalizacion.setEmpresa( productoLocalizacionDTOToEmpresa( productoLocalizacionDTO ) );
        productoLocalizacion.setEstado( productoLocalizacionDTOToEstado( productoLocalizacionDTO ) );
        productoLocalizacion.setSubseccion( productoLocalizacionDTOToSubseccion( productoLocalizacionDTO ) );
        productoLocalizacion.setArticuloKardex( productoLocalizacionDTOToArticuloKardex( productoLocalizacionDTO ) );
        productoLocalizacion.setId( productoLocalizacionDTO.getId() );

        return productoLocalizacion;
    }

    private Long productoLocalizacionEmpresaId(ProductoLocalizacion productoLocalizacion) {
        Empresa empresa = productoLocalizacion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long productoLocalizacionEstadoId(ProductoLocalizacion productoLocalizacion) {
        Estado estado = productoLocalizacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long productoLocalizacionSubseccionId(ProductoLocalizacion productoLocalizacion) {
        Subseccion subseccion = productoLocalizacion.getSubseccion();
        if ( subseccion == null ) {
            return null;
        }
        return subseccion.getId();
    }

    private Long productoLocalizacionArticuloKardexId(ProductoLocalizacion productoLocalizacion) {
        ArticuloKardex articuloKardex = productoLocalizacion.getArticuloKardex();
        if ( articuloKardex == null ) {
            return null;
        }
        return articuloKardex.getId();
    }

    protected Empresa productoLocalizacionDTOToEmpresa(ProductoLocalizacionDTO productoLocalizacionDTO) {
        if ( productoLocalizacionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( productoLocalizacionDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Estado productoLocalizacionDTOToEstado(ProductoLocalizacionDTO productoLocalizacionDTO) {
        if ( productoLocalizacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( productoLocalizacionDTO.getEstadoId() );

        return estado.build();
    }

    protected Subseccion productoLocalizacionDTOToSubseccion(ProductoLocalizacionDTO productoLocalizacionDTO) {
        if ( productoLocalizacionDTO == null ) {
            return null;
        }

        Subseccion.SubseccionBuilder subseccion = Subseccion.builder();

        subseccion.id( productoLocalizacionDTO.getSubseccionId() );

        return subseccion.build();
    }

    protected ArticuloKardex productoLocalizacionDTOToArticuloKardex(ProductoLocalizacionDTO productoLocalizacionDTO) {
        if ( productoLocalizacionDTO == null ) {
            return null;
        }

        ArticuloKardex.ArticuloKardexBuilder articuloKardex = ArticuloKardex.builder();

        articuloKardex.id( productoLocalizacionDTO.getArticuloKardexId() );

        return articuloKardex.build();
    }
}
