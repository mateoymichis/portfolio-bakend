package com.portfolio.mateofernandez.controller;

import com.portfolio.mateofernandez.dto.PersonaDto;
import com.portfolio.mateofernandez.model.Persona;
import com.portfolio.mateofernandez.security.controller.Mensaje;
import com.portfolio.mateofernandez.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://portfolio-f3309.web.app")
public class PersonaController {
    @Autowired
    private IPersonaService interPersona;
    
    @GetMapping ("/personas/ver")
    public List<Persona> getPersonas() {
        return interPersona.getPersonas();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/personas/crear")
    public String savePersona(@RequestBody Persona perso){
        interPersona.savePersona(perso);
        return "La persona fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/personas/borrar/{id}")
    public String deletePersona (@PathVariable Long id) {
        interPersona.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/personas/editar/{id}")
    public ResponseEntity<?> editPersona (@PathVariable("id") Long id, @RequestBody PersonaDto personaDto) {
        Persona perso = interPersona.getOne(id).get();
        
        perso.setNombre(personaDto.getNombre());
        perso.setApellido(personaDto.getApellido());
        perso.setProfesion(personaDto.getProfesion());
        perso.setImg(personaDto.getImg());
        
        interPersona.savePersona(perso);
        
        return new ResponseEntity (new Mensaje("Persona actualizada"), HttpStatus.OK);
    }
    
    @GetMapping ("/personas/ver/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        if(!interPersona.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Persona persona = interPersona.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
}
