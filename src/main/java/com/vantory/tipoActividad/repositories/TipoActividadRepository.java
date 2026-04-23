package com.vantory.tipoActividad.repositories;

import com.vantory.tipoActividad.TipoActividad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TipoActividadRepository extends JpaRepository<TipoActividad, Long> {

	Optional<TipoActividad> findByIdAndEmpresaId(Long id, Long empresaId);

	List<TipoActividad> findByEmpresaIdOrderByIdAsc(Long empresaId);

}
