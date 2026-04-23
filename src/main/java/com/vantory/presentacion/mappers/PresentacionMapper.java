package com.vantory.presentacion.mappers;

import com.vantory.presentacion.Presentacion;
import com.vantory.presentacion.dtos.PresentacionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PresentacionMapper {

	@Mapping(source = "estado.id", target = "estadoId")
	@Mapping(source = "empresa.id", target = "empresaId")
	PresentacionDTO toDTO(Presentacion presentacion);

	@Mapping(source = "estadoId", target = "estado.id")
	@Mapping(source = "empresaId", target = "empresa.id")
	Presentacion toEntity(PresentacionDTO presentacionDTO);

}
