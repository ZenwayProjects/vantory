package com.vantory.cierreinventario.mappers;

import com.vantory.cierreinventario.CierreInventario;
import com.vantory.cierreinventario.dtos.CierreInventarioRequestDTO;
import com.vantory.cierreinventario.dtos.CierreInventarioResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CierreInventarioMapper {


    CierreInventario toEntity(CierreInventarioRequestDTO cierreInventarioRequestDTO);


    @Mapping(target = "empresaNombre", source = "empresa.nombre")
    @Mapping(target = "usuarioNombre", source = "usuario.username")
    @Mapping(target = "almacenNombre", source = "almacen.nombre")
    CierreInventarioResponseDTO toDTO(CierreInventario cierreInventario);

}
