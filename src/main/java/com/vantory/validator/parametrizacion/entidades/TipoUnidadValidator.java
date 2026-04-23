package com.vantory.validator.parametrizacion.entidades;

import com.vantory.exceptionHandler.BadRequestException;
import com.vantory.tipounidad.TipoUnidad;
import com.vantory.tipounidad.repositories.TipoUnidadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipoUnidadValidator {

    private final TipoUnidadRepository tipoUnidadRepository;


    public TipoUnidad validarTipoUnidad(Long tipoUnidad){
        return tipoUnidadRepository.findById(tipoUnidad)
                .orElseThrow(()-> new BadRequestException("Tipo de producción no válido"));

    }

}
