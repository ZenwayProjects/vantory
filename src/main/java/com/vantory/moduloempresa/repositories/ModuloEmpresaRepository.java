package com.vantory.moduloempresa.repositories;

import com.vantory.empresa.Empresa;
import com.vantory.modulo.Modulo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vantory.moduloempresa.ModuloEmpresa;

public interface ModuloEmpresaRepository extends JpaRepository<ModuloEmpresa, Long> {
    // Validar si ya existe la asignación
    boolean existsByEmpresaAndModulo(Empresa empresa, Modulo modulo);
}
