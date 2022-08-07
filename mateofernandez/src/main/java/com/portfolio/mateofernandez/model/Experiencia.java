package com.portfolio.mateofernandez.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreE;
    private String descripcionE;
    private String fechaIE;
    private String fechaFE;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE, String fechaIE, String fechaFE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaIE = fechaIE;
        this.fechaFE = fechaFE;
    }
    
    
}
