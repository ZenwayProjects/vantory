package com.vantory.movimiento.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vantory.movimiento.Movimiento;
import com.vantory.movimiento.dtos.MovimientoDTO;

@Mapper(componentModel = "spring")
public interface MovimientoMapper {

	@Mapping(source = "estado.id", target = "estadoId")
	MovimientoDTO toDTO(Movimiento movimiento);

	@Mapping(source = "estadoId", target = "estado.id")
	Movimiento toEntity(MovimientoDTO movimientoDTO);

}
