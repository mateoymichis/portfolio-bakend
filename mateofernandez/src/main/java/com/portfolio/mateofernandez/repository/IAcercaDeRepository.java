package com.portfolio.mateofernandez.repository;

import com.portfolio.mateofernandez.model.AcercaDe;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcercaDeRepository extends JpaRepository<AcercaDe, Long> {
    public Optional<AcercaDe> findByDescripcion (String descripcion);
    public boolean existsByDescripcion (String descripcion);
}
