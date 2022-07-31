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
    
    public boolean existByNombreUsuario (String nombreUsuario) {
        return iUsuarioRepository.existByNombreUsuario(nombreUsuario);
    }
    
    public boolean existByEmail (String email) {
        return iUsuarioRepository.existByEmail(email);
    }
     
    public void save(Usuario usuario) {
        iUsuarioRepository.save(usuario);
   
    }
    
}
