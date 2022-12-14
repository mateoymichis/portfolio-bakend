package com.portfolio.mateofernandez.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String descripcion;
    private String img;
    private String link1;
    private String link2;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String img, String link1, String link2) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.link1 = link1;
        this.link2 = link2;
    }

       
    
}
