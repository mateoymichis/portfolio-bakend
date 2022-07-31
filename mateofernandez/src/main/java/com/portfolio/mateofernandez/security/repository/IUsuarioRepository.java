package com.portfolio.mateofernandez.security.repository;

import com.portfolio.mateofernandez.security.entity.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
    
    boolean existByNombreUsuario (String nombreUsuario);
    boolean existByEmail (String email);
}
