package com.vantory.produccionFase.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.fase.Fase;
import com.vantory.produccionFase.ProduccionFase;
import com.vantory.produccionFase.dtos.ProduccionFaseDTO;
import com.vantory.tipoProduccion.TipoProduccion;
import com.vantory.variedad.Variedad;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class ProduccionFaseMapperImpl implements ProduccionFaseMapper {

    @Override
    public ProduccionFaseDTO toDto(ProduccionFase produccionFase) {
        if ( produccionFase == null ) {
            return null;
        }

        ProduccionFaseDTO.ProduccionFaseDTOBuilder produccionFaseDTO = ProduccionFaseDTO.builder();

        produccionFaseDTO.variedadId( produccionFaseVariedadId( produccionFase ) );
        produccionFaseDTO.tipoProduccionId( produccionFaseTipoProduccionId( produccionFase ) );
        produccionFaseDTO.faseId( produccionFaseFaseId( produccionFase ) );
        produccionFaseDTO.estadoId( produccionFaseEstadoId( produccionFase ) );
        produccionFaseDTO.empresaId( produccionFaseEmpresaId( produccionFase ) );
        produccionFaseDTO.id( produccionFase.getId() );
        if ( produccionFase.getDias() != null ) {
            produccionFaseDTO.dias( produccionFase.getDias().longValue() );
        }
        produccionFaseDTO.descripcion( produccionFase.getDescripcion() );

        return produccionFaseDTO.build();
    }

    @Override
    public ProduccionFase toEntity(ProduccionFaseDTO produccionFaseDTO) {
        if ( produccionFaseDTO == null ) {
            return null;
        }

        ProduccionFase.ProduccionFaseBuilder produccionFase = ProduccionFase.builder();

        produccionFase.variedad( produccionFaseDTOToVariedad( produccionFaseDTO ) );
        produccionFase.tipoProduccion( produccionFaseDTOToTipoProduccion( produccionFaseDTO ) );
        produccionFase.fase( produccionFaseDTOToFase( produccionFaseDTO ) );
        produccionFase.estado( produccionFaseDTOToEstado( produccionFaseDTO ) );
        produccionFase.empresa( produccionFaseDTOToEmpresa( produccionFaseDTO ) );
        produccionFase.id( produccionFaseDTO.getId() );
        if ( produccionFaseDTO.getDias() != null ) {
            produccionFase.dias( produccionFaseDTO.getDias().intValue() );
        }
        produccionFase.descripcion( produccionFaseDTO.getDescripcion() );

        return produccionFase.build();
    }

    @Override
    public ProduccionFaseDTO toListDTO(ProduccionFase produccionFase) {
        if ( produccionFase == null ) {
            return null;
        }

        ProduccionFaseDTO.ProduccionFaseDTOBuilder produccionFaseDTO = ProduccionFaseDTO.builder();

        produccionFaseDTO.variedadId( produccionFaseVariedadId( produccionFase ) );
        produccionFaseDTO.tipoProduccionId( produccionFaseTipoProduccionId( produccionFase ) );
        produccionFaseDTO.faseId( produccionFaseFaseId( produccionFase ) );
        produccionFaseDTO.estadoId( produccionFaseEstadoId( produccionFase ) );
        produccionFaseDTO.id( produccionFase.getId() );
        if ( produccionFase.getDias() != null ) {
            produccionFaseDTO.dias( produccionFase.getDias().longValue() );
        }
        produccionFaseDTO.descripcion( produccionFase.getDescripcion() );

        return produccionFaseDTO.build();
    }

    private Long produccionFaseVariedadId(ProduccionFase produccionFase) {
        Variedad variedad = produccionFase.getVariedad();
        if ( variedad == null ) {
            return null;
        }
        return variedad.getId();
    }

    private Long produccionFaseTipoProduccionId(ProduccionFase produccionFase) {
        TipoProduccion tipoProduccion = produccionFase.getTipoProduccion();
        if ( tipoProduccion == null ) {
            return null;
        }
        return tipoProduccion.getId();
    }

    private Long produccionFaseFaseId(ProduccionFase produccionFase) {
        Fase fase = produccionFase.getFase();
        if ( fase == null ) {
            return null;
        }
        return fase.getId();
    }

    private Long produccionFaseEstadoId(ProduccionFase produccionFase) {
        Estado estado = produccionFase.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    private Long produccionFaseEmpresaId(ProduccionFase produccionFase) {
        Empresa empresa = produccionFase.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    protected Variedad produccionFaseDTOToVariedad(ProduccionFaseDTO produccionFaseDTO) {
        if ( produccionFaseDTO == null ) {
            return null;
        }

        Variedad.VariedadBuilder variedad = Variedad.builder();

        variedad.id( produccionFaseDTO.getVariedadId() );

        return variedad.build();
    }

    protected TipoProduccion produccionFaseDTOToTipoProduccion(ProduccionFaseDTO produccionFaseDTO) {
        if ( produccionFaseDTO == null ) {
            return null;
        }

        TipoProduccion.TipoProduccionBuilder tipoProduccion = TipoProduccion.builder();

        tipoProduccion.id( produccionFaseDTO.getTipoProduccionId() );

        return tipoProduccion.build();
    }

    protected Fase produccionFaseDTOToFase(ProduccionFaseDTO produccionFaseDTO) {
        if ( produccionFaseDTO == null ) {
            return null;
        }

        Fase.FaseBuilder fase = Fase.builder();

        fase.id( produccionFaseDTO.getFaseId() );

        return fase.build();
    }

    protected Estado produccionFaseDTOToEstado(ProduccionFaseDTO produccionFaseDTO) {
        if ( produccionFaseDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( produccionFaseDTO.getEstadoId() );

        return estado.build();
    }

    protected Empresa produccionFaseDTOToEmpresa(ProduccionFaseDTO produccionFaseDTO) {
        if ( produccionFaseDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( produccionFaseDTO.getEmpresaId() );

        return empresa.build();
    }
}
