package com.vantory.empresa.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.empresa.dtos.EmpresaDTO;
import com.vantory.estado.Estado;
import com.vantory.persona.Persona;
import com.vantory.tipoIdentificacion.TipoIdentificacion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EmpresaMapperImpl implements EmpresaMapper {

    @Override
    public EmpresaDTO toEmpresaDTO(Empresa empresa) {
        if ( empresa == null ) {
            return null;
        }

        EmpresaDTO.EmpresaDTOBuilder empresaDTO = EmpresaDTO.builder();

        empresaDTO.tipoIdentificacionId( empresaTipoIdentificacionId( empresa ) );
        empresaDTO.personaId( empresaPersonaId( empresa ) );
        empresaDTO.estadoId( empresaEstadoId( empresa ) );
        empresaDTO.id( empresa.getId() );
        empresaDTO.nombre( empresa.getNombre() );
        empresaDTO.descripcion( empresa.getDescripcion() );
        empresaDTO.celular( empresa.getCelular() );
        empresaDTO.correo( empresa.getCorreo() );
        empresaDTO.contacto( empresa.getContacto() );
        empresaDTO.identificacion( empresa.getIdentificacion() );
        empresaDTO.logo( empresa.getLogo() );
        empresaDTO.logoHash( empresa.getLogoHash() );

        return empresaDTO.build();
    }

    @Override
    public Empresa toEmpresa(EmpresaDTO empresaDTO) {
        if ( empresaDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.tipoIdentificacion( empresaDTOToTipoIdentificacion( empresaDTO ) );
        empresa.persona( empresaDTOToPersona( empresaDTO ) );
        empresa.estado( empresaDTOToEstado( empresaDTO ) );
        empresa.id( empresaDTO.getId() );
        empresa.identificacion( empresaDTO.getIdentificacion() );
        empresa.nombre( empresaDTO.getNombre() );
        empresa.descripcion( empresaDTO.getDescripcion() );
        empresa.celular( empresaDTO.getCelular() );
        empresa.correo( empresaDTO.getCorreo() );
        empresa.contacto( empresaDTO.getContacto() );
        empresa.logo( empresaDTO.getLogo() );
        empresa.logoHash( empresaDTO.getLogoHash() );

        return empresa.build();
    }

    private Long empresaTipoIdentificacionId(Empresa empresa) {
        TipoIdentificacion tipoIdentificacion = empresa.getTipoIdentificacion();
        if ( tipoIdentificacion == null ) {
            return null;
        }
        return tipoIdentificacion.getId();
    }

    private Long empresaPersonaId(Empresa empresa) {
        Persona persona = empresa.getPersona();
        if ( persona == null ) {
            return null;
        }
        return persona.getId();
    }

    private Long empresaEstadoId(Empresa empresa) {
        Estado estado = empresa.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected TipoIdentificacion empresaDTOToTipoIdentificacion(EmpresaDTO empresaDTO) {
        if ( empresaDTO == null ) {
            return null;
        }

        TipoIdentificacion.TipoIdentificacionBuilder tipoIdentificacion = TipoIdentificacion.builder();

        tipoIdentificacion.id( empresaDTO.getTipoIdentificacionId() );

        return tipoIdentificacion.build();
    }

    protected Persona empresaDTOToPersona(EmpresaDTO empresaDTO) {
        if ( empresaDTO == null ) {
            return null;
        }

        Persona.PersonaBuilder persona = Persona.builder();

        persona.id( empresaDTO.getPersonaId() );

        return persona.build();
    }

    protected Estado empresaDTOToEstado(EmpresaDTO empresaDTO) {
        if ( empresaDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( empresaDTO.getEstadoId() );

        return estado.build();
    }
}
