package com.vantory.productoCategoria.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vantory.productoCategoria.ProductoCategoria;
import com.vantory.productoCategoria.dtos.ProductoCategoriaDTO;

@Mapper(componentModel = "spring")
public interface ProductoCategoriaMapper {

	@Mapping(source = "estado.id", target = "estadoId")
	@Mapping(source = "empresa.id", target = "empresaId")
	ProductoCategoriaDTO toDTO(ProductoCategoria productoCategoria);

	@Mapping(source = "estadoId", target = "estado.id")
	@Mapping(source = "empresaId", target = "empresa.id")
	ProductoCategoria toEntity(ProductoCategoriaDTO productoCategoriaDTO);

	@Mapping(source = "estado.id", target = "estadoId")
	@Mapping(ignore = true, target = "empresaId")
	ProductoCategoriaDTO toListDto(ProductoCategoria productoCategoria);

}
