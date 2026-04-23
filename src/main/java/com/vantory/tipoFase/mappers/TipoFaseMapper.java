package com.vantory.tipoFase.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vantory.tipoFase.TipoFase;
import com.vantory.tipoFase.dtos.TipoFaseDTO;

@Mapper(componentModel = "spring")
public interface TipoFaseMapper {
    @Mapping(source="estado.id", target="estadoId")
    @Mapping(source="empresa.id", target="empresaId")
    TipoFaseDTO toDto(TipoFase tipoFase);

    @Mapping(source="estadoId", target="estado.id")
    @Mapping(source="empresaId", target="empresa.id")
    TipoFase toEntity(TipoFaseDTO tipoFaseDTO);

    @Mapping(source = "estado.id", target = "estadoId")
    @Mapping(source= "empresa.id", target = "empresaId", ignore = true)
    TipoFaseDTO toListDTO(TipoFase tipoFase);
    


    

    
}
