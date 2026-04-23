package com.vantory.productoLocalizacion.repositories;

import com.vantory.productoLocalizacion.ProductoLocalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoLocalizacionRepository extends JpaRepository<ProductoLocalizacion, Long> {

	Optional<ProductoLocalizacion> findByIdAndEmpresaId(Long id, Long empresaId);

	List<ProductoLocalizacion> findByEmpresaIdOrderByIdAsc(Long empresaId);

}
