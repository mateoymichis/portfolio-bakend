
package com.portfolio.mateofernandez.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProyectoDto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    @NotBlank
    private String link1;
    @NotBlank
    private String link2;

    public ProyectoDto() {
    }

    public ProyectoDto(String nombre, String descripcion, String img, String link1, String link2) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.img = img;
        this.link1 = link1;
        this.link2 = link2;
    }

       
    
}
