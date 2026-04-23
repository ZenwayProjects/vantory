package com.vantory.ingrediente.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.ingrediente.Ingrediente;
import com.vantory.ingrediente.dtos.IngredienteDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class IngredienteMapperImpl implements IngredienteMapper {

    @Override
    public IngredienteDTO toDTO(Ingrediente ingrediente) {
        if ( ingrediente == null ) {
            return null;
        }

        IngredienteDTO.IngredienteDTOBuilder ingredienteDTO = IngredienteDTO.builder();

        ingredienteDTO.estadoId( ingredienteEstadoId( ingrediente ) );
        ingredienteDTO.empresaId( ingredienteEmpresaId( ingrediente ) );
        ingredienteDTO.id( ingrediente.getId() );
        ingredienteDTO.nombre( ingrediente.getNombre() );
        ingredienteDTO.descripcion( ingrediente.getDescripcion() );

        return ingredienteDTO.build();
    }

    @Override
    public Ingrediente toEntity(IngredienteDTO ingredienteDTO) {
        if ( ingredienteDTO == null ) {
            return null;
        }

        Ingrediente.IngredienteBuilder ingrediente = Ingrediente.builder();

        ingrediente.estado( ingredienteDTOToEstado( ingredienteDTO ) );
        ingrediente.empresa( ingredienteDTOToEmpresa( ingredienteDTO ) );
        ingrediente.id( ingredienteDTO.getId() );
        ingrediente.nombre( ingredienteDTO.getNombre() );
        ingrediente.descripcion( ingredienteDTO.getDescripcion() );

        return ingrediente.build();
    }

    @Override
    public IngredienteDTO toListDto(Ingrediente ingrediente) {
        if ( ingrediente == null ) {
            return null;
        }

        IngredienteDTO.IngredienteDTOBuilder ingredienteDTO = IngredienteDTO.builder();

        ingredienteDTO.estadoId( ingredienteEstadoId( ingrediente ) );
        ingredienteDTO.id( ingrediente.getId() );
        ingredienteDTO.nombre( ingrediente.getNombre() );
        ingredienteDTO.descripcion( ingrediente.getDescripcion() );

        return ingredienteDTO.build();
    }

    private Long ingredienteEstadoId(Ingrediente ingrediente) {
        Estado estado = ingrediente.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long ingredienteEmpresaId(Ingrediente ingrediente) {
        Empresa empresa = ingrediente.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado ingredienteDTOToEstado(IngredienteDTO ingredienteDTO) {
        if ( ingredienteDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( ingredienteDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa ingredienteDTOToEmpresa(IngredienteDTO ingredienteDTO) {
        if ( ingredienteDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( ingredienteDTO.getEmpresaId() );

        return empresa.build();
    }
}
