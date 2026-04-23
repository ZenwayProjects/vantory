package com.vantory.validator.seguridad;

import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.rol.Rol;
import com.vantory.rol.repositories.RolRepository;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RolValidator implements BaseValidator {

    private final RolRepository rolRepository;

    public Rol validarRol(Long id){
        return rolRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("El rol no fue encontrado"));
    }
}
