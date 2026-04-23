package com.vantory.articuloKardex.mappers;

import com.vantory.articuloKardex.ArticuloKardex;
import com.vantory.articuloKardex.dtos.ArticuloKardexDTO;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.kardex.Kardex;
import com.vantory.presentacionProducto.PresentacionProducto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ArticuloKardexMapperImpl implements ArticuloKardexMapper {

    @Override
    public ArticuloKardexDTO toDTO(ArticuloKardex articuloKardex) {
        if ( articuloKardex == null ) {
            return null;
        }

        ArticuloKardexDTO articuloKardexDTO = new ArticuloKardexDTO();

        articuloKardexDTO.setKardexId( articuloKardexKardexId( articuloKardex ) );
        articuloKardexDTO.setPresentacionProductoId( articuloKardexPresentacionProductoId( articuloKardex ) );
        articuloKardexDTO.setEstadoId( articuloKardexEstadoId( articuloKardex ) );
        articuloKardexDTO.setEmpresaId( articuloKardexEmpresaId( articuloKardex ) );
        articuloKardexDTO.setId( articuloKardex.getId() );
        articuloKardexDTO.setCantidad( articuloKardex.getCantidad() );
        articuloKardexDTO.setPrecio( articuloKardex.getPrecio() );
        articuloKardexDTO.setFechaVencimiento( articuloKardex.getFechaVencimiento() );
        articuloKardexDTO.setIdentificadorProducto( articuloKardex.getIdentificadorProducto() );
        articuloKardexDTO.setLote( articuloKardex.getLote() );
        articuloKardexDTO.setUsername( articuloKardex.getUsername() );
        articuloKardexDTO.setRol( articuloKardex.getRol() );
        articuloKardexDTO.setIp( articuloKardex.getIp() );
        articuloKardexDTO.setHost( articuloKardex.getHost() );
        articuloKardexDTO.setFechaHora( articuloKardex.getFechaHora() );

        return articuloKardexDTO;
    }

    @Override
    public ArticuloKardex toEntity(ArticuloKardexDTO articuloKardexDTO) {
        if ( articuloKardexDTO == null ) {
            return null;
        }

        ArticuloKardex.ArticuloKardexBuilder articuloKardex = ArticuloKardex.builder();

        articuloKardex.kardex( articuloKardexDTOToKardex( articuloKardexDTO ) );
        articuloKardex.presentacionProducto( articuloKardexDTOToPresentacionProducto( articuloKardexDTO ) );
        articuloKardex.estado( articuloKardexDTOToEstado( articuloKardexDTO ) );
        articuloKardex.empresa( articuloKardexDTOToEmpresa( articuloKardexDTO ) );
        articuloKardex.id( articuloKardexDTO.getId() );
        articuloKardex.cantidad( articuloKardexDTO.getCantidad() );
        articuloKardex.precio( articuloKardexDTO.getPrecio() );
        articuloKardex.fechaVencimiento( articuloKardexDTO.getFechaVencimiento() );
        articuloKardex.identificadorProducto( articuloKardexDTO.getIdentificadorProducto() );
        articuloKardex.lote( articuloKardexDTO.getLote() );
        articuloKardex.username( articuloKardexDTO.getUsername() );
        articuloKardex.rol( articuloKardexDTO.getRol() );
        articuloKardex.ip( articuloKardexDTO.getIp() );
        articuloKardex.host( articuloKardexDTO.getHost() );
        articuloKardex.fechaHora( articuloKardexDTO.getFechaHora() );

        return articuloKardex.build();
    }

    @Override
    public ArticuloKardexDTO toListDTO(ArticuloKardex articuloKardex) {
        if ( articuloKardex == null ) {
            return null;
        }

        ArticuloKardexDTO articuloKardexDTO = new ArticuloKardexDTO();

        articuloKardexDTO.setKardexId( articuloKardexKardexId( articuloKardex ) );
        articuloKardexDTO.setPresentacionProductoId( articuloKardexPresentacionProductoId( articuloKardex ) );
        articuloKardexDTO.setEstadoId( articuloKardexEstadoId( articuloKardex ) );
        articuloKardexDTO.setId( articuloKardex.getId() );
        articuloKardexDTO.setCantidad( articuloKardex.getCantidad() );
        articuloKardexDTO.setPrecio( articuloKardex.getPrecio() );
        articuloKardexDTO.setFechaVencimiento( articuloKardex.getFechaVencimiento() );
        articuloKardexDTO.setIdentificadorProducto( articuloKardex.getIdentificadorProducto() );
        articuloKardexDTO.setLote( articuloKardex.getLote() );
        articuloKardexDTO.setUsername( articuloKardex.getUsername() );
        articuloKardexDTO.setRol( articuloKardex.getRol() );
        articuloKardexDTO.setIp( articuloKardex.getIp() );
        articuloKardexDTO.setHost( articuloKardex.getHost() );
        articuloKardexDTO.setFechaHora( articuloKardex.getFechaHora() );

        return articuloKardexDTO;
    }

    private Long articuloKardexKardexId(ArticuloKardex articuloKardex) {
        Kardex kardex = articuloKardex.getKardex();
        if ( kardex == null ) {
            return null;
        }
        return kardex.getId();
    }

    private Long articuloKardexPresentacionProductoId(ArticuloKardex articuloKardex) {
        PresentacionProducto presentacionProducto = articuloKardex.getPresentacionProducto();
        if ( presentacionProducto == null ) {
            return null;
        }
        return presentacionProducto.getId();
    }

    private Long articuloKardexEstadoId(ArticuloKardex articuloKardex) {
        Estado estado = articuloKardex.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long articuloKardexEmpresaId(ArticuloKardex articuloKardex) {
        Empresa empresa = articuloKardex.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Kardex articuloKardexDTOToKardex(ArticuloKardexDTO articuloKardexDTO) {
        if ( articuloKardexDTO == null ) {
            return null;
        }

        Kardex.KardexBuilder kardex = Kardex.builder();

        kardex.id( articuloKardexDTO.getKardexId() );

        return kardex.build();
    }

    protected PresentacionProducto articuloKardexDTOToPresentacionProducto(ArticuloKardexDTO articuloKardexDTO) {
        if ( articuloKardexDTO == null ) {
            return null;
        }

        PresentacionProducto.PresentacionProductoBuilder presentacionProducto = PresentacionProducto.builder();

        presentacionProducto.id( articuloKardexDTO.getPresentacionProductoId() );

        return presentacionProducto.build();
    }

    protected Estado articuloKardexDTOToEstado(ArticuloKardexDTO articuloKardexDTO) {
        if ( articuloKardexDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( articuloKardexDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa articuloKardexDTOToEmpresa(ArticuloKardexDTO articuloKardexDTO) {
        if ( articuloKardexDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( articuloKardexDTO.getEmpresaId() );

        return empresa.build();
    }
}
