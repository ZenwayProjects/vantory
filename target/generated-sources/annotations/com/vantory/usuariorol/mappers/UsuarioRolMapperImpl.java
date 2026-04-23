package com.vantory.usuariorol.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.rol.Rol;
import com.vantory.user.User;
import com.vantory.usuariorol.UsuarioRol;
import com.vantory.usuariorol.dtos.UsuarioRolRequestDTO;
import com.vantory.usuariorol.dtos.UsuarioRolRequestForCurrentEmpresaDTO;
import com.vantory.usuariorol.dtos.UsuarioRolResponseDTO;
import com.vantory.usuariorol.dtos.UsuarioRolResponseForCurrentEmpresaDTO;
import java.time.OffsetDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UsuarioRolMapperImpl implements UsuarioRolMapper {

    @Override
    public UsuarioRolResponseDTO toResponse(UsuarioRol entity) {
        if ( entity == null ) {
            return null;
        }

        Long usuarioId = null;
        String usuarioEmail = null;
        Long empresaId = null;
        String empresaNombre = null;
        Long rolId = null;
        String rolNombre = null;
        Long estadoId = null;
        String estadoNombre = null;
        String createdBy = null;
        String updatedBy = null;
        Long id = null;
        OffsetDateTime iniciaContratoEn = null;
        OffsetDateTime finalizaContratoEn = null;
        OffsetDateTime createdAt = null;
        OffsetDateTime updatedAt = null;

        usuarioId = entityUserId( entity );
        usuarioEmail = entityUserUsername( entity );
        empresaId = entityEmpresaId( entity );
        empresaNombre = entityEmpresaNombre( entity );
        rolId = entityRolId( entity );
        rolNombre = entityRolNombre( entity );
        estadoId = entityEstadoId( entity );
        estadoNombre = entityEstadoNombre( entity );
        createdBy = entityCreatedByUsername( entity );
        updatedBy = entityUpdatedByUsername( entity );
        id = entity.getId();
        iniciaContratoEn = entity.getIniciaContratoEn();
        finalizaContratoEn = entity.getFinalizaContratoEn();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();

        String personaNombreCompleto = buildPersonaNombreCompleto(entity);

        UsuarioRolResponseDTO usuarioRolResponseDTO = new UsuarioRolResponseDTO( id, usuarioId, usuarioEmail, personaNombreCompleto, empresaId, empresaNombre, rolId, rolNombre, estadoId, estadoNombre, iniciaContratoEn, finalizaContratoEn, createdAt, createdBy, updatedAt, updatedBy );

        return usuarioRolResponseDTO;
    }

    @Override
    public UsuarioRolResponseForCurrentEmpresaDTO toResponseForCurrentEmpresa(UsuarioRol entity) {
        if ( entity == null ) {
            return null;
        }

        Long usuarioId = null;
        String usuarioEmail = null;
        Long rolId = null;
        String rolNombre = null;
        Long estadoId = null;
        String estadoNombre = null;
        String createdBy = null;
        String updatedBy = null;
        Long id = null;
        OffsetDateTime iniciaContratoEn = null;
        OffsetDateTime finalizaContratoEn = null;
        OffsetDateTime createdAt = null;
        OffsetDateTime updatedAt = null;

        usuarioId = entityUserId( entity );
        usuarioEmail = entityUserUsername( entity );
        rolId = entityRolId( entity );
        rolNombre = entityRolNombre( entity );
        estadoId = entityEstadoId( entity );
        estadoNombre = entityEstadoNombre( entity );
        createdBy = entityCreatedByUsername( entity );
        updatedBy = entityUpdatedByUsername( entity );
        id = entity.getId();
        iniciaContratoEn = entity.getIniciaContratoEn();
        finalizaContratoEn = entity.getFinalizaContratoEn();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();

        String personaNombreCompleto = buildPersonaNombreCompleto(entity);

        UsuarioRolResponseForCurrentEmpresaDTO usuarioRolResponseForCurrentEmpresaDTO = new UsuarioRolResponseForCurrentEmpresaDTO( id, usuarioId, usuarioEmail, personaNombreCompleto, rolId, rolNombre, estadoId, estadoNombre, iniciaContratoEn, finalizaContratoEn, createdAt, createdBy, updatedAt, updatedBy );

        return usuarioRolResponseForCurrentEmpresaDTO;
    }

    @Override
    public UsuarioRol toEntity(UsuarioRolRequestDTO request) {
        if ( request == null ) {
            return null;
        }

        UsuarioRol.UsuarioRolBuilder usuarioRol = UsuarioRol.builder();

        usuarioRol.iniciaContratoEn( request.iniciaContratoEn() );
        usuarioRol.finalizaContratoEn( request.finalizaContratoEn() );

        return usuarioRol.build();
    }

    @Override
    public UsuarioRol toEntity(UsuarioRolRequestForCurrentEmpresaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        UsuarioRol.UsuarioRolBuilder usuarioRol = UsuarioRol.builder();

        usuarioRol.iniciaContratoEn( dto.iniciaContratoEn() );
        usuarioRol.finalizaContratoEn( dto.finalizaContratoEn() );

        return usuarioRol.build();
    }

    @Override
    public void updateEntityFromRequest(UsuarioRolRequestDTO request, UsuarioRol entity) {
        if ( request == null ) {
            return;
        }

        entity.setIniciaContratoEn( request.iniciaContratoEn() );
        entity.setFinalizaContratoEn( request.finalizaContratoEn() );
    }

    @Override
    public void updateEntityFromDTO(UsuarioRolRequestForCurrentEmpresaDTO dto, UsuarioRol entity) {
        if ( dto == null ) {
            return;
        }

        if ( dto.iniciaContratoEn() != null ) {
            entity.setIniciaContratoEn( dto.iniciaContratoEn() );
        }
        if ( dto.finalizaContratoEn() != null ) {
            entity.setFinalizaContratoEn( dto.finalizaContratoEn() );
        }
    }

    private Long entityUserId(UsuarioRol usuarioRol) {
        User user = usuarioRol.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getId();
    }

    private String entityUserUsername(UsuarioRol usuarioRol) {
        User user = usuarioRol.getUser();
        if ( user == null ) {
            return null;
        }
        return user.getUsername();
    }

    private Long entityEmpresaId(UsuarioRol usuarioRol) {
        Empresa empresa = usuarioRol.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private String entityEmpresaNombre(UsuarioRol usuarioRol) {
        Empresa empresa = usuarioRol.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getNombre();
    }

    private Long entityRolId(UsuarioRol usuarioRol) {
        Rol rol = usuarioRol.getRol();
        if ( rol == null ) {
            return null;
        }
        return rol.getId();
    }

    private String entityRolNombre(UsuarioRol usuarioRol) {
        Rol rol = usuarioRol.getRol();
        if ( rol == null ) {
            return null;
        }
        return rol.getNombre();
    }

    private Long entityEstadoId(UsuarioRol usuarioRol) {
        Estado estado = usuarioRol.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private String entityEstadoNombre(UsuarioRol usuarioRol) {
        Estado estado = usuarioRol.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getNombre();
    }

    private String entityCreatedByUsername(UsuarioRol usuarioRol) {
        User createdBy = usuarioRol.getCreatedBy();
        if ( createdBy == null ) {
            return null;
        }
        return createdBy.getUsername();
    }

    private String entityUpdatedByUsername(UsuarioRol usuarioRol) {
        User updatedBy = usuarioRol.getUpdatedBy();
        if ( updatedBy == null ) {
            return null;
        }
        return updatedBy.getUsername();
    }
}
