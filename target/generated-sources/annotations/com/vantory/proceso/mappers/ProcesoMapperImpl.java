package com.vantory.proceso.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.proceso.Proceso;
import com.vantory.proceso.dtos.ProcesoDTO;
import com.vantory.tipoProduccion.TipoProduccion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProcesoMapperImpl implements ProcesoMapper {

    @Override
    public ProcesoDTO toDTO(Proceso proceso) {
        if ( proceso == null ) {
            return null;
        }

        Long tipoProduccionId = null;
        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        tipoProduccionId = procesoTipoProduccionId( proceso );
        estadoId = procesoEstadoId( proceso );
        empresaId = procesoEmpresaId( proceso );
        id = proceso.getId();
        nombre = proceso.getNombre();
        descripcion = proceso.getDescripcion();

        ProcesoDTO procesoDTO = new ProcesoDTO( id, nombre, descripcion, tipoProduccionId, estadoId, empresaId );

        return procesoDTO;
    }

    @Override
    public Proceso toEntity(ProcesoDTO procesoDTO) {
        if ( procesoDTO == null ) {
            return null;
        }

        Proceso.ProcesoBuilder proceso = Proceso.builder();

        proceso.tipoProduccion( procesoDTOToTipoProduccion( procesoDTO ) );
        proceso.estado( procesoDTOToEstado( procesoDTO ) );
        proceso.empresa( procesoDTOToEmpresa( procesoDTO ) );
        proceso.id( procesoDTO.getId() );
        proceso.nombre( procesoDTO.getNombre() );
        proceso.descripcion( procesoDTO.getDescripcion() );

        return proceso.build();
    }

    @Override
    public ProcesoDTO toListDTO(Proceso proceso) {
        if ( proceso == null ) {
            return null;
        }

        Long tipoProduccionId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        tipoProduccionId = procesoTipoProduccionId( proceso );
        estadoId = procesoEstadoId( proceso );
        id = proceso.getId();
        nombre = proceso.getNombre();
        descripcion = proceso.getDescripcion();

        Long empresaId = null;

        ProcesoDTO procesoDTO = new ProcesoDTO( id, nombre, descripcion, tipoProduccionId, estadoId, empresaId );

        return procesoDTO;
    }

    private Long procesoTipoProduccionId(Proceso proceso) {
        TipoProduccion tipoProduccion = proceso.getTipoProduccion();
        if ( tipoProduccion == null ) {
            return null;
        }
        return tipoProduccion.getId();
    }

    private Long procesoEstadoId(Proceso proceso) {
        Estado estado = proceso.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long procesoEmpresaId(Proceso proceso) {
        Empresa empresa = proceso.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected TipoProduccion procesoDTOToTipoProduccion(ProcesoDTO procesoDTO) {
        if ( procesoDTO == null ) {
            return null;
        }

        TipoProduccion.TipoProduccionBuilder tipoProduccion = TipoProduccion.builder();

        tipoProduccion.id( procesoDTO.getTipoProduccionId() );

        return tipoProduccion.build();
    }

    protected Estado procesoDTOToEstado(ProcesoDTO procesoDTO) {
        if ( procesoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( procesoDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa procesoDTOToEmpresa(ProcesoDTO procesoDTO) {
        if ( procesoDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( procesoDTO.getEmpresaId() );

        return empresa.build();
    }
}
