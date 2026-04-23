package com.vantory.cierreinventario.mappers;

import com.vantory.almacen.Almacen;
import com.vantory.cierreinventario.CierreInventario;
import com.vantory.cierreinventario.dtos.CierreInventarioRequestDTO;
import com.vantory.cierreinventario.dtos.CierreInventarioResponseDTO;
import com.vantory.empresa.Empresa;
import com.vantory.user.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CierreInventarioMapperImpl implements CierreInventarioMapper {

    @Override
    public CierreInventario toEntity(CierreInventarioRequestDTO cierreInventarioRequestDTO) {
        if ( cierreInventarioRequestDTO == null ) {
            return null;
        }

        CierreInventario.CierreInventarioBuilder cierreInventario = CierreInventario.builder();

        return cierreInventario.build();
    }

    @Override
    public CierreInventarioResponseDTO toDTO(CierreInventario cierreInventario) {
        if ( cierreInventario == null ) {
            return null;
        }

        CierreInventarioResponseDTO cierreInventarioResponseDTO = new CierreInventarioResponseDTO();

        cierreInventarioResponseDTO.setEmpresaNombre( cierreInventarioEmpresaNombre( cierreInventario ) );
        cierreInventarioResponseDTO.setUsuarioNombre( cierreInventarioUsuarioUsername( cierreInventario ) );
        cierreInventarioResponseDTO.setAlmacenNombre( cierreInventarioAlmacenNombre( cierreInventario ) );
        cierreInventarioResponseDTO.setId( cierreInventario.getId() );
        cierreInventarioResponseDTO.setFechaCorte( cierreInventario.getFechaCorte() );
        cierreInventarioResponseDTO.setDescripcion( cierreInventario.getDescripcion() );

        return cierreInventarioResponseDTO;
    }

    private String cierreInventarioEmpresaNombre(CierreInventario cierreInventario) {
        Empresa empresa = cierreInventario.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getNombre();
    }

    private String cierreInventarioUsuarioUsername(CierreInventario cierreInventario) {
        User usuario = cierreInventario.getUsuario();
        if ( usuario == null ) {
            return null;
        }
        return usuario.getUsername();
    }

    private String cierreInventarioAlmacenNombre(CierreInventario cierreInventario) {
        Almacen almacen = cierreInventario.getAlmacen();
        if ( almacen == null ) {
            return null;
        }
        return almacen.getNombre();
    }
}
