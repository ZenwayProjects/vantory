package com.vantory.seccion.mapper;

import com.vantory.empresa.Empresa;
import com.vantory.espacio.Espacio;
import com.vantory.estado.Estado;
import com.vantory.seccion.Seccion;
import com.vantory.seccion.dtos.SeccionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SeccionMapperImpl implements SeccionMapper {

    @Override
    public SeccionDTO toDTO(Seccion seccion) {
        if ( seccion == null ) {
            return null;
        }

        SeccionDTO seccionDTO = new SeccionDTO();

        seccionDTO.setEstadoId( seccionEstadoId( seccion ) );
        seccionDTO.setEmpresaId( seccionEmpresaId( seccion ) );
        seccionDTO.setEspacioId( seccionEspacioId( seccion ) );
        seccionDTO.setId( seccion.getId() );
        seccionDTO.setNombre( seccion.getNombre() );
        seccionDTO.setDescripcion( seccion.getDescripcion() );

        return seccionDTO;
    }

    @Override
    public Seccion toEntity(SeccionDTO seccionDTO) {
        if ( seccionDTO == null ) {
            return null;
        }

        Seccion seccion = new Seccion();

        seccion.setEstado( seccionDTOToEstado( seccionDTO ) );
        seccion.setEmpresa( seccionDTOToEmpresa( seccionDTO ) );
        seccion.setEspacio( seccionDTOToEspacio( seccionDTO ) );
        seccion.setId( seccionDTO.getId() );
        seccion.setNombre( seccionDTO.getNombre() );
        seccion.setDescripcion( seccionDTO.getDescripcion() );

        return seccion;
    }

    @Override
    public SeccionDTO toListDTO(Seccion seccion) {
        if ( seccion == null ) {
            return null;
        }

        SeccionDTO seccionDTO = new SeccionDTO();

        seccionDTO.setEstadoId( seccionEstadoId( seccion ) );
        seccionDTO.setEspacioId( seccionEspacioId( seccion ) );
        seccionDTO.setId( seccion.getId() );
        seccionDTO.setNombre( seccion.getNombre() );
        seccionDTO.setDescripcion( seccion.getDescripcion() );

        return seccionDTO;
    }

    @Override
    public List<SeccionDTO> toListDTO(List<Seccion> secciones) {
        if ( secciones == null ) {
            return null;
        }

        List<SeccionDTO> list = new ArrayList<SeccionDTO>( secciones.size() );
        for ( Seccion seccion : secciones ) {
            list.add( toListDTO( seccion ) );
        }

        return list;
    }

    private Long seccionEstadoId(Seccion seccion) {
        Estado estado = seccion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long seccionEmpresaId(Seccion seccion) {
        Empresa empresa = seccion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long seccionEspacioId(Seccion seccion) {
        Espacio espacio = seccion.getEspacio();
        if ( espacio == null ) {
            return null;
        }
        return espacio.getId();
    }

    protected Estado seccionDTOToEstado(SeccionDTO seccionDTO) {
        if ( seccionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( seccionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa seccionDTOToEmpresa(SeccionDTO seccionDTO) {
        if ( seccionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( seccionDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Espacio seccionDTOToEspacio(SeccionDTO seccionDTO) {
        if ( seccionDTO == null ) {
            return null;
        }

        Espacio.EspacioBuilder espacio = Espacio.builder();

        espacio.id( seccionDTO.getEspacioId() );

        return espacio.build();
    }
}
