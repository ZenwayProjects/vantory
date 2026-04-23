package com.vantory.validator.inventario.entidades;

import com.vantory.empresa.Empresa;
import com.vantory.empresa.repositories.EmpresaRepository;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmpresaValidator implements BaseValidator {

    private final EmpresaRepository empresaRepository;

    public Empresa validarEmpresa(Long empresaId) {
        return empresaRepository.findById(empresaId)
                .orElseThrow(() -> new NotFoundException("empresa.not-found"));
    }

    public Empresa validarClienteProveedor(Long clienteProveedorId) {
        return empresaRepository.findById(clienteProveedorId)
                .orElseThrow(() -> new NotFoundException("cliente-proveedor.not-found"));
    }
}
