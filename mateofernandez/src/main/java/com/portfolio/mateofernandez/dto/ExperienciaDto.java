package com.portfolio.mateofernandez.dto;

import java.sql.Date;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienciaDto {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    private String fechaIE;
    private String fechaFE;

    public ExperienciaDto() {
    }

    public ExperienciaDto(String nombreE, String descripcionE, String fechaIE, String fechaFE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.fechaIE = fechaIE;
        this.fechaFE = fechaFE;
    }
    
    
}
