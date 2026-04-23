package com.vantory.articuloOrdenCompra.mappers;

import com.vantory.articuloOrdenCompra.ArticuloOrdenCompra;
import com.vantory.articuloOrdenCompra.dtos.ArticuloOrdenCompraDTO;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.ordenCompra.OrdenCompra;
import com.vantory.presentacionProducto.PresentacionProducto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ArticuloOrdenCompraMapperImpl implements ArticuloOrdenCompraMapper {

    @Override
    public ArticuloOrdenCompraDTO toDTO(ArticuloOrdenCompra articuloOrdenCompra) {
        if ( articuloOrdenCompra == null ) {
            return null;
        }

        ArticuloOrdenCompraDTO.ArticuloOrdenCompraDTOBuilder articuloOrdenCompraDTO = ArticuloOrdenCompraDTO.builder();

        articuloOrdenCompraDTO.ordenCompraId( articuloOrdenCompraOrdenCompraId( articuloOrdenCompra ) );
        articuloOrdenCompraDTO.presentacionProductoId( articuloOrdenCompraPresentacionProductoId( articuloOrdenCompra ) );
        articuloOrdenCompraDTO.estadoId( articuloOrdenCompraEstadoId( articuloOrdenCompra ) );
        articuloOrdenCompraDTO.empresaId( articuloOrdenCompraEmpresaId( articuloOrdenCompra ) );
        articuloOrdenCompraDTO.id( articuloOrdenCompra.getId() );
        articuloOrdenCompraDTO.cantidad( articuloOrdenCompra.getCantidad() );
        articuloOrdenCompraDTO.precio( articuloOrdenCompra.getPrecio() );

        return articuloOrdenCompraDTO.build();
    }

    @Override
    public ArticuloOrdenCompra toEntity(ArticuloOrdenCompraDTO articuloOrdenCompraDTO) {
        if ( articuloOrdenCompraDTO == null ) {
            return null;
        }

        ArticuloOrdenCompra.ArticuloOrdenCompraBuilder articuloOrdenCompra = ArticuloOrdenCompra.builder();

        articuloOrdenCompra.ordenCompra( articuloOrdenCompraDTOToOrdenCompra( articuloOrdenCompraDTO ) );
        articuloOrdenCompra.presentacionProducto( articuloOrdenCompraDTOToPresentacionProducto( articuloOrdenCompraDTO ) );
        articuloOrdenCompra.estado( articuloOrdenCompraDTOToEstado( articuloOrdenCompraDTO ) );
        articuloOrdenCompra.empresa( articuloOrdenCompraDTOToEmpresa( articuloOrdenCompraDTO ) );
        articuloOrdenCompra.id( articuloOrdenCompraDTO.getId() );
        articuloOrdenCompra.cantidad( articuloOrdenCompraDTO.getCantidad() );
        articuloOrdenCompra.precio( articuloOrdenCompraDTO.getPrecio() );

        return articuloOrdenCompra.build();
    }

    @Override
    public ArticuloOrdenCompraDTO toListDTO(ArticuloOrdenCompra articuloOrdenCompra) {
        if ( articuloOrdenCompra == null ) {
            return null;
        }

        ArticuloOrdenCompraDTO.ArticuloOrdenCompraDTOBuilder articuloOrdenCompraDTO = ArticuloOrdenCompraDTO.builder();

        articuloOrdenCompraDTO.ordenCompraId( articuloOrdenCompraOrdenCompraId( articuloOrdenCompra ) );
        articuloOrdenCompraDTO.presentacionProductoId( articuloOrdenCompraPresentacionProductoId( articuloOrdenCompra ) );
        articuloOrdenCompraDTO.estadoId( articuloOrdenCompraEstadoId( articuloOrdenCompra ) );
        articuloOrdenCompraDTO.id( articuloOrdenCompra.getId() );
        articuloOrdenCompraDTO.cantidad( articuloOrdenCompra.getCantidad() );
        articuloOrdenCompraDTO.precio( articuloOrdenCompra.getPrecio() );

        return articuloOrdenCompraDTO.build();
    }

    private Long articuloOrdenCompraOrdenCompraId(ArticuloOrdenCompra articuloOrdenCompra) {
        OrdenCompra ordenCompra = articuloOrdenCompra.getOrdenCompra();
        if ( ordenCompra == null ) {
            return null;
        }
        return ordenCompra.getId();
    }

    private Long articuloOrdenCompraPresentacionProductoId(ArticuloOrdenCompra articuloOrdenCompra) {
        PresentacionProducto presentacionProducto = articuloOrdenCompra.getPresentacionProducto();
        if ( presentacionProducto == null ) {
            return null;
        }
        return presentacionProducto.getId();
    }

    private Long articuloOrdenCompraEstadoId(ArticuloOrdenCompra articuloOrdenCompra) {
        Estado estado = articuloOrdenCompra.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long articuloOrdenCompraEmpresaId(ArticuloOrdenCompra articuloOrdenCompra) {
        Empresa empresa = articuloOrdenCompra.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected OrdenCompra articuloOrdenCompraDTOToOrdenCompra(ArticuloOrdenCompraDTO articuloOrdenCompraDTO) {
        if ( articuloOrdenCompraDTO == null ) {
            return null;
        }

        OrdenCompra.OrdenCompraBuilder ordenCompra = OrdenCompra.builder();

        ordenCompra.id( articuloOrdenCompraDTO.getOrdenCompraId() );

        return ordenCompra.build();
    }

    protected PresentacionProducto articuloOrdenCompraDTOToPresentacionProducto(ArticuloOrdenCompraDTO articuloOrdenCompraDTO) {
        if ( articuloOrdenCompraDTO == null ) {
            return null;
        }

        PresentacionProducto.PresentacionProductoBuilder presentacionProducto = PresentacionProducto.builder();

        presentacionProducto.id( articuloOrdenCompraDTO.getPresentacionProductoId() );

        return presentacionProducto.build();
    }

    protected Estado articuloOrdenCompraDTOToEstado(ArticuloOrdenCompraDTO articuloOrdenCompraDTO) {
        if ( articuloOrdenCompraDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( articuloOrdenCompraDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa articuloOrdenCompraDTOToEmpresa(ArticuloOrdenCompraDTO articuloOrdenCompraDTO) {
        if ( articuloOrdenCompraDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( articuloOrdenCompraDTO.getEmpresaId() );

        return empresa.build();
    }
}
