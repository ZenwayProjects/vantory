package com.vantory.persona.mappers;

import com.vantory.estado.Estado;
import com.vantory.persona.Persona;
import com.vantory.persona.dtos.PersonaDTO;
import com.vantory.tipoIdentificacion.TipoIdentificacion;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public PersonaDTO toDto(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        Integer tipoIdentificacion = null;
        Long estado = null;
        Long id = null;
        String identificacion = null;
        String nombre = null;
        String apellido = null;
        String genero = null;
        LocalDate fechaNacimiento = null;
        Long estrato = null;
        String direccion = null;
        String email = null;
        String celular = null;

        Long id1 = personaTipoIdentificacionId( persona );
        if ( id1 != null ) {
            tipoIdentificacion = id1.intValue();
        }
        estado = personaEstadoId( persona );
        id = persona.getId();
        identificacion = persona.getIdentificacion();
        nombre = persona.getNombre();
        apellido = persona.getApellido();
        genero = persona.getGenero();
        fechaNacimiento = persona.getFechaNacimiento();
        if ( persona.getEstrato() != null ) {
            estrato = persona.getEstrato().longValue();
        }
        direccion = persona.getDireccion();
        email = persona.getEmail();
        celular = persona.getCelular();

        PersonaDTO personaDTO = new PersonaDTO( id, tipoIdentificacion, identificacion, nombre, apellido, genero, fechaNacimiento, estrato, direccion, email, celular, estado );

        return personaDTO;
    }

    @Override
    public Persona toEntity(PersonaDTO personaDTO) {
        if ( personaDTO == null ) {
            return null;
        }

        Persona.PersonaBuilder persona = Persona.builder();

        persona.tipoIdentificacion( personaDTOToTipoIdentificacion( personaDTO ) );
        persona.estado( personaDTOToEstado( personaDTO ) );
        persona.id( personaDTO.getId() );
        persona.identificacion( personaDTO.getIdentificacion() );
        persona.nombre( personaDTO.getNombre() );
        persona.apellido( personaDTO.getApellido() );
        persona.genero( personaDTO.getGenero() );
        persona.fechaNacimiento( personaDTO.getFechaNacimiento() );
        if ( personaDTO.getEstrato() != null ) {
            persona.estrato( personaDTO.getEstrato().intValue() );
        }
        persona.direccion( personaDTO.getDireccion() );
        persona.email( personaDTO.getEmail() );
        persona.celular( personaDTO.getCelular() );

        return persona.build();
    }

    private Long personaTipoIdentificacionId(Persona persona) {
        TipoIdentificacion tipoIdentificacion = persona.getTipoIdentificacion();
        if ( tipoIdentificacion == null ) {
            return null;
        }
        return tipoIdentificacion.getId();
    }

    private Long personaEstadoId(Persona persona) {
        Estado estado = persona.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected TipoIdentificacion personaDTOToTipoIdentificacion(PersonaDTO personaDTO) {
        if ( personaDTO == null ) {
            return null;
        }

        TipoIdentificacion.TipoIdentificacionBuilder tipoIdentificacion = TipoIdentificacion.builder();

        if ( personaDTO.getTipoIdentificacion() != null ) {
            tipoIdentificacion.id( personaDTO.getTipoIdentificacion().longValue() );
        }

        return tipoIdentificacion.build();
    }

    protected Estado personaDTOToEstado(PersonaDTO personaDTO) {
        if ( personaDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( personaDTO.getEstado() );

        return estado.build();
    }
}
