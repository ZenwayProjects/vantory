package com.vantory.validator.inventario.entidades;

import org.springframework.stereotype.Component;

import com.vantory.exceptionHandler.NotFoundException;
import com.vantory.productoCategoria.ProductoCategoria;
import com.vantory.productoCategoria.repositories.ProductoCategoriaRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductoCategoriaValidator {

    private final ProductoCategoriaRepository productoCategoriaRepository;

    public ProductoCategoria validarProductoCategoriaPorEmpresa(Long productoCategoriaId, Long empresaId) {
        return productoCategoriaRepository.findByIdAndEmpresaId(productoCategoriaId, empresaId)
                .orElseThrow(() -> new NotFoundException("producto-categoria.not-found", productoCategoriaId));
    }

}
