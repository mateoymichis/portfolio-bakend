package com.portfolio.mateofernandez.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonaDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String profesion;
    @NotBlank
    private String img;

    public PersonaDto() {
    }

    public PersonaDto(String nombre, String apellido, String profesion, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
        this.img = img;
    }
    
    
}
