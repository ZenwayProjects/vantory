package com.vantory.user.mappers;

import com.vantory.persona.Persona;
import com.vantory.user.User;
import com.vantory.user.dtos.UserDTO;
import com.vantory.user.dtos.UserMinimalDTO;
import com.vantory.usuarioEstado.UsuarioEstado;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:57-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long personaId = null;
        Long usuarioEstadoId = null;
        Long id = null;
        String password = null;
        String username = null;

        personaId = userPersonaId( user );
        usuarioEstadoId = userUsuarioEstadoId( user );
        id = user.getId();
        password = user.getPassword();
        username = user.getUsername();

        UserDTO userDTO = new UserDTO( id, password, username, personaId, usuarioEstadoId );

        return userDTO;
    }

    @Override
    public UserMinimalDTO toMinimalDTO(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String username = null;

        id = user.getId();
        username = user.getUsername();

        UserMinimalDTO userMinimalDTO = new UserMinimalDTO( id, username );

        return userMinimalDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.persona( userDTOToPersona( userDTO ) );
        user.usuarioEstado( userDTOToUsuarioEstado( userDTO ) );
        user.id( userDTO.getId() );
        user.username( userDTO.getUsername() );
        user.password( userDTO.getPassword() );

        return user.build();
    }

    private Long userPersonaId(User user) {
        Persona persona = user.getPersona();
        if ( persona == null ) {
            return null;
        }
        return persona.getId();
    }

    private Long userUsuarioEstadoId(User user) {
        UsuarioEstado usuarioEstado = user.getUsuarioEstado();
        if ( usuarioEstado == null ) {
            return null;
        }
        return usuarioEstado.getId();
    }

    protected Persona userDTOToPersona(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        Persona.PersonaBuilder persona = Persona.builder();

        persona.id( userDTO.getPersonaId() );

        return persona.build();
    }

    protected UsuarioEstado userDTOToUsuarioEstado(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        UsuarioEstado.UsuarioEstadoBuilder usuarioEstado = UsuarioEstado.builder();

        usuarioEstado.id( userDTO.getUsuarioEstadoId() );

        return usuarioEstado.build();
    }
}
