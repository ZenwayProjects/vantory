package com.vantory.empresarol.mappers;

import com.vantory.empresarol.EmpresaRol;
import com.vantory.empresarol.dtos.requests.EmpresaRolSystemUpdateRequestDTO;
import com.vantory.empresarol.dtos.requests.EmpresaRolUpdateRequestDTO;
import com.vantory.empresarol.dtos.responses.EmpresaRolResponseDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface EmpresaRolMapper {


    @Mapping(target = "empresaNombre", source = "empresa.nombre")
    @Mapping(target = "rolNombre", source = "rol.nombre")
    @Mapping(target = "estadoNombre", source = "estado.nombre")
    EmpresaRolResponseDTO toResponseDto(EmpresaRol empresaRol);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDto(
            EmpresaRolUpdateRequestDTO dto, @MappingTarget EmpresaRol entity
    );


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAdminEntityFromDto(
            EmpresaRolSystemUpdateRequestDTO dto, @MappingTarget EmpresaRol entity
    );
}
