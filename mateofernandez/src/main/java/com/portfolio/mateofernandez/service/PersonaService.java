package com.portfolio.mateofernandez.service;

import com.portfolio.mateofernandez.model.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.portfolio.mateofernandez.repository.IPersonaRepository;

@Service
public class PersonaService implements IPersonaService{
    @Autowired
    private IPersonaRepository persoRepository;

    @Override
    public List<Persona> getPersonas() {
        List<Persona> listaPersonas = persoRepository.findAll();
        return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        persoRepository.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = persoRepository.findById(id).orElse(null);
        return perso;
    }
    
}
