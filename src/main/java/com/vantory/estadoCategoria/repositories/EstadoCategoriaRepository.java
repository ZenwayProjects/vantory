package com.vantory.estadoCategoria.repositories;

import com.vantory.estadoCategoria.EstadoCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoCategoriaRepository extends JpaRepository<EstadoCategoria, Long> {

}
