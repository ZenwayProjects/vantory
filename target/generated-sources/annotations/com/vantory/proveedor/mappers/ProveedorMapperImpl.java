package com.vantory.proveedor.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.proveedor.Proveedor;
import com.vantory.proveedor.dtos.ProveedorDTO;
import com.vantory.tipoIdentificacion.TipoIdentificacion;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProveedorMapperImpl implements ProveedorMapper {

    @Override
    public ProveedorDTO toDto(Proveedor entity) {
        if ( entity == null ) {
            return null;
        }

        Long estadoId = null;
        Long tipoIdentificacionId = null;
        Long id = null;
        LocalDateTime fechaCreacion = null;
        String nombre = null;
        String celular = null;
        String contacto = null;
        String correo = null;
        String identificacion = null;

        estadoId = entityEstadoId( entity );
        tipoIdentificacionId = entityTipoIdentificacionId( entity );
        id = entity.getId();
        fechaCreacion = entity.getFechaCreacion();
        nombre = entity.getNombre();
        celular = entity.getCelular();
        contacto = entity.getContacto();
        correo = entity.getCorreo();
        identificacion = entity.getIdentificacion();

        Long empresaId = null;

        ProveedorDTO proveedorDTO = new ProveedorDTO( id, empresaId, fechaCreacion, estadoId, tipoIdentificacionId, nombre, celular, contacto, correo, identificacion );

        return proveedorDTO;
    }

    @Override
    public Proveedor toEntity(ProveedorDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Proveedor.ProveedorBuilder proveedor = Proveedor.builder();

        proveedor.empresa( proveedorDTOToEmpresa( dto ) );
        proveedor.estado( proveedorDTOToEstado( dto ) );
        proveedor.tipoIdentificacion( proveedorDTOToTipoIdentificacion( dto ) );
        proveedor.id( dto.getId() );
        proveedor.fechaCreacion( dto.getFechaCreacion() );
        proveedor.nombre( dto.getNombre() );
        proveedor.celular( dto.getCelular() );
        proveedor.contacto( dto.getContacto() );
        proveedor.correo( dto.getCorreo() );
        proveedor.identificacion( dto.getIdentificacion() );

        return proveedor.build();
    }

    private Long entityEstadoId(Proveedor proveedor) {
        Estado estado = proveedor.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long entityTipoIdentificacionId(Proveedor proveedor) {
        TipoIdentificacion tipoIdentificacion = proveedor.getTipoIdentificacion();
        if ( tipoIdentificacion == null ) {
            return null;
        }
        return tipoIdentificacion.getId();
    }

    protected Empresa proveedorDTOToEmpresa(ProveedorDTO proveedorDTO) {
        if ( proveedorDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( proveedorDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Estado proveedorDTOToEstado(ProveedorDTO proveedorDTO) {
        if ( proveedorDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( proveedorDTO.getEstadoId() );

        return estado.build();
    }

    protected TipoIdentificacion proveedorDTOToTipoIdentificacion(ProveedorDTO proveedorDTO) {
        if ( proveedorDTO == null ) {
            return null;
        }

        TipoIdentificacion.TipoIdentificacionBuilder tipoIdentificacion = TipoIdentificacion.builder();

        tipoIdentificacion.id( proveedorDTO.getTipoIdentificacionId() );

        return tipoIdentificacion.build();
    }
}
