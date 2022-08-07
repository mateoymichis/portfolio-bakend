package com.portfolio.mateofernandez.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreEd;
    private String descripcionEd;
    private String fechaIEd;
    private String fechaFEd;

    public Educacion() {
    }

    public Educacion(String nombreEd, String descripcionEd, String fechaIEd, String fechaFEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.fechaIEd = fechaIEd;
        this.fechaFEd = fechaFEd;
    }
    
    
}
