package com.vantory.inventario.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.inventario.Inventario;
import com.vantory.inventario.dtos.InventarioDTO;
import com.vantory.subseccion.Subseccion;
import com.vantory.tipoInventario.TipoInventario;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class InventarioMapperImpl implements InventarioMapper {

    @Override
    public InventarioDTO toDTO(Inventario inventario) {
        if ( inventario == null ) {
            return null;
        }

        Long estadoId = null;
        Long tipoInventarioId = null;
        Long subseccionId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        LocalDateTime fechaHora = null;

        estadoId = inventarioEstadoId( inventario );
        tipoInventarioId = inventarioTipoInventarioId( inventario );
        subseccionId = inventarioSubseccionId( inventario );
        id = inventario.getId();
        nombre = inventario.getNombre();
        descripcion = inventario.getDescripcion();
        fechaHora = inventario.getFechaHora();

        Long empresaId = null;

        InventarioDTO inventarioDTO = new InventarioDTO( id, nombre, descripcion, fechaHora, tipoInventarioId, empresaId, subseccionId, estadoId );

        return inventarioDTO;
    }

    @Override
    public Inventario toEntity(InventarioDTO inventarioDTO) {
        if ( inventarioDTO == null ) {
            return null;
        }

        Inventario.InventarioBuilder inventario = Inventario.builder();

        inventario.estado( inventarioDTOToEstado( inventarioDTO ) );
        inventario.empresa( inventarioDTOToEmpresa( inventarioDTO ) );
        inventario.tipoInventario( inventarioDTOToTipoInventario( inventarioDTO ) );
        inventario.subseccion( inventarioDTOToSubseccion( inventarioDTO ) );
        inventario.id( inventarioDTO.getId() );
        inventario.nombre( inventarioDTO.getNombre() );
        inventario.descripcion( inventarioDTO.getDescripcion() );
        inventario.fechaHora( inventarioDTO.getFechaHora() );

        return inventario.build();
    }

    private Long inventarioEstadoId(Inventario inventario) {
        Estado estado = inventario.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long inventarioTipoInventarioId(Inventario inventario) {
        TipoInventario tipoInventario = inventario.getTipoInventario();
        if ( tipoInventario == null ) {
            return null;
        }
        return tipoInventario.getId();
    }

    private Long inventarioSubseccionId(Inventario inventario) {
        Subseccion subseccion = inventario.getSubseccion();
        if ( subseccion == null ) {
            return null;
        }
        return subseccion.getId();
    }

    protected Estado inventarioDTOToEstado(InventarioDTO inventarioDTO) {
        if ( inventarioDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( inventarioDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa inventarioDTOToEmpresa(InventarioDTO inventarioDTO) {
        if ( inventarioDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( inventarioDTO.getEmpresaId() );

        return empresa.build();
    }

    protected TipoInventario inventarioDTOToTipoInventario(InventarioDTO inventarioDTO) {
        if ( inventarioDTO == null ) {
            return null;
        }

        TipoInventario.TipoInventarioBuilder tipoInventario = TipoInventario.builder();

        tipoInventario.id( inventarioDTO.getTipoInventarioId() );

        return tipoInventario.build();
    }

    protected Subseccion inventarioDTOToSubseccion(InventarioDTO inventarioDTO) {
        if ( inventarioDTO == null ) {
            return null;
        }

        Subseccion.SubseccionBuilder subseccion = Subseccion.builder();

        subseccion.id( inventarioDTO.getSubseccionId() );

        return subseccion.build();
    }
}
