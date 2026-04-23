package com.vantory.departamento.mappers;

import com.vantory.departamento.Departamento;
import com.vantory.departamento.dtos.DepartamentoDTO;
import com.vantory.empresa.Empresa;
import com.vantory.estado.Estado;
import com.vantory.pais.Pais;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class DepartamentoMapperImpl implements DepartamentoMapper {

    @Override
    public DepartamentoDTO toDTO(Departamento departamento) {
        if ( departamento == null ) {
            return null;
        }

        Long paisId = null;
        Long empresaId = null;
        Long estadoId = null;
        Long id = null;
        String nombre = null;
        Integer codigo = null;
        String acronimo = null;

        paisId = departamentoPaisId( departamento );
        empresaId = departamentoEmpresaId( departamento );
        estadoId = departamentoEstadoId( departamento );
        id = departamento.getId();
        nombre = departamento.getNombre();
        codigo = departamento.getCodigo();
        acronimo = departamento.getAcronimo();

        DepartamentoDTO departamentoDTO = new DepartamentoDTO( id, nombre, paisId, codigo, acronimo, empresaId, estadoId );

        return departamentoDTO;
    }

    @Override
    public Departamento toEntity(DepartamentoDTO departamentoDTO) {
        if ( departamentoDTO == null ) {
            return null;
        }

        Departamento.DepartamentoBuilder departamento = Departamento.builder();

        departamento.pais( departamentoDTOToPais( departamentoDTO ) );
        departamento.empresa( departamentoDTOToEmpresa( departamentoDTO ) );
        departamento.estado( departamentoDTOToEstado( departamentoDTO ) );
        departamento.id( departamentoDTO.getId() );
        departamento.nombre( departamentoDTO.getNombre() );
        departamento.codigo( departamentoDTO.getCodigo() );
        departamento.acronimo( departamentoDTO.getAcronimo() );

        return departamento.build();
    }

    @Override
    public DepartamentoDTO toListDto(Departamento departamento) {
        if ( departamento == null ) {
            return null;
        }

        Long id = null;
        String nombre = null;
        Long paisId = null;
        Integer codigo = null;
        String acronimo = null;
        Long estadoId = null;

        id = departamento.getId();
        nombre = departamento.getNombre();
        paisId = departamentoPaisId( departamento );
        codigo = departamento.getCodigo();
        acronimo = departamento.getAcronimo();
        estadoId = departamentoEstadoId( departamento );

        Long empresaId = null;

        DepartamentoDTO departamentoDTO = new DepartamentoDTO( id, nombre, paisId, codigo, acronimo, empresaId, estadoId );

        return departamentoDTO;
    }

    private Long departamentoPaisId(Departamento departamento) {
        Pais pais = departamento.getPais();
        if ( pais == null ) {
            return null;
        }
        return pais.getId();
    }

    private Long departamentoEmpresaId(Departamento departamento) {
        Empresa empresa = departamento.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getId();
    }

    private Long departamentoEstadoId(Departamento departamento) {
        Estado estado = departamento.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getId();
    }

    protected Pais departamentoDTOToPais(DepartamentoDTO departamentoDTO) {
        if ( departamentoDTO == null ) {
            return null;
        }

        Pais.PaisBuilder pais = Pais.builder();

        pais.id( departamentoDTO.getPaisId() );

        return pais.build();
    }

    protected Empresa departamentoDTOToEmpresa(DepartamentoDTO departamentoDTO) {
        if ( departamentoDTO == null ) {
            return null;
        }

        Empresa.EmpresaBuilder empresa = Empresa.builder();

        empresa.id( departamentoDTO.getEmpresaId() );

        return empresa.build();
    }

    protected Estado departamentoDTOToEstado(DepartamentoDTO departamentoDTO) {
        if ( departamentoDTO == null ) {
            return null;
        }

        Estado.EstadoBuilder estado = Estado.builder();

        estado.id( departamentoDTO.getEstadoId() );

        return estado.build();
    }
}
