package com.portfolio.mateofernandez.repository;

import com.portfolio.mateofernandez.model.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducacionRepository extends JpaRepository<Educacion, Long>{
    public Optional<Educacion> findByNombreEd (String nombreEd);
    public boolean existsByNombreEd (String nombreEd);
}
