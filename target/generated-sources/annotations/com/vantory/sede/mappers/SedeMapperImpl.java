package com.vantory.sede.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.grupo.Grupo;
import com.vantory.municipio.Municipio;
import com.vantory.sede.Sede;
import com.vantory.sede.dtos.SedeDTO;
import com.vantory.tipoSede.TipoSede;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:59-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SedeMapperImpl implements SedeMapper {

    @Override
    public SedeDTO toDTO(Sede sede) {
        if ( sede == null ) {
            return null;
        }

        Long grupoId = null;
        Long tipoSedeId = null;
        Long empresaId = null;
        Long municipioId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String geolocalizacion = null;
        String coordenadas = null;
        Double area = null;
        String comuna = null;
        String descripcion = null;
        String direccion = null;

        grupoId = sedeGrupoId( sede );
        tipoSedeId = sedeTipoSedeId( sede );
        empresaId = sedeEmpresaId( sede );
        municipioId = sedeMunicipioId( sede );
        estadoId = sedeEstadoId( sede );
        id = sede.getId();
        nombre = sede.getNombre();
        geolocalizacion = sede.getGeolocalizacion();
        coordenadas = sede.getCoordenadas();
        area = sede.getArea();
        comuna = sede.getComuna();
        descripcion = sede.getDescripcion();
        direccion = sede.getDireccion();

        SedeDTO sedeDTO = new SedeDTO( id, grupoId, tipoSedeId, empresaId, nombre, municipioId, geolocalizacion, coordenadas, area, comuna, descripcion, direccion, estadoId );

        return sedeDTO;
    }

    @Override
    public Sede toEntity(SedeDTO sedeDTO) {
        if ( sedeDTO == null ) {
            return null;
        }

        Sede.SedeBuilder sede = Sede.builder();

        sede.grupo( sedeDTOToGrupo( sedeDTO ) );
        sede.tipoSede( sedeDTOToTipoSede( sedeDTO ) );
        sede.empresa( sedeDTOToEmpresa( sedeDTO ) );
        sede.municipio( sedeDTOToMunicipio( sedeDTO ) );
        sede.estado( sedeDTOToEstado( sedeDTO ) );
        sede.id( sedeDTO.getId() );
        sede.nombre( sedeDTO.getNombre() );
        sede.geolocalizacion( sedeDTO.getGeolocalizacion() );
        sede.coordenadas( sedeDTO.getCoordenadas() );
        sede.area( sedeDTO.getArea() );
        sede.comuna( sedeDTO.getComuna() );
        sede.descripcion( sedeDTO.getDescripcion() );
        sede.direccion( sedeDTO.getDireccion() );

        return sede.build();
    }

    @Override
    public SedeDTO toListDto(Sede sede) {
        if ( sede == null ) {
            return null;
        }

        Long grupoId = null;
        Long tipoSedeId = null;
        Long municipioId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String geolocalizacion = null;
        String coordenadas = null;
        Double area = null;
        String comuna = null;
        String descripcion = null;
        String direccion = null;

        grupoId = sedeGrupoId( sede );
        tipoSedeId = sedeTipoSedeId( sede );
        municipioId = sedeMunicipioId( sede );
        estadoId = sedeEstadoId( sede );
        id = sede.getId();
        nombre = sede.getNombre();
        geolocalizacion = sede.getGeolocalizacion();
        coordenadas = sede.getCoordenadas();
        area = sede.getArea();
        comuna = sede.getComuna();
        descripcion = sede.getDescripcion();
        direccion = sede.getDireccion();

        Long empresaId = null;

        SedeDTO sedeDTO = new SedeDTO( id, grupoId, tipoSedeId, empresaId, nombre, municipioId, geolocalizacion, coordenadas, area, comuna, descripcion, direccion, estadoId );

        return sedeDTO;
    }

    private Long sedeGrupoId(Sede sede) {
        Grupo grupo = sede.getGrupo();
        if ( grupo == null ) {
            return null;
        }
        return grupo.getId();
    }

    private Long sedeTipoSedeId(Sede sede) {
        TipoSede tipoSede = sede.getTipoSede();
        if ( tipoSede == null ) {
            return null;
        }
        return tipoSede.getId();
    }

    private Long sedeEmpresaId(Sede sede) {
        Empresa empresa = sede.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long sedeMunicipioId(Sede sede) {
        Municipio municipio = sede.getMunicipio();
        if ( municipio == null ) {
            return null;
        }
        return municipio.getId();
    }

    private Long sedeEstadoId(Sede sede) {
        Estado estado = sede.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Grupo sedeDTOToGrupo(SedeDTO sedeDTO) {
        if ( sedeDTO == null ) {
            return null;
        }

        Grupo.GrupoBuilder grupo = Grupo.builder();

        grupo.id( sedeDTO.getGrupoId() );

        return grupo.build();
    }

    protected TipoSede sedeDTOToTipoSede(SedeDTO sedeDTO) {
        if ( sedeDTO == null ) {
            return null;
        }

        TipoSede.TipoSedeBuilder tipoSede = TipoSede.builder();

        tipoSede.id( sedeDTO.getTipoSedeId() );

        return tipoSede.build();
    }

    protected Empresa sedeDTOToEmpresa(SedeDTO sedeDTO) {
        if ( sedeDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( sedeDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Municipio sedeDTOToMunicipio(SedeDTO sedeDTO) {
        if ( sedeDTO == null ) {
            return null;
        }

        Municipio.MunicipioBuilder municipio = Municipio.builder();

        municipio.id( sedeDTO.getMunicipioId() );

        return municipio.build();
    }

    protected Estado sedeDTOToEstado(SedeDTO sedeDTO) {
        if ( sedeDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( sedeDTO.getEstadoId() );

        return estado.build();
    }
}
