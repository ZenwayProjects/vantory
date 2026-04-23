package com.vantory.subseccion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.seccion.Seccion;
import com.vantory.subseccion.Subseccion;
import com.vantory.subseccion.dtos.SubseccionDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SubseccionMapperImpl implements SubseccionMapper {

    @Override
    public SubseccionDTO toDTO(Subseccion subseccion) {
        if ( subseccion == null ) {
            return null;
        }

        Long estadoId = null;
        Long empresaId = null;
        Long seccionId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = subseccionEstadoId( subseccion );
        empresaId = subseccionEmpresaId( subseccion );
        seccionId = subseccionSeccionId( subseccion );
        id = subseccion.getId();
        nombre = subseccion.getNombre();
        descripcion = subseccion.getDescripcion();

        SubseccionDTO subseccionDTO = new SubseccionDTO( id, nombre, descripcion, estadoId, empresaId, seccionId );

        return subseccionDTO;
    }

    @Override
    public Subseccion toEntity(SubseccionDTO subseccionDTO) {
        if ( subseccionDTO == null ) {
            return null;
        }

        Subseccion.SubseccionBuilder subseccion = Subseccion.builder();

        subseccion.estado( subseccionDTOToEstado( subseccionDTO ) );
        subseccion.empresa( subseccionDTOToEmpresa( subseccionDTO ) );
        subseccion.seccion( subseccionDTOToSeccion( subseccionDTO ) );
        subseccion.id( subseccionDTO.getId() );
        subseccion.nombre( subseccionDTO.getNombre() );
        subseccion.descripcion( subseccionDTO.getDescripcion() );

        return subseccion.build();
    }

    private Long subseccionEstadoId(Subseccion subseccion) {
        Estado estado = subseccion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long subseccionEmpresaId(Subseccion subseccion) {
        Empresa empresa = subseccion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long subseccionSeccionId(Subseccion subseccion) {
        Seccion seccion = subseccion.getSeccion();
        if ( seccion == null ) {
            return null;
        }
        return seccion.getId();
    }

    protected Estado subseccionDTOToEstado(SubseccionDTO subseccionDTO) {
        if ( subseccionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( subseccionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa subseccionDTOToEmpresa(SubseccionDTO subseccionDTO) {
        if ( subseccionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( subseccionDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Seccion subseccionDTOToSeccion(SubseccionDTO subseccionDTO) {
        if ( subseccionDTO == null ) {
            return null;
        }

        Seccion seccion = new Seccion();

        seccion.setId( subseccionDTO.getSeccionId() );

        return seccion;
    }
}
