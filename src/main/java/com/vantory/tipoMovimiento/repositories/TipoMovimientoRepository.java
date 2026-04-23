package com.vantory.tipoMovimiento.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vantory.tipoMovimiento.TipoMovimiento;

public interface TipoMovimientoRepository extends JpaRepository<TipoMovimiento, Long> {

	List<TipoMovimiento> findByEmpresaIdOrderByIdAsc(Long empresaId);

	Optional<TipoMovimiento> findByIdAndEmpresaId(Long id, Long empresaId);

}
