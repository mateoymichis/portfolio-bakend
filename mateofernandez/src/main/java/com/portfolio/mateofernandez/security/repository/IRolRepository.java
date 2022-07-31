package com.portfolio.mateofernandez.security.repository;

import com.portfolio.mateofernandez.security.entity.Rol;
import com.portfolio.mateofernandez.security.enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol, Long>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
