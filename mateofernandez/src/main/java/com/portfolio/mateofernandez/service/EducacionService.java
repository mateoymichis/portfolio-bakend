package com.portfolio.mateofernandez.service;

import com.portfolio.mateofernandez.model.Educacion;
import com.portfolio.mateofernandez.repository.IEducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class EducacionService {
    @Autowired
    IEducacionRepository rEducacion;
    
    public List<Educacion> list() {
        return rEducacion.findAll();
    }
    
    public Optional<Educacion> getOne(Long id) {
        return rEducacion.findById(id);
    }
    
    public Optional<Educacion> getByNombreEd(String nombreEd) {
        return rEducacion.findByNombreEd(nombreEd);
    }
    
    public void save(Educacion edu) {
        rEducacion.save(edu);
    }
    
    public void delete(Long id) {
        rEducacion.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return rEducacion.existsById(id);
    }
    public boolean existsByNombreEd(String nombreEd) {
        return rEducacion.existsByNombreEd(nombreEd);
    }
}
