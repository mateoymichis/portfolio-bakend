package com.portfolio.mateofernandez.repository;

import com.portfolio.mateofernandez.model.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IProyectoRepository extends JpaRepository<Proyecto, Long>{
    public Optional<Proyecto> findByNombre (String nombre);
    public boolean existsByNombre (String nombre);
}
