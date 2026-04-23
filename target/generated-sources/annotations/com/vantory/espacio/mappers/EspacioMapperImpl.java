package com.vantory.espacio.mappers;

import com.vantory.bloque.Bloque;
import com.vantory.empresa.Empresa;
import com.vantory.espacio.Espacio;
import com.vantory.espacio.dtos.EspacioDTO;
import com.vantory.estado.Estado;
import com.vantory.tipoEspacio.TipoEspacio;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EspacioMapperImpl implements EspacioMapper {

    @Override
    public EspacioDTO toDTO(Espacio espacio) {
        if ( espacio == null ) {
            return null;
        }

        Long bloqueId = null;
        Long tipoEspacioId = null;
        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        String geolocalizacion = null;
        String coordenadas = null;
        String direccion = null;

        bloqueId = espacioBloqueId( espacio );
        tipoEspacioId = espacioTipoEspacioId( espacio );
        estadoId = espacioEstadoId( espacio );
        empresaId = espacioEmpresaId( espacio );
        id = espacio.getId();
        nombre = espacio.getNombre();
        descripcion = espacio.getDescripcion();
        geolocalizacion = espacio.getGeolocalizacion();
        coordenadas = espacio.getCoordenadas();
        direccion = espacio.getDireccion();

        EspacioDTO espacioDTO = new EspacioDTO( id, bloqueId, tipoEspacioId, nombre, descripcion, estadoId, geolocalizacion, coordenadas, direccion, empresaId );

        return espacioDTO;
    }

    @Override
    public Espacio toEntity(EspacioDTO espacioDTO) {
        if ( espacioDTO == null ) {
            return null;
        }

        Espacio.EspacioBuilder espacio = Espacio.builder();

        espacio.bloque( espacioDTOToBloque( espacioDTO ) );
        espacio.tipoEspacio( espacioDTOToTipoEspacio( espacioDTO ) );
        espacio.estado( espacioDTOToEstado( espacioDTO ) );
        espacio.empresa( espacioDTOToEmpresa( espacioDTO ) );
        espacio.id( espacioDTO.getId() );
        espacio.nombre( espacioDTO.getNombre() );
        espacio.descripcion( espacioDTO.getDescripcion() );
        espacio.geolocalizacion( espacioDTO.getGeolocalizacion() );
        espacio.coordenadas( espacioDTO.getCoordenadas() );
        espacio.direccion( espacioDTO.getDireccion() );

        return espacio.build();
    }

    @Override
    public EspacioDTO toListDto(Espacio espacio) {
        if ( espacio == null ) {
            return null;
        }

        Long bloqueId = null;
        Long tipoEspacioId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        String geolocalizacion = null;
        String coordenadas = null;
        String direccion = null;

        bloqueId = espacioBloqueId( espacio );
        tipoEspacioId = espacioTipoEspacioId( espacio );
        estadoId = espacioEstadoId( espacio );
        id = espacio.getId();
        nombre = espacio.getNombre();
        descripcion = espacio.getDescripcion();
        geolocalizacion = espacio.getGeolocalizacion();
        coordenadas = espacio.getCoordenadas();
        direccion = espacio.getDireccion();

        Long empresaId = null;

        EspacioDTO espacioDTO = new EspacioDTO( id, bloqueId, tipoEspacioId, nombre, descripcion, estadoId, geolocalizacion, coordenadas, direccion, empresaId );

        return espacioDTO;
    }

    private Long espacioBloqueId(Espacio espacio) {
        Bloque bloque = espacio.getBloque();
        if ( bloque == null ) {
            return null;
        }
        return bloque.getId();
    }

    private Long espacioTipoEspacioId(Espacio espacio) {
        TipoEspacio tipoEspacio = espacio.getTipoEspacio();
        if ( tipoEspacio == null ) {
            return null;
        }
        return tipoEspacio.getId();
    }

    private Long espacioEstadoId(Espacio espacio) {
        Estado estado = espacio.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long espacioEmpresaId(Espacio espacio) {
        Empresa empresa = espacio.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Bloque espacioDTOToBloque(EspacioDTO espacioDTO) {
        if ( espacioDTO == null ) {
            return null;
        }

        Bloque.BloqueBuilder bloque = Bloque.builder();

        bloque.id( espacioDTO.getBloqueId() );

        return bloque.build();
    }

    protected TipoEspacio espacioDTOToTipoEspacio(EspacioDTO espacioDTO) {
        if ( espacioDTO == null ) {
            return null;
        }

        TipoEspacio.TipoEspacioBuilder tipoEspacio = TipoEspacio.builder();

        tipoEspacio.id( espacioDTO.getTipoEspacioId() );

        return tipoEspacio.build();
    }

    protected Estado espacioDTOToEstado(EspacioDTO espacioDTO) {
        if ( espacioDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( espacioDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa espacioDTOToEmpresa(EspacioDTO espacioDTO) {
        if ( espacioDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( espacioDTO.getEmpresaId() );

        return empresa.build();
    }
}
