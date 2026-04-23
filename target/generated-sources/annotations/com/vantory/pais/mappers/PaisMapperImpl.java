package com.vantory.pais.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.pais.Pais;
import com.vantory.pais.dtos.PaisDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PaisMapperImpl implements PaisMapper {

    @Override
    public PaisDTO toDTO(Pais pais) {
        if ( pais == null ) {
            return null;
        }

        Long empresaId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        Long codigo = null;
        String acronimo = null;

        empresaId = paisEmpresaId( pais );
        estadoId = paisEstadoId( pais );
        id = pais.getId();
        nombre = pais.getNombre();
        codigo = pais.getCodigo();
        acronimo = pais.getAcronimo();

        PaisDTO paisDTO = new PaisDTO( id, nombre, codigo, acronimo, empresaId, estadoId );

        return paisDTO;
    }

    @Override
    public Pais toEntity(PaisDTO paisDTO) {
        if ( paisDTO == null ) {
            return null;
        }

        Pais.PaisBuilder pais = Pais.builder();

        pais.empresa( paisDTOToEmpresa( paisDTO ) );
        pais.estado( paisDTOToEstado( paisDTO ) );
        pais.id( paisDTO.getId() );
        pais.nombre( paisDTO.getNombre() );
        pais.codigo( paisDTO.getCodigo() );
        pais.acronimo( paisDTO.getAcronimo() );

        return pais.build();
    }

    @Override
    public PaisDTO toListDto(Pais pais) {
        if ( pais == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        Long codigo = null;
        String acronimo = null;
        Long estadoId = null;

        id = pais.getId();
        nombre = pais.getNombre();
        codigo = pais.getCodigo();
        acronimo = pais.getAcronimo();
        estadoId = paisEstadoId( pais );

        Long empresaId = null;

        PaisDTO paisDTO = new PaisDTO( id, nombre, codigo, acronimo, empresaId, estadoId );

        return paisDTO;
    }

    private Long paisEmpresaId(Pais pais) {
        Empresa empresa = pais.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long paisEstadoId(Pais pais) {
        Estado estado = pais.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Empresa paisDTOToEmpresa(PaisDTO paisDTO) {
        if ( paisDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( paisDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Estado paisDTOToEstado(PaisDTO paisDTO) {
        if ( paisDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( paisDTO.getEstadoId() );

        return estado.build();
    }
}
