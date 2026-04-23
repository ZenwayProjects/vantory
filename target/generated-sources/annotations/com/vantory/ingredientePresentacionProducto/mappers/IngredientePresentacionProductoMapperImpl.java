package com.vantory.ingredientePresentacionProducto.mappers;

import com.vantory.estado.Estado;
import com.vantory.ingrediente.Ingrediente;
import com.vantory.ingredientePresentacionProducto.IngredientePresentacionProducto;
import com.vantory.ingredientePresentacionProducto.dtos.IngredientePresentacionProductoRequestDTO;
import com.vantory.ingredientePresentacionProducto.dtos.IngredientePresentacionProductoResponseDTO;
import com.vantory.presentacionProducto.PresentacionProducto;
import com.vantory.producto.Producto;
import com.vantory.unidad.Unidad;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:59-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class IngredientePresentacionProductoMapperImpl implements IngredientePresentacionProductoMapper {

    @Override
    public IngredientePresentacionProductoResponseDTO toDto(IngredientePresentacionProducto entity) {
        if ( entity == null ) {
            return null;
        }

        IngredientePresentacionProductoResponseDTO.IngredientePresentacionProductoResponseDTOBuilder ingredientePresentacionProductoResponseDTO = IngredientePresentacionProductoResponseDTO.builder();

        ingredientePresentacionProductoResponseDTO.idIngredientePresentacionProducto( entity.getId() );
        ingredientePresentacionProductoResponseDTO.nombreProducto( entityPresentacionProductoProductoNombre( entity ) );
        ingredientePresentacionProductoResponseDTO.idPresentacionProducto( entityPresentacionProductoId( entity ) );
        ingredientePresentacionProductoResponseDTO.nombrePresentacionProducto( entityPresentacionProductoNombre( entity ) );

        ingredientePresentacionProductoResponseDTO.ingrediente( new com.vantory.ingredientePresentacionProducto.dtos.IngredientesDTO(entity.getIngrediente().getId(), entity.getIngrediente().getNombre(), entity.getCantidad(), (entity.getUnidad() != null ? entity.getUnidad().getId() : null), (entity.getUnidad() != null ? entity.getUnidad().getNombre() : null), entity.getEstado().getId(), entity.getEstado().getNombre()) );

        return ingredientePresentacionProductoResponseDTO.build();
    }

    @Override
    public IngredientePresentacionProducto toEntity(IngredientePresentacionProductoRequestDTO ingredientePresentacionProductoRequestDTO) {
        if ( ingredientePresentacionProductoRequestDTO == null ) {
            return null;
        }

        IngredientePresentacionProducto.IngredientePresentacionProductoBuilder ingredientePresentacionProducto = IngredientePresentacionProducto.builder();

        ingredientePresentacionProducto.ingrediente( ingredientePresentacionProductoRequestDTOToIngrediente( ingredientePresentacionProductoRequestDTO ) );
        ingredientePresentacionProducto.presentacionProducto( ingredientePresentacionProductoRequestDTOToPresentacionProducto( ingredientePresentacionProductoRequestDTO ) );
        ingredientePresentacionProducto.estado( ingredientePresentacionProductoRequestDTOToEstado( ingredientePresentacionProductoRequestDTO ) );
        ingredientePresentacionProducto.unidad( ingredientePresentacionProductoRequestDTOToUnidad( ingredientePresentacionProductoRequestDTO ) );
        if ( ingredientePresentacionProductoRequestDTO.cantidad() != null ) {
            ingredientePresentacionProducto.cantidad( BigDecimal.valueOf( ingredientePresentacionProductoRequestDTO.cantidad() ) );
        }

        return ingredientePresentacionProducto.build();
    }

    private String entityPresentacionProductoProductoNombre(IngredientePresentacionProducto ingredientePresentacionProducto) {
        PresentacionProducto presentacionProducto = ingredientePresentacionProducto.getPresentacionProducto();
        if ( presentacionProducto == null ) {
            return null;
        }
        Producto producto = presentacionProducto.getProducto();
        if ( producto == null ) {
            return null;
        }
        return producto.getNombre();
    }

    private Long entityPresentacionProductoId(IngredientePresentacionProducto ingredientePresentacionProducto) {
        PresentacionProducto presentacionProducto = ingredientePresentacionProducto.getPresentacionProducto();
        if ( presentacionProducto == null ) {
            return null;
        }
        return presentacionProducto.getId();
    }

    private String entityPresentacionProductoNombre(IngredientePresentacionProducto ingredientePresentacionProducto) {
        PresentacionProducto presentacionProducto = ingredientePresentacionProducto.getPresentacionProducto();
        if ( presentacionProducto == null ) {
            return null;
        }
        return presentacionProducto.getNombre();
    }

    protected Ingrediente ingredientePresentacionProductoRequestDTOToIngrediente(IngredientePresentacionProductoRequestDTO ingredientePresentacionProductoRequestDTO) {
        if ( ingredientePresentacionProductoRequestDTO == null ) {
            return null;
        }

        Ingrediente.IngredienteBuilder ingrediente = Ingrediente.builder();

        ingrediente.id( ingredientePresentacionProductoRequestDTO.ingredienteId() );

        return ingrediente.build();
    }

    protected PresentacionProducto ingredientePresentacionProductoRequestDTOToPresentacionProducto(IngredientePresentacionProductoRequestDTO ingredientePresentacionProductoRequestDTO) {
        if ( ingredientePresentacionProductoRequestDTO == null ) {
            return null;
        }

        PresentacionProducto.PresentacionProductoBuilder presentacionProducto = PresentacionProducto.builder();

        presentacionProducto.id( ingredientePresentacionProductoRequestDTO.presentacionProductoId() );

        return presentacionProducto.build();
    }

    protected Estado ingredientePresentacionProductoRequestDTOToEstado(IngredientePresentacionProductoRequestDTO ingredientePresentacionProductoRequestDTO) {
        if ( ingredientePresentacionProductoRequestDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( ingredientePresentacionProductoRequestDTO.estadoId() );

        return estado.build();
    }

    protected Unidad ingredientePresentacionProductoRequestDTOToUnidad(IngredientePresentacionProductoRequestDTO ingredientePresentacionProductoRequestDTO) {
        if ( ingredientePresentacionProductoRequestDTO == null ) {
            return null;
        }

        Unidad.UnidadBuilder unidad = Unidad.builder();

        unidad.id( ingredientePresentacionProductoRequestDTO.unidadId() );

        return unidad.build();
    }
}
