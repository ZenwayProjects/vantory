package com.vantory.validator.inventario.entidades;

import com.vantory.almacen.Almacen;
import com.vantory.almacen.repositories.AlmacenRepository;
import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlmacenValidator implements BaseValidator {

    private final AlmacenRepository almacenRepository;


    public Almacen validarAlmacen(Long almacenId, Long empresaId) {
        return almacenRepository.findByIdAndEmpresaId(almacenId, empresaId)
                .orElseThrow(() -> new BadRequestException("almacen.not-found", almacenId));
    }
}
