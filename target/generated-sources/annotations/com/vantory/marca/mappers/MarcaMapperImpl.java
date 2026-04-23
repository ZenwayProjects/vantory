package com.vantory.marca.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.marca.Marca;
import com.vantory.marca.dtos.MarcaDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class MarcaMapperImpl implements MarcaMapper {

    @Override
    public MarcaDTO toDTO(Marca marca) {
        if ( marca == null ) {
            return null;
        }

        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = marcaEstadoId( marca );
        empresaId = marcaEmpresaId( marca );
        id = marca.getId();
        nombre = marca.getNombre();
        descripcion = marca.getDescripcion();

        MarcaDTO marcaDTO = new MarcaDTO( id, nombre, descripcion, estadoId, empresaId );

        return marcaDTO;
    }

    @Override
    public Marca toEntity(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        Marca.MarcaBuilder marca = Marca.builder();

        marca.estado( marcaDTOToEstado( marcaDTO ) );
        marca.empresa( marcaDTOToEmpresa( marcaDTO ) );
        marca.id( marcaDTO.getId() );
        marca.nombre( marcaDTO.getNombre() );
        marca.descripcion( marcaDTO.getDescripcion() );

        return marca.build();
    }

    @Override
    public MarcaDTO toListDto(Marca marca) {
        if ( marca == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = marcaEstadoId( marca );
        id = marca.getId();
        nombre = marca.getNombre();
        descripcion = marca.getDescripcion();

        Long empresaId = null;

        MarcaDTO marcaDTO = new MarcaDTO( id, nombre, descripcion, estadoId, empresaId );

        return marcaDTO;
    }

    private Long marcaEstadoId(Marca marca) {
        Estado estado = marca.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long marcaEmpresaId(Marca marca) {
        Empresa empresa = marca.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado marcaDTOToEstado(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( marcaDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa marcaDTOToEmpresa(MarcaDTO marcaDTO) {
        if ( marcaDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( marcaDTO.getEmpresaId() );

        return empresa.build();
    }
}
