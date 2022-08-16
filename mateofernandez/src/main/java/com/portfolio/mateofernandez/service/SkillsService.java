package com.portfolio.mateofernandez.service;

import com.portfolio.mateofernandez.model.Skills;
import com.portfolio.mateofernandez.repository.ISkillsRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SkillsService {
    @Autowired
    ISkillsRepository rSkills;
    
    public List<Skills> list() {
        return rSkills.findAll();
    }
    
    public Optional<Skills> getOne(Long id) {
        return rSkills.findById(id);
    }
    
    public Optional<Skills> getByNombre(String nombre) {
        return rSkills.findByNombre(nombre);
    }
    
    public void save(Skills skill) {
        rSkills.save(skill);
    }
    
    public void delete(Long id) {
        rSkills.deleteById(id);
    }
    
    public boolean existsById(Long id) {
        return rSkills.existsById(id);
    }
    
    public boolean existsByNombre(String nombre) {
        return rSkills.existsByNombre(nombre);
    }
}
