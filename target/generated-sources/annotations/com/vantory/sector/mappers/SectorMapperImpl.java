package com.vantory.sector.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.sector.Sector;
import com.vantory.sector.dtos.SectorDTO;
import com.vantory.subseccion.Subseccion;
import com.vantory.variedad.Variedad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class SectorMapperImpl implements SectorMapper {

    @Override
    public SectorDTO toDto(Sector sector) {
        if ( sector == null ) {
            return null;
        }

        SectorDTO.SectorDTOBuilder sectorDTO = SectorDTO.builder();

        sectorDTO.subseccionId( sectorSubseccionId( sector ) );
        sectorDTO.variedadId( sectorVariedadId( sector ) );
        sectorDTO.estadoId( sectorEstadoId( sector ) );
        sectorDTO.empresaId( sectorEmpresaId( sector ) );
        sectorDTO.id( sector.getId() );
        sectorDTO.descripcion( sector.getDescripcion() );

        return sectorDTO.build();
    }

    @Override
    public Sector toEntity(SectorDTO sectorDTO) {
        if ( sectorDTO == null ) {
            return null;
        }

        Sector.SectorBuilder sector = Sector.builder();

        sector.subseccion( sectorDTOToSubseccion( sectorDTO ) );
        sector.variedad( sectorDTOToVariedad( sectorDTO ) );
        sector.estado( sectorDTOToEstado( sectorDTO ) );
        sector.empresa( sectorDTOToEmpresa( sectorDTO ) );
        sector.id( sectorDTO.getId() );
        sector.descripcion( sectorDTO.getDescripcion() );

        return sector.build();
    }

    @Override
    public SectorDTO toListDTO(Sector sector) {
        if ( sector == null ) {
            return null;
        }

        SectorDTO.SectorDTOBuilder sectorDTO = SectorDTO.builder();

        sectorDTO.subseccionId( sectorSubseccionId( sector ) );
        sectorDTO.variedadId( sectorVariedadId( sector ) );
        sectorDTO.estadoId( sectorEstadoId( sector ) );
        sectorDTO.id( sector.getId() );
        sectorDTO.descripcion( sector.getDescripcion() );

        return sectorDTO.build();
    }

    private Long sectorSubseccionId(Sector sector) {
        Subseccion subseccion = sector.getSubseccion();
        if ( subseccion == null ) {
            return null;
        }
        return subseccion.getId();
    }

    private Long sectorVariedadId(Sector sector) {
        Variedad variedad = sector.getVariedad();
        if ( variedad == null ) {
            return null;
        }
        return variedad.getId();
    }

    private Long sectorEstadoId(Sector sector) {
        Estado estado = sector.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long sectorEmpresaId(Sector sector) {
        Empresa empresa = sector.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Subseccion sectorDTOToSubseccion(SectorDTO sectorDTO) {
        if ( sectorDTO == null ) {
            return null;
        }

        Subseccion.SubseccionBuilder subseccion = Subseccion.builder();

        subseccion.id( sectorDTO.getSubseccionId() );

        return subseccion.build();
    }

    protected Variedad sectorDTOToVariedad(SectorDTO sectorDTO) {
        if ( sectorDTO == null ) {
            return null;
        }

        Variedad.VariedadBuilder variedad = Variedad.builder();

        variedad.id( sectorDTO.getVariedadId() );

        return variedad.build();
    }

    protected Estado sectorDTOToEstado(SectorDTO sectorDTO) {
        if ( sectorDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( sectorDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa sectorDTOToEmpresa(SectorDTO sectorDTO) {
        if ( sectorDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( sectorDTO.getEmpresaId() );

        return empresa.build();
    }
}
