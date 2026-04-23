package com.vantory.municipio.mappers;

import com.vantory.departamento.Departamento;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.municipio.Municipio;
import com.vantory.municipio.dtos.MunicipioDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class MunicipioMapperImpl implements MunicipioMapper {

    @Override
    public MunicipioDTO toDTO(Municipio municipio) {
        if ( municipio == null ) {
            return null;
        }

        Long departamentoId = null;
        Long empresaId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        Integer codigo = null;
        String acronimo = null;

        departamentoId = municipioDepartamentoId( municipio );
        empresaId = municipioEmpresaId( municipio );
        estadoId = municipioEstadoId( municipio );
        id = municipio.getId();
        nombre = municipio.getNombre();
        codigo = municipio.getCodigo();
        acronimo = municipio.getAcronimo();

        MunicipioDTO municipioDTO = new MunicipioDTO( id, nombre, departamentoId, codigo, acronimo, empresaId, estadoId );

        return municipioDTO;
    }

    @Override
    public Municipio toEntity(MunicipioDTO municipioDTO) {
        if ( municipioDTO == null ) {
            return null;
        }

        Municipio.MunicipioBuilder municipio = Municipio.builder();

        municipio.departamento( municipioDTOToDepartamento( municipioDTO ) );
        municipio.empresa( municipioDTOToEmpresa( municipioDTO ) );
        municipio.estado( municipioDTOToEstado( municipioDTO ) );
        municipio.id( municipioDTO.getId() );
        municipio.nombre( municipioDTO.getNombre() );
        municipio.codigo( municipioDTO.getCodigo() );
        municipio.acronimo( municipioDTO.getAcronimo() );

        return municipio.build();
    }

    @Override
    public MunicipioDTO toListDto(Municipio municipio) {
        if ( municipio == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        Long departamentoId = null;
        Integer codigo = null;
        String acronimo = null;
        Long estadoId = null;

        id = municipio.getId();
        nombre = municipio.getNombre();
        departamentoId = municipioDepartamentoId( municipio );
        codigo = municipio.getCodigo();
        acronimo = municipio.getAcronimo();
        estadoId = municipioEstadoId( municipio );

        Long empresaId = null;

        MunicipioDTO municipioDTO = new MunicipioDTO( id, nombre, departamentoId, codigo, acronimo, empresaId, estadoId );

        return municipioDTO;
    }

    private Long municipioDepartamentoId(Municipio municipio) {
        Departamento departamento = municipio.getDepartamento();
        if ( departamento == null ) {
            return null;
        }
        return departamento.getId();
    }

    private Long municipioEmpresaId(Municipio municipio) {
        Empresa empresa = municipio.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long municipioEstadoId(Municipio municipio) {
        Estado estado = municipio.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Departamento municipioDTOToDepartamento(MunicipioDTO municipioDTO) {
        if ( municipioDTO == null ) {
            return null;
        }

        Departamento.DepartamentoBuilder departamento = Departamento.builder();

        departamento.id( municipioDTO.getDepartamentoId() );

        return departamento.build();
    }

    protected Empresa municipioDTOToEmpresa(MunicipioDTO municipioDTO) {
        if ( municipioDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( municipioDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Estado municipioDTOToEstado(MunicipioDTO municipioDTO) {
        if ( municipioDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( municipioDTO.getEstadoId() );

        return estado.build();
    }
}
