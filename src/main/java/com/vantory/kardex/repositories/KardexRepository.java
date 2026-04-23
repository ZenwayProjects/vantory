package com.vantory.kardex.repositories;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vantory.kardex.Kardex;

public interface KardexRepository extends JpaRepository<Kardex, Long> {

	Optional<Kardex> findByIdAndEmpresaId(Long id, Long empresaId);

	Page<Kardex> findByEmpresaIdOrderByIdAsc(Long empresaId, Pageable pageable);

	Optional<Kardex> findByOrdenCompraIdAndEmpresaId(Long ordenCompraId, Long empresaId );

}
