package com.vantory.dispositivoMedicion.mappers;

import com.vantory.dispositivoMedicion.DispositivoMedicion;
import com.vantory.dispositivoMedicion.dtos.DispositivoMedicionDTO;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.subSeccionDispositivo.SubseccionDispositivo;
import com.vantory.tipoMedicion.TipoMedicion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DispositivoMedicionMapperImpl implements DispositivoMedicionMapper {

    @Override
    public DispositivoMedicionDTO toDto(DispositivoMedicion dispositivoMedicion) {
        if ( dispositivoMedicion == null ) {
            return null;
        }

        DispositivoMedicionDTO.DispositivoMedicionDTOBuilder dispositivoMedicionDTO = DispositivoMedicionDTO.builder();

        dispositivoMedicionDTO.subseccionDispositivoId( dispositivoMedicionSubseccionDispositivoId( dispositivoMedicion ) );
        dispositivoMedicionDTO.tipoMedicionId( dispositivoMedicionTipoMedicionId( dispositivoMedicion ) );
        dispositivoMedicionDTO.estadoId( dispositivoMedicionEstadoId( dispositivoMedicion ) );
        dispositivoMedicionDTO.empresaId( dispositivoMedicionEmpresaId( dispositivoMedicion ) );
        dispositivoMedicionDTO.id( dispositivoMedicion.getId() );
        dispositivoMedicionDTO.nombre( dispositivoMedicion.getNombre() );
        dispositivoMedicionDTO.descripcion( dispositivoMedicion.getDescripcion() );
        if ( dispositivoMedicion.getValor() != null ) {
            dispositivoMedicionDTO.valor( dispositivoMedicion.getValor().intValue() );
        }
        dispositivoMedicionDTO.fechaHora( dispositivoMedicion.getFechaHora() );

        return dispositivoMedicionDTO.build();
    }

    @Override
    public DispositivoMedicion toEntity(DispositivoMedicionDTO dispositivoMedicionDTO) {
        if ( dispositivoMedicionDTO == null ) {
            return null;
        }

        DispositivoMedicion.DispositivoMedicionBuilder dispositivoMedicion = DispositivoMedicion.builder();

        dispositivoMedicion.subseccionDispositivo( dispositivoMedicionDTOToSubseccionDispositivo( dispositivoMedicionDTO ) );
        dispositivoMedicion.tipoMedicion( dispositivoMedicionDTOToTipoMedicion( dispositivoMedicionDTO ) );
        dispositivoMedicion.estado( dispositivoMedicionDTOToEstado( dispositivoMedicionDTO ) );
        dispositivoMedicion.empresa( dispositivoMedicionDTOToEmpresa( dispositivoMedicionDTO ) );
        dispositivoMedicion.id( dispositivoMedicionDTO.getId() );
        if ( dispositivoMedicionDTO.getValor() != null ) {
            dispositivoMedicion.valor( dispositivoMedicionDTO.getValor().doubleValue() );
        }
        dispositivoMedicion.nombre( dispositivoMedicionDTO.getNombre() );
        dispositivoMedicion.descripcion( dispositivoMedicionDTO.getDescripcion() );
        dispositivoMedicion.fechaHora( dispositivoMedicionDTO.getFechaHora() );

        return dispositivoMedicion.build();
    }

    @Override
    public DispositivoMedicionDTO toListDto(DispositivoMedicion dispositivoMedicion) {
        if ( dispositivoMedicion == null ) {
            return null;
        }

        DispositivoMedicionDTO.DispositivoMedicionDTOBuilder dispositivoMedicionDTO = DispositivoMedicionDTO.builder();

        dispositivoMedicionDTO.subseccionDispositivoId( dispositivoMedicionSubseccionDispositivoId( dispositivoMedicion ) );
        dispositivoMedicionDTO.tipoMedicionId( dispositivoMedicionTipoMedicionId( dispositivoMedicion ) );
        dispositivoMedicionDTO.estadoId( dispositivoMedicionEstadoId( dispositivoMedicion ) );
        dispositivoMedicionDTO.id( dispositivoMedicion.getId() );
        dispositivoMedicionDTO.nombre( dispositivoMedicion.getNombre() );
        dispositivoMedicionDTO.descripcion( dispositivoMedicion.getDescripcion() );
        if ( dispositivoMedicion.getValor() != null ) {
            dispositivoMedicionDTO.valor( dispositivoMedicion.getValor().intValue() );
        }
        dispositivoMedicionDTO.fechaHora( dispositivoMedicion.getFechaHora() );

        return dispositivoMedicionDTO.build();
    }

    private Long dispositivoMedicionSubseccionDispositivoId(DispositivoMedicion dispositivoMedicion) {
        SubseccionDispositivo subseccionDispositivo = dispositivoMedicion.getSubseccionDispositivo();
        if ( subseccionDispositivo == null ) {
            return null;
        }
        return subseccionDispositivo.getId();
    }

    private Long dispositivoMedicionTipoMedicionId(DispositivoMedicion dispositivoMedicion) {
        TipoMedicion tipoMedicion = dispositivoMedicion.getTipoMedicion();
        if ( tipoMedicion == null ) {
            return null;
        }
        return tipoMedicion.getId();
    }

    private Long dispositivoMedicionEstadoId(DispositivoMedicion dispositivoMedicion) {
        Estado estado = dispositivoMedicion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long dispositivoMedicionEmpresaId(DispositivoMedicion dispositivoMedicion) {
        Empresa empresa = dispositivoMedicion.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected SubseccionDispositivo dispositivoMedicionDTOToSubseccionDispositivo(DispositivoMedicionDTO dispositivoMedicionDTO) {
        if ( dispositivoMedicionDTO == null ) {
            return null;
        }

        SubseccionDispositivo.SubseccionDispositivoBuilder subseccionDispositivo = SubseccionDispositivo.builder();

        subseccionDispositivo.id( dispositivoMedicionDTO.getSubseccionDispositivoId() );

        return subseccionDispositivo.build();
    }

    protected TipoMedicion dispositivoMedicionDTOToTipoMedicion(DispositivoMedicionDTO dispositivoMedicionDTO) {
        if ( dispositivoMedicionDTO == null ) {
            return null;
        }

        TipoMedicion.TipoMedicionBuilder tipoMedicion = TipoMedicion.builder();

        tipoMedicion.id( dispositivoMedicionDTO.getTipoMedicionId() );

        return tipoMedicion.build();
    }

    protected Estado dispositivoMedicionDTOToEstado(DispositivoMedicionDTO dispositivoMedicionDTO) {
        if ( dispositivoMedicionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( dispositivoMedicionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa dispositivoMedicionDTOToEmpresa(DispositivoMedicionDTO dispositivoMedicionDTO) {
        if ( dispositivoMedicionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( dispositivoMedicionDTO.getEmpresaId() );

        return empresa.build();
    }
}
