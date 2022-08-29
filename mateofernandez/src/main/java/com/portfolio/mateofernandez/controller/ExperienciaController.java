package com.portfolio.mateofernandez.controller;

import com.portfolio.mateofernandez.dto.ExperienciaDto;
import com.portfolio.mateofernandez.model.Experiencia;
import com.portfolio.mateofernandez.security.controller.Mensaje;
import com.portfolio.mateofernandez.service.ExperienciaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("explab")
@CrossOrigin (origins = "https://portfolio-f3309.web.app")
public class ExperienciaController {
    @Autowired
    ExperienciaService experienciaService;
    
    @GetMapping ("/lista")
    public ResponseEntity<List <Experiencia>> list() {
        List<Experiencia> list = experienciaService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/create")
    public ResponseEntity<?> create (@RequestBody ExperienciaDto experienciaDto) {
        if(StringUtils.isBlank(experienciaDto.getNombreE())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
                
        Experiencia experiencia = new Experiencia(experienciaDto.getNombreE(), experienciaDto.getDescripcionE(), experienciaDto.getFechaIE(), experienciaDto.getFechaFE());
        experienciaService.save(experiencia);
        
        return new ResponseEntity(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody ExperienciaDto experienciaDto) {
        if(!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        if(StringUtils.isBlank(experienciaDto.getNombreE())) {
            return new ResponseEntity (new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Experiencia experiencia = experienciaService.getOne(id).get();
        experiencia.setNombreE(experienciaDto.getNombreE());
        experiencia.setDescripcionE(experienciaDto.getDescripcionE());
        experiencia.setFechaIE(experienciaDto.getFechaIE());
        experiencia.setFechaFE(experienciaDto.getFechaFE());
        
        experienciaService.save(experiencia);
        
        return new ResponseEntity (new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if(!experienciaService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        
        experienciaService.delete(id);
        return new ResponseEntity (new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id){
        if(!experienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = experienciaService.getOne(id).get();
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
}
