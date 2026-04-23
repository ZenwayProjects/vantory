package com.vantory.rol.mappers;

import com.vantory.estado.Estado;
import com.vantory.rol.Rol;
import com.vantory.rol.dtos.RolRequestDTO;
import com.vantory.rol.dtos.RolResponseDTO;
import com.vantory.user.User;
import java.time.OffsetDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class RolMapperImpl implements RolMapper {

    @Override
    public Rol toEntity(RolRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Rol.RolBuilder rol = Rol.builder();

        rol.estado( rolRequestDTOToEstado( dto ) );
        rol.nombre( dto.nombre() );
        rol.descripcion( dto.descripcion() );

        return rol.build();
    }

    @Override
    public RolResponseDTO toDTO(Rol rol) {
        if ( rol == null ) {
            return null;
        }

        Long estadoId = null;
        String estadoNombre = null;
        String createdBy = null;
        String updatedBy = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        OffsetDateTime createdAt = null;
        OffsetDateTime updatedAt = null;

        estadoId = rolEstadoId( rol );
        estadoNombre = rolEstadoNombre( rol );
        createdBy = rolCreatedByUsername( rol );
        updatedBy = rolUpdatedByUsername( rol );
        id = rol.getId();
        nombre = rol.getNombre();
        descripcion = rol.getDescripcion();
        createdAt = rol.getCreatedAt();
        updatedAt = rol.getUpdatedAt();

        RolResponseDTO rolResponseDTO = new RolResponseDTO( id, nombre, descripcion, estadoId, estadoNombre, createdBy, createdAt, updatedBy, updatedAt );

        return rolResponseDTO;
    }

    protected Estado rolRequestDTOToEstado(RolRequestDTO rolRequestDTO) {
        if ( rolRequestDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( rolRequestDTO.estadoId() );

        return estado.build();
    }

    private Long rolEstadoId(Rol rol) {
        Estado estado = rol.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private String rolEstadoNombre(Rol rol) {
        Estado estado = rol.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getNombre();
    }

    private String rolCreatedByUsername(Rol rol) {
        User createdBy = rol.getCreatedBy();
        if ( createdBy == null ) {
            return null;
        }
        return createdBy.getUsername();
    }

    private String rolUpdatedByUsername(Rol rol) {
        User updatedBy = rol.getUpdatedBy();
        if ( updatedBy == null ) {
            return null;
        }
        return updatedBy.getUsername();
    }
}
