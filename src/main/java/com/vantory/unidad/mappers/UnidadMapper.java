package com.vantory.unidad.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.vantory.unidad.Unidad;
import com.vantory.unidad.dtos.UnidadDTO;

@Mapper(componentModel = "spring")
public interface UnidadMapper {

	@Mapping(source = "estado.id", target = "estadoId")
    @Mapping(source = "tipoUnidad.id", target = "tipoUnidadId")
	UnidadDTO toDTO(Unidad unidad);

	@Mapping(source = "estadoId", target = "estado.id")
	@Mapping(source = "tipoUnidadId", target = "tipoUnidad.id")
	Unidad toEntity(UnidadDTO unidadDTO);

}
