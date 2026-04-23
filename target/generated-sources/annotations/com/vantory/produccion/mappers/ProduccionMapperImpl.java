package com.vantory.produccion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.espacio.Espacio;
import com.vantory.estado.Estado;
import com.vantory.produccion.Produccion;
import com.vantory.produccion.dtos.ProduccionCreateDTO;
import com.vantory.produccion.dtos.ProduccionDTO;
import com.vantory.subseccion.Subseccion;
import com.vantory.tipoProduccion.TipoProduccion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProduccionMapperImpl implements ProduccionMapper {

    @Override
    public ProduccionDTO toDto(Produccion produccion) {
        if ( produccion == null ) {
            return null;
        }

        ProduccionDTO.ProduccionDTOBuilder produccionDTO = ProduccionDTO.builder();

        produccionDTO.tipoProduccionId( produccionTipoProduccionId( produccion ) );
        produccionDTO.espacioId( produccionEspacioId( produccion ) );
        produccionDTO.estadoId( produccionEstadoId( produccion ) );
        produccionDTO.subSeccionId( produccionSubSeccionId( produccion ) );
        produccionDTO.id( produccion.getId() );
        produccionDTO.nombre( produccion.getNombre() );
        produccionDTO.descripcion( produccion.getDescripcion() );
        produccionDTO.fechaInicio( produccion.getFechaInicio() );
        produccionDTO.fechaFinal( produccion.getFechaFinal() );

        return produccionDTO.build();
    }

    @Override
    public Produccion toEntity(ProduccionDTO produccionDTO) {
        if ( produccionDTO == null ) {
            return null;
        }

        Produccion.ProduccionBuilder produccion = Produccion.builder();

        produccion.tipoProduccion( produccionDTOToTipoProduccion( produccionDTO ) );
        produccion.espacio( produccionDTOToEspacio( produccionDTO ) );
        produccion.estado( produccionDTOToEstado( produccionDTO ) );
        produccion.subSeccion( produccionDTOToSubseccion( produccionDTO ) );
        produccion.empresa( produccionDTOToEmpresa( produccionDTO ) );
        produccion.id( produccionDTO.getId() );
        produccion.nombre( produccionDTO.getNombre() );
        produccion.descripcion( produccionDTO.getDescripcion() );
        produccion.fechaInicio( produccionDTO.getFechaInicio() );
        produccion.fechaFinal( produccionDTO.getFechaFinal() );

        return produccion.build();
    }

    @Override
    public Produccion toEntity(ProduccionCreateDTO produccionDTO) {
        if ( produccionDTO == null ) {
            return null;
        }

        Produccion.ProduccionBuilder produccion = Produccion.builder();

        produccion.tipoProduccion( produccionCreateDTOToTipoProduccion( produccionDTO ) );
        produccion.espacio( produccionCreateDTOToEspacio( produccionDTO ) );
        produccion.estado( produccionCreateDTOToEstado( produccionDTO ) );
        produccion.subSeccion( produccionCreateDTOToSubseccion( produccionDTO ) );
        produccion.nombre( produccionDTO.getNombre() );
        produccion.descripcion( produccionDTO.getDescripcion() );
        produccion.fechaInicio( produccionDTO.getFechaInicio() );
        produccion.fechaFinal( produccionDTO.getFechaFinal() );

        return produccion.build();
    }

    @Override
    public void updateEntityFromDto(ProduccionDTO dto, Produccion produccion) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            produccion.setId( dto.getId() );
        }
        if ( dto.getNombre() != null ) {
            produccion.setNombre( dto.getNombre() );
        }
        if ( dto.getDescripcion() != null ) {
            produccion.setDescripcion( dto.getDescripcion() );
        }
        if ( dto.getFechaInicio() != null ) {
            produccion.setFechaInicio( dto.getFechaInicio() );
        }
        if ( dto.getFechaFinal() != null ) {
            produccion.setFechaFinal( dto.getFechaFinal() );
        }
    }

    private Long produccionTipoProduccionId(Produccion produccion) {
        TipoProduccion tipoProduccion = produccion.getTipoProduccion();
        if ( tipoProduccion == null ) {
            return null;
        }
        return tipoProduccion.getId();
    }

    private Long produccionEspacioId(Produccion produccion) {
        Espacio espacio = produccion.getEspacio();
        if ( espacio == null ) {
            return null;
        }
        return espacio.getId();
    }

    private Long produccionEstadoId(Produccion produccion) {
        Estado estado = produccion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long produccionSubSeccionId(Produccion produccion) {
        Subseccion subSeccion = produccion.getSubSeccion();
        if ( subSeccion == null ) {
            return null;
        }
        return subSeccion.getId();
    }

    protected TipoProduccion produccionDTOToTipoProduccion(ProduccionDTO produccionDTO) {
        if ( produccionDTO == null ) {
            return null;
        }

        TipoProduccion.TipoProduccionBuilder tipoProduccion = TipoProduccion.builder();

        tipoProduccion.id( produccionDTO.getTipoProduccionId() );

        return tipoProduccion.build();
    }

    protected Espacio produccionDTOToEspacio(ProduccionDTO produccionDTO) {
        if ( produccionDTO == null ) {
            return null;
        }

        Espacio.EspacioBuilder espacio = Espacio.builder();

        espacio.id( produccionDTO.getEspacioId() );

        return espacio.build();
    }

    protected Estado produccionDTOToEstado(ProduccionDTO produccionDTO) {
        if ( produccionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( produccionDTO.getEstadoId() );

        return estado.build();
    }

    protected Subseccion produccionDTOToSubseccion(ProduccionDTO produccionDTO) {
        if ( produccionDTO == null ) {
            return null;
        }

        Subseccion.SubseccionBuilder subseccion = Subseccion.builder();

        subseccion.id( produccionDTO.getSubSeccionId() );

        return subseccion.build();
    }

    protected Empresa produccionDTOToEmpresa(ProduccionDTO produccionDTO) {
        if ( produccionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( produccionDTO.getEmpresaId() );

        return empresa.build();
    }

    protected TipoProduccion produccionCreateDTOToTipoProduccion(ProduccionCreateDTO produccionCreateDTO) {
        if ( produccionCreateDTO == null ) {
            return null;
        }

        TipoProduccion.TipoProduccionBuilder tipoProduccion = TipoProduccion.builder();

        tipoProduccion.id( produccionCreateDTO.getTipoProduccionId() );

        return tipoProduccion.build();
    }

    protected Espacio produccionCreateDTOToEspacio(ProduccionCreateDTO produccionCreateDTO) {
        if ( produccionCreateDTO == null ) {
            return null;
        }

        Espacio.EspacioBuilder espacio = Espacio.builder();

        espacio.id( produccionCreateDTO.getEspacioId() );

        return espacio.build();
    }

    protected Estado produccionCreateDTOToEstado(ProduccionCreateDTO produccionCreateDTO) {
        if ( produccionCreateDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( produccionCreateDTO.getEstadoId() );

        return estado.build();
    }

    protected Subseccion produccionCreateDTOToSubseccion(ProduccionCreateDTO produccionCreateDTO) {
        if ( produccionCreateDTO == null ) {
            return null;
        }

        Subseccion.SubseccionBuilder subseccion = Subseccion.builder();

        subseccion.id( produccionCreateDTO.getSubSeccionId() );

        return subseccion.build();
    }
}
