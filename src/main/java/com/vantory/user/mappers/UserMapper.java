package com.vantory.user.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vantory.user.User;
import com.vantory.user.dtos.UserDTO;
import com.vantory.user.dtos.UserMinimalDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	@Mapping(source = "persona.id", target = "personaId")
	@Mapping(source = "usuarioEstado.id", target = "usuarioEstadoId")
	UserDTO toDto(User user);

	UserMinimalDTO toMinimalDTO(User user);

	@Mapping(source = "personaId", target = "persona.id")
	@Mapping(source = "usuarioEstadoId", target = "usuarioEstado.id")
	@Mapping(target = "roles", ignore = true)
	User toEntity(UserDTO userDTO);

}
