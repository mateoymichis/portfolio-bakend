package com.portfolio.mateofernandez.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class AcercaDe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String descripcion;

    public AcercaDe() {
    }

    
    public AcercaDe(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
