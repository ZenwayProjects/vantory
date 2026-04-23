package com.vantory.modulo.mappers;

import com.vantory.menu.dtos.MenuModuloResponseDTO;
import com.vantory.menu.repositories.projections.SubModuloRow;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ModuloMapperImpl implements ModuloMapper {

    @Override
    public MenuModuloResponseDTO toDTO(SubModuloRow row) {
        if ( row == null ) {
            return null;
        }

        String id = null;
        String nombre = null;
        String url = null;
        String icono = null;

        id = row.getModNombreId();
        nombre = row.getModNombre();
        url = row.getModUrl();
        icono = row.getModIcon();

        MenuModuloResponseDTO menuModuloResponseDTO = new MenuModuloResponseDTO( id, nombre, url, icono );

        return menuModuloResponseDTO;
    }
}
