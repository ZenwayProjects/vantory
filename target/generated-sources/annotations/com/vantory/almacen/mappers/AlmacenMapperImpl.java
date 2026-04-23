package com.vantory.almacen.mappers;

import com.vantory.almacen.Almacen;
import com.vantory.almacen.dtos.AlmacenDTO;
import com.vantory.empresa.Empresa;
import com.vantory.espacio.Espacio;
import com.vantory.estado.Estado;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AlmacenMapperImpl implements AlmacenMapper {

    @Override
    public AlmacenDTO toDTO(Almacen almacen) {
        if ( almacen == null ) {
            return null;
        }

        Long espacioId = null;
        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        String geolocalizacion = null;
        String coordenadas = null;
        String direccion = null;

        espacioId = almacenEspacioId( almacen );
        estadoId = almacenEstadoId( almacen );
        empresaId = almacenEmpresaId( almacen );
        id = almacen.getId();
        nombre = almacen.getNombre();
        descripcion = almacen.getDescripcion();
        geolocalizacion = almacen.getGeolocalizacion();
        coordenadas = almacen.getCoordenadas();
        direccion = almacen.getDireccion();

        AlmacenDTO almacenDTO = new AlmacenDTO( id, nombre, descripcion, estadoId, geolocalizacion, coordenadas, espacioId, direccion, empresaId );

        return almacenDTO;
    }

    @Override
    public Almacen toEntity(AlmacenDTO almacenDTO) {
        if ( almacenDTO == null ) {
            return null;
        }

        Almacen.AlmacenBuilder almacen = Almacen.builder();

        almacen.espacio( almacenDTOToEspacio( almacenDTO ) );
        almacen.estado( almacenDTOToEstado( almacenDTO ) );
        almacen.empresa( almacenDTOToEmpresa( almacenDTO ) );
        almacen.id( almacenDTO.getId() );
        almacen.nombre( almacenDTO.getNombre() );
        almacen.descripcion( almacenDTO.getDescripcion() );
        almacen.geolocalizacion( almacenDTO.getGeolocalizacion() );
        almacen.coordenadas( almacenDTO.getCoordenadas() );
        almacen.direccion( almacenDTO.getDireccion() );

        return almacen.build();
    }

    @Override
    public AlmacenDTO toListDto(Almacen almacen) {
        if ( almacen == null ) {
            return null;
        }

        Long espacioId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;
        String geolocalizacion = null;
        String coordenadas = null;
        String direccion = null;

        espacioId = almacenEspacioId( almacen );
        estadoId = almacenEstadoId( almacen );
        id = almacen.getId();
        nombre = almacen.getNombre();
        descripcion = almacen.getDescripcion();
        geolocalizacion = almacen.getGeolocalizacion();
        coordenadas = almacen.getCoordenadas();
        direccion = almacen.getDireccion();

        Long empresaId = null;

        AlmacenDTO almacenDTO = new AlmacenDTO( id, nombre, descripcion, estadoId, geolocalizacion, coordenadas, espacioId, direccion, empresaId );

        return almacenDTO;
    }

    private Long almacenEspacioId(Almacen almacen) {
        Espacio espacio = almacen.getEspacio();
        if ( espacio == null ) {
            return null;
        }
        return espacio.getId();
    }

    private Long almacenEstadoId(Almacen almacen) {
        Estado estado = almacen.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long almacenEmpresaId(Almacen almacen) {
        Empresa empresa = almacen.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Espacio almacenDTOToEspacio(AlmacenDTO almacenDTO) {
        if ( almacenDTO == null ) {
            return null;
        }

        Espacio.EspacioBuilder espacio = Espacio.builder();

        espacio.id( almacenDTO.getEspacioId() );

        return espacio.build();
    }

    protected Estado almacenDTOToEstado(AlmacenDTO almacenDTO) {
        if ( almacenDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( almacenDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa almacenDTOToEmpresa(AlmacenDTO almacenDTO) {
        if ( almacenDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( almacenDTO.getEmpresaId() );

        return empresa.build();
    }
}
