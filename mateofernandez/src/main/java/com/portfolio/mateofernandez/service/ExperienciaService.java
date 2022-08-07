package com.portfolio.mateofernandez.service;

import com.portfolio.mateofernandez.model.Experiencia;
import com.portfolio.mateofernandez.repository.IExperienciaRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ExperienciaService {
    @Autowired
    IExperienciaRepository rExperiencia;
    
    public List<Experiencia> list() {
        return rExperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(Long id) {
        return rExperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByNombreE(String nombreE) {
        return rExperiencia.findByNombreE(nombreE);
    }
    
    public void save(Experiencia exp) {
        rExperiencia.save(exp);
    }
    
    public void delete(Long id) {
        rExperiencia.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return rExperiencia.existsById(id);
    }
    public boolean existsByNombreE(String nombreE) {
        return rExperiencia.existsByNombreE(nombreE);
    }
}
