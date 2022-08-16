package com.portfolio.mateofernandez.service;

import com.portfolio.mateofernandez.model.Proyecto;
import com.portfolio.mateofernandez.repository.IProyectoRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProyectoService {
    @Autowired
    IProyectoRepository rProyecto;
    
    public List<Proyecto> list() {
        return rProyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(Long id) {
        return rProyecto.findById(id);
    }
    
    public Optional<Proyecto> getByNombre(String nombre) {
        return rProyecto.findByNombre(nombre);
    }
    
    public void save(Proyecto proyecto) {
        rProyecto.save(proyecto);
    }
    
    public void delete(Long id) {
        rProyecto.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return rProyecto.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return rProyecto.existsByNombre(nombre);
    }
}
