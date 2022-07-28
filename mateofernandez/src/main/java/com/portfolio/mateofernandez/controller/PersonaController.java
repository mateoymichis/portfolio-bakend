package com.portfolio.mateofernandez.controller;

import com.portfolio.mateofernandez.model.Persona;
import com.portfolio.mateofernandez.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping ("/personas/ver")
    public List<Persona> getPersonas() {
        return interPersona.getPersonas();
    }
    
    @PostMapping ("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "La persona fue creada correctamente";
    }
    
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona (@PathVariable Long id) {
        interPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PutMapping ("/personas/editar/{id}")
    public Persona editPersona (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("apellido") String nuevoApellido,
                                @RequestParam ("profesion") String nuevaProfesion,
                                @RequestParam ("img") String nuevaImg) {
        Persona perso = interPersona.findPersona(id);
        
        perso.setNombre(nuevoNombre);
        perso.setApellido(nuevoApellido);
        perso.setProfesion(nuevaProfesion);
        perso.setImg(nuevaImg);
        
        interPersona.savePersona(perso);
        
        return perso;
    }
    
}
