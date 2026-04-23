package com.vantory.cierreinventariodetalle.mappers;

import com.vantory.cierreinventariodetalle.CierreInventarioDetalle;
import com.vantory.cierreinventariodetalle.dtos.CierreInventarioDetalleResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CierreInventarioDetalleMapper {

    @Mapping(target = "cierreInventarioId", source = "cierreInventario.id")
    @Mapping(target = "productoPresentacionNombre", source = "presentacionProducto.nombre")
    @Mapping(target = "empresaNombre", source = "empresa.nombre")
    @Mapping(target = "almacenNombre", source = "almacen.nombre")
    CierreInventarioDetalleResponseDTO toResponseDTO(CierreInventarioDetalle cierreInventarioDetalle);
}
