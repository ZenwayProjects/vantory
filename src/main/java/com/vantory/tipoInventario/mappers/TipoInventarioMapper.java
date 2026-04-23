package com.vantory.tipoInventario.mappers;

import com.vantory.tipoInventario.TipoInventario;
import com.vantory.tipoInventario.dtos.TipoInventarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoInventarioMapper {

	@Mapping(source = "estado.id", target = "estadoId")
	@Mapping(source = "empresa.id", target = "empresaId", ignore = true)
	TipoInventarioDTO toDTO(TipoInventario tipoInventario);

	@Mapping(source = "estadoId", target = "estado.id")
	@Mapping(source = "empresaId", target = "empresa.id")
	TipoInventario toEntity(TipoInventarioDTO tipoInventarioDTO);

}
