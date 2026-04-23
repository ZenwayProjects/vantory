package com.vantory.validator.inventario.entidades;

import com.vantory.articuloKardex.ArticuloKardex;
import com.vantory.articuloKardex.repositories.ArticuloKardexRepository;
import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.validator.common.BaseValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArticuloKardexValidator implements BaseValidator {
    private final ArticuloKardexRepository articuloKardexRepository;


    public ArticuloKardex validarArticuloKardex(Long articuloKardexId, Long empresaId){
        return articuloKardexRepository.findByIdAndEmpresaId(articuloKardexId, empresaId)
                .orElseThrow(() -> new NotFoundException("El artículo de kardex no fue encontrado."));
    }
}
