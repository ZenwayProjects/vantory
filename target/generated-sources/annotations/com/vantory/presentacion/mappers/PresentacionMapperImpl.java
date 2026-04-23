package com.vantory.presentacion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.presentacion.Presentacion;
import com.vantory.presentacion.dtos.PresentacionDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class PresentacionMapperImpl implements PresentacionMapper {

    @Override
    public PresentacionDTO toDTO(Presentacion presentacion) {
        if ( presentacion == null ) {
            return null;
        }

        Long estadoId = null;
        Long empresaId = null;
        Long id = null;
        String nombre = null;
        String descripcion = null;

        estadoId = presentacionEstadoId( presentacion );
        empresaId = presentacionEmpresaId( presentacion );
        id = presentacion.getId();
        nombre = presentacion.getNombre();
        descripcion = presentacion.getDescripcion();

        PresentacionDTO presentacionDTO = new PresentacionDTO( id, nombre, descripcion, estadoId, empresaId );

        return presentacionDTO;
    }

    @Override
    public Presentacion toEntity(PresentacionDTO presentacionDTO) {
        if ( presentacionDTO == null ) {
            return null;
        }

        Presentacion presentacion = new Presentacion();

        presentacion.setEstado( presentacionDTOToEstado( presentacionDTO ) );
        presentacion.setEmpresa( presentacionDTOToEmpresa( presentacionDTO ) );
        presentacion.setId( presentacionDTO.getId() );
        presentacion.setNombre( presentacionDTO.getNombre() );
        presentacion.setDescripcion( presentacionDTO.getDescripcion() );

        return presentacion;
    }

    private Long presentacionEstadoId(Presentacion presentacion) {
        Estado estado = presentacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long presentacionEmpresaId(Presentacion presentacion) {
        Empresa empresa = presentacion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Estado presentacionDTOToEstado(PresentacionDTO presentacionDTO) {
        if ( presentacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( presentacionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa presentacionDTOToEmpresa(PresentacionDTO presentacionDTO) {
        if ( presentacionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( presentacionDTO.getEmpresaId() );

        return empresa.build();
    }
}
