package com.portfolio.mateofernandez.security.service;

import com.portfolio.mateofernandez.security.entity.Usuario;
import com.portfolio.mateofernandez.security.repository.IUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iUsuarioRepository;
    
    public Optional<Usuario> getByNombreUsuario (String nombreUsuario) {
        return iUsuarioRepository.findByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByNombreUsuario (String nombreUsuario) {
        return iUsuarioRepository.existsByNombreUsuario(nombreUsuario);
    }
    
    public boolean existsByEmail (String email) {
        return iUsuarioRepository.existsByEmail(email);
    }
     
    public void save(Usuario usuario) {
        iUsuarioRepository.save(usuario);
   
    }
    
}
