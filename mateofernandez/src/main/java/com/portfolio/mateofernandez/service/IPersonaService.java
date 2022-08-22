package com.portfolio.mateofernandez.service;

import com.portfolio.mateofernandez.model.Persona;
import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<Persona> getPersonas();
    
    public void savePersona (Persona perso);
    
    public void deletePersona (Long id);
    
    public Persona findPersona (Long id);
    
    public Optional<Persona> getOne(Long id);
    
    public boolean existsById (Long id);
       
}
