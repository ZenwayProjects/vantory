package com.vantory.tipoProduccion.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vantory.tipoProduccion.TipoProduccion;
import com.vantory.tipoProduccion.dtos.TipoProduccionDTO;

@Mapper(componentModel = "spring")
public interface TipoProduccionMapper {

	@Mapping(source = "estado.id", target = "estadoId")
	@Mapping(source = "empresa.id", target = "empresaId")
	TipoProduccionDTO toDTO(TipoProduccion tipoProduccion);

	@Mapping(source = "estadoId", target = "estado.id")
	@Mapping(source = "empresaId", target = "empresa.id")
	TipoProduccion toEntity(TipoProduccionDTO tipoProduccionDTO);

	@Mapping(source = "estado.id", target = "estadoId")
	@Mapping(source = "empresa.id", target = "empresaId", ignore = true)
	TipoProduccionDTO toListDTO(TipoProduccion tipoProduccion);

}
