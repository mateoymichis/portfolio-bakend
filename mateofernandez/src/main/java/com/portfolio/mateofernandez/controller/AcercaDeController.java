package com.portfolio.mateofernandez.controller;

import com.portfolio.mateofernandez.dto.AcercaDeDto;
import com.portfolio.mateofernandez.model.AcercaDe;
import com.portfolio.mateofernandez.security.controller.Mensaje;
import com.portfolio.mateofernandez.service.AcercaDeService;
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
@RequestMapping("acercade")
@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "https://portfolio-f3309.web.app")
public class AcercaDeController {
    @Autowired
    AcercaDeService sAcercaDe;
    
    @GetMapping("/lista")
    public ResponseEntity<List<AcercaDe>> list() {
        List<AcercaDe> list = sAcercaDe.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody AcercaDeDto acercaDeDto) {
        if (StringUtils.isBlank(acercaDeDto.getDescripcion())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        AcercaDe acercaDe = new AcercaDe(acercaDeDto.getDescripcion());
        sAcercaDe.save(acercaDe);

        return new ResponseEntity(new Mensaje("Acerca de agregada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody AcercaDeDto acercaDeDto) {
        if (!sAcercaDe.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(acercaDeDto.getDescripcion())) {
            return new ResponseEntity(new Mensaje("La descripcion es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        AcercaDe acercaDe = sAcercaDe.getOne(id).get();
        acercaDe.setDescripcion(acercaDeDto.getDescripcion());
        
        sAcercaDe.save(acercaDe);

        return new ResponseEntity(new Mensaje("Acerca de actualizada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        if (!sAcercaDe.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        sAcercaDe.delete(id);
        return new ResponseEntity(new Mensaje("Acerca de eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe> getById(@PathVariable("id") Long id) {
        if (!sAcercaDe.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        AcercaDe acercaDe = sAcercaDe.getOne(id).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }
}
