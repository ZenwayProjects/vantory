package com.vantory.estadoCategoria.mappers;

import com.vantory.estadoCategoria.EstadoCategoria;
import com.vantory.estadoCategoria.dtos.EstadoCategoriaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadoCategoriaMapper {

	EstadoCategoriaDTO toDTO(EstadoCategoria estadoCategoria);

	EstadoCategoria toEntity(EstadoCategoriaDTO estadoCategoriaDTO);

}
