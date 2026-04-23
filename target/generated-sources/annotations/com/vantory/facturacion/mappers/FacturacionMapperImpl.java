package com.vantory.facturacion.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.facturacion.Facturacion;
import com.vantory.facturacion.dtos.FacturacionDTO;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class FacturacionMapperImpl implements FacturacionMapper {

    @Override
    public FacturacionDTO toDTO(Facturacion facturacion) {
        if ( facturacion == null ) {
            return null;
        }

        Long estadoId = null;
        Long id = null;
        String prefijo = null;
        Long numeroInicial = null;
        Integer cantidad = null;
        LocalDate fechaInicio = null;
        LocalDate fechaFin = null;

        estadoId = facturacionEstadoId( facturacion );
        id = facturacion.getId();
        prefijo = facturacion.getPrefijo();
        numeroInicial = facturacion.getNumeroInicial();
        cantidad = facturacion.getCantidad();
        fechaInicio = facturacion.getFechaInicio();
        fechaFin = facturacion.getFechaFin();

        Long empresaId = null;

        FacturacionDTO facturacionDTO = new FacturacionDTO( id, prefijo, numeroInicial, cantidad, fechaInicio, fechaFin, estadoId, empresaId );

        return facturacionDTO;
    }

    @Override
    public Facturacion toEntity(FacturacionDTO facturacionDTO) {
        if ( facturacionDTO == null ) {
            return null;
        }

        Facturacion.FacturacionBuilder facturacion = Facturacion.builder();

        facturacion.estado( facturacionDTOToEstado( facturacionDTO ) );
        facturacion.empresa( facturacionDTOToEmpresa( facturacionDTO ) );
        facturacion.id( facturacionDTO.getId() );
        facturacion.prefijo( facturacionDTO.getPrefijo() );
        facturacion.numeroInicial( facturacionDTO.getNumeroInicial() );
        facturacion.cantidad( facturacionDTO.getCantidad() );
        facturacion.fechaInicio( facturacionDTO.getFechaInicio() );
        facturacion.fechaFin( facturacionDTO.getFechaFin() );

        return facturacion.build();
    }

    private Long facturacionEstadoId(Facturacion facturacion) {
        Estado estado = facturacion.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Estado facturacionDTOToEstado(FacturacionDTO facturacionDTO) {
        if ( facturacionDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( facturacionDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa facturacionDTOToEmpresa(FacturacionDTO facturacionDTO) {
        if ( facturacionDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( facturacionDTO.getEmpresaId() );

        return empresa.build();
    }
}
