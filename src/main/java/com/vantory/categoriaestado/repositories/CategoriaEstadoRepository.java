package com.vantory.categoriaestado.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vantory.categoriaestado.CategoriaEstado;

@Repository
public interface CategoriaEstadoRepository extends JpaRepository<CategoriaEstado, Long> {

	List<CategoriaEstado> findAllByOrderByIdAsc();

}
