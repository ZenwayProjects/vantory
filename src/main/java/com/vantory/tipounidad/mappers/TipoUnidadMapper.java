package com.vantory.tipounidad.mappers;

import com.vantory.tipounidad.TipoUnidad;
import com.vantory.tipounidad.dtos.TipoUnidadDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TipoUnidadMapper {

	@Mapping(source = "estado.id", target = "estadoId")
	TipoUnidadDTO toDTO(TipoUnidad unidad);

	@Mapping(source = "estadoId", target = "estado.id")
	TipoUnidad toEntity(TipoUnidadDTO tipoUnidadDTO);

}
