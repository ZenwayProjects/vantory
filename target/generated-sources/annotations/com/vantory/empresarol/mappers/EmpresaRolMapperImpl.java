package com.vantory.empresarol.mappers;

import com.vantory.empresa.Empresa;
import com.vantory.empresarol.EmpresaRol;
import com.vantory.empresarol.dtos.requests.EmpresaRolSystemUpdateRequestDTO;
import com.vantory.empresarol.dtos.requests.EmpresaRolUpdateRequestDTO;
import com.vantory.empresarol.dtos.responses.EmpresaRolResponseDTO;
import com.vantory.estado.Estado;
import com.vantory.rol.Rol;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-04-23T02:00:58-0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EmpresaRolMapperImpl implements EmpresaRolMapper {

    @Override
    public EmpresaRolResponseDTO toResponseDto(EmpresaRol empresaRol) {
        if ( empresaRol == null ) {
            return null;
        }

        EmpresaRolResponseDTO empresaRolResponseDTO = new EmpresaRolResponseDTO();

        empresaRolResponseDTO.setEmpresaNombre( empresaRolEmpresaNombre( empresaRol ) );
        empresaRolResponseDTO.setRolNombre( empresaRolRolNombre( empresaRol ) );
        empresaRolResponseDTO.setEstadoNombre( empresaRolEstadoNombre( empresaRol ) );
        empresaRolResponseDTO.setId( empresaRol.getId() );

        return empresaRolResponseDTO;
    }

    @Override
    public void updateEntityFromDto(EmpresaRolUpdateRequestDTO dto, EmpresaRol entity) {
        if ( dto == null ) {
            return;
        }
    }

    @Override
    public void updateAdminEntityFromDto(EmpresaRolSystemUpdateRequestDTO dto, EmpresaRol entity) {
        if ( dto == null ) {
            return;
        }
    }

    private String empresaRolEmpresaNombre(EmpresaRol empresaRol) {
        Empresa empresa = empresaRol.getEmpresa();
        if ( empresa == null ) {
            return null;
        }
        return empresa.getNombre();
    }

    private String empresaRolRolNombre(EmpresaRol empresaRol) {
        Rol rol = empresaRol.getRol();
        if ( rol == null ) {
            return null;
        }
        return rol.getNombre();
    }

    private String empresaRolEstadoNombre(EmpresaRol empresaRol) {
        Estado estado = empresaRol.getEstado();
        if ( estado == null ) {
            return null;
        }
        return estado.getNombre();
    }
}
