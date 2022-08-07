package com.portfolio.mateofernandez.repository;

import com.portfolio.mateofernandez.model.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia,Long>{
    public Optional<Experiencia> findByNombreE (String nombreE);
    public boolean existsByNombreE (String nombreE);
}
