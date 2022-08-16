package com.portfolio.mateofernandez.controller;

import com.portfolio.mateofernandez.dto.SkillsDto;
import com.portfolio.mateofernandez.model.Skills;
import com.portfolio.mateofernandez.security.controller.Mensaje;
import com.portfolio.mateofernandez.service.SkillsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skills")
@CrossOrigin (origins = "http://localhost:4200")
public class SkillsController {
    @Autowired
    SkillsService sSkills;
    
    @GetMapping ("/lista")
    public ResponseEntity<List <Skills>> list() {
        List<Skills> list = sSkills.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping ("/create")
    public ResponseEntity<?> create (@RequestBody SkillsDto skillsDto) {
        if(StringUtils.isBlank(skillsDto.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sSkills.existsByNombre(skillsDto.getNombre())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
                
        Skills skill = new Skills(skillsDto.getNombre(), skillsDto.getPorcentaje(), skillsDto.getImg());
        sSkills.save(skill);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody SkillsDto skillsDto) {
        if(!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if(sSkills.existsByNombre(skillsDto.getNombre()) && sSkills.getByNombre(skillsDto.getNombre()).get().getId() != id) {
            return new ResponseEntity (new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(skillsDto.getNombre())) {
            return new ResponseEntity (new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skill = sSkills.getOne(id).get();
        skill.setNombre(skillsDto.getNombre());
        skill.setPorcentaje(skillsDto.getPorcentaje());
        skill.setImg(skillsDto.getImg());
                
        sSkills.save(skill);
        
        return new ResponseEntity (new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if(!sSkills.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        sSkills.delete(id);
        return new ResponseEntity (new Mensaje("Skill eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id") Long id){
        if(!sSkills.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skills skill = sSkills.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
}
