package com.vantory.rol.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.vantory.rol.Rol;
import com.vantory.rol.dtos.RolRequestDTO;
import com.vantory.rol.dtos.RolResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RolMapper {

    @Mapping(target = "estado.id", source = "estadoId")
    Rol toEntity(RolRequestDTO dto);

    @Mapping(target = "estadoId", source = "estado.id")
    @Mapping(target = "estadoNombre", source = "estado.nombre")
    @Mapping(target = "createdBy", source = "createdBy.username")
    @Mapping(target = "updatedBy", source = "updatedBy.username")
    RolResponseDTO toDTO(Rol rol);

}
