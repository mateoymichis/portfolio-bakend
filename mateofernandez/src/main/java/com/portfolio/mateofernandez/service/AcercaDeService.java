package com.portfolio.mateofernandez.service;

import com.portfolio.mateofernandez.model.AcercaDe;
import com.portfolio.mateofernandez.repository.IAcercaDeRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AcercaDeService {
    @Autowired
    IAcercaDeRepository rAcercaDe;
    
    public List<AcercaDe> list() {
        return rAcercaDe.findAll();
    }
    
    public Optional<AcercaDe> getOne(Long id) {
        return rAcercaDe.findById(id);
    }
    
    public Optional<AcercaDe> getByDescripcion(String descripcion) {
        return rAcercaDe.findByDescripcion(descripcion);
    }
    
    public void save(AcercaDe acercaDe) {
        rAcercaDe.save(acercaDe);
    }
    
    public void delete(Long id) {
        rAcercaDe.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return rAcercaDe.existsById(id);
    }
    public boolean existsByDescripcion(String descripcion) {
        return rAcercaDe.existsByDescripcion(descripcion);
    }
}
