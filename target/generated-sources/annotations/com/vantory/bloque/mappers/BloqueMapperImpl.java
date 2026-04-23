package com.vantory.bloque.mappers;

import com.vantory.bloque.Bloque;
import com.vantory.bloque.dtos.BloqueDTO;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.sede.Sede;
import com.vantory.tipoBloque.TipoBloque;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:59-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class BloqueMapperImpl implements BloqueMapper {

    @Override
    public BloqueDTO toDTO(Bloque bloque) {
        if ( bloque == null ) {
            return null;
        }

        Long sedeId = null;
        Long tipoBloqueId = null;
        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        Integer numeroPisos = null;
        String descripcion = null;
        String geolocalizacion = null;
        String coordenadas = null;
        String direccion = null;

        sedeId = bloqueSedeId( bloque );
        tipoBloqueId = bloqueTipoBloqueId( bloque );
        estadoId = bloqueEstadoId( bloque );
        empresaId = bloqueEmpresaId( bloque );
        id = bloque.getId();
        nombre = bloque.getNombre();
        numeroPisos = bloque.getNumeroPisos();
        descripcion = bloque.getDescripcion();
        geolocalizacion = bloque.getGeolocalizacion();
        coordenadas = bloque.getCoordenadas();
        direccion = bloque.getDireccion();

        BloqueDTO bloqueDTO = new BloqueDTO( id, sedeId, tipoBloqueId, nombre, numeroPisos, descripcion, estadoId, geolocalizacion, coordenadas, direccion, empresaId );

        return bloqueDTO;
    }

    @Override
    public Bloque toEntity(BloqueDTO bloqueDTO) {
        if ( bloqueDTO == null ) {
            return null;
        }

        Bloque.BloqueBuilder bloque = Bloque.builder();

        bloque.sede( bloqueDTOToSede( bloqueDTO ) );
        bloque.tipoBloque( bloqueDTOToTipoBloque( bloqueDTO ) );
        bloque.estado( bloqueDTOToEstado( bloqueDTO ) );
        bloque.empresa( bloqueDTOToEmpresa( bloqueDTO ) );
        bloque.id( bloqueDTO.getId() );
        bloque.nombre( bloqueDTO.getNombre() );
        bloque.numeroPisos( bloqueDTO.getNumeroPisos() );
        bloque.descripcion( bloqueDTO.getDescripcion() );
        bloque.geolocalizacion( bloqueDTO.getGeolocalizacion() );
        bloque.coordenadas( bloqueDTO.getCoordenadas() );
        bloque.direccion( bloqueDTO.getDireccion() );

        return bloque.build();
    }

    @Override
    public BloqueDTO toListDto(Bloque bloque) {
        if ( bloque == null ) {
            return null;
        }

        Long sedeId = null;
        Long tipoBloqueId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        Integer numeroPisos = null;
        String descripcion = null;
        String geolocalizacion = null;
        String coordenadas = null;
        String direccion = null;

        sedeId = bloqueSedeId( bloque );
        tipoBloqueId = bloqueTipoBloqueId( bloque );
        estadoId = bloqueEstadoId( bloque );
        id = bloque.getId();
        nombre = bloque.getNombre();
        numeroPisos = bloque.getNumeroPisos();
        descripcion = bloque.getDescripcion();
        geolocalizacion = bloque.getGeolocalizacion();
        coordenadas = bloque.getCoordenadas();
        direccion = bloque.getDireccion();

        Long empresaId = null;

        BloqueDTO bloqueDTO = new BloqueDTO( id, sedeId, tipoBloqueId, nombre, numeroPisos, descripcion, estadoId, geolocalizacion, coordenadas, direccion, empresaId );

        return bloqueDTO;
    }

    private Long bloqueSedeId(Bloque bloque) {
        Sede sede = bloque.getSede();
        if ( sede == null ) {
            return null;
        }
        return sede.getId();
    }

    private Long bloqueTipoBloqueId(Bloque bloque) {
        TipoBloque tipoBloque = bloque.getTipoBloque();
        if ( tipoBloque == null ) {
            return null;
        }
        return tipoBloque.getId();
    }

    private Long bloqueEstadoId(Bloque bloque) {
        Estado estado = bloque.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long bloqueEmpresaId(Bloque bloque) {
        Empresa empresa = bloque.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Sede bloqueDTOToSede(BloqueDTO bloqueDTO) {
        if ( bloqueDTO == null ) {
            return null;
        }

        Sede.SedeBuilder sede = Sede.builder();

        sede.id( bloqueDTO.getSedeId() );

        return sede.build();
    }

    protected TipoBloque bloqueDTOToTipoBloque(BloqueDTO bloqueDTO) {
        if ( bloqueDTO == null ) {
            return null;
        }

        TipoBloque.TipoBloqueBuilder tipoBloque = TipoBloque.builder();

        tipoBloque.id( bloqueDTO.getTipoBloqueId() );

        return tipoBloque.build();
    }

    protected Estado bloqueDTOToEstado(BloqueDTO bloqueDTO) {
        if ( bloqueDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( bloqueDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa bloqueDTOToEmpresa(BloqueDTO bloqueDTO) {
        if ( bloqueDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( bloqueDTO.getEmpresaId() );

        return empresa.build();
    }
}
