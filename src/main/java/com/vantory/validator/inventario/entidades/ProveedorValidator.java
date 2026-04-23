package com.vantory.validator.inventario.entidades;

import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.proveedor.Proveedor;
import com.vantory.proveedor.repositories.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProveedorValidator {

    private final ProveedorRepository proveedorRepository;

    public Proveedor validarProveedor(Long proveedorId, Long empresaId){
        return proveedorRepository.findByIdAndEmpresaId(proveedorId, empresaId)
                .orElseThrow(()-> new NotFoundException("proveedor.not-found", proveedorId));
    }
}
