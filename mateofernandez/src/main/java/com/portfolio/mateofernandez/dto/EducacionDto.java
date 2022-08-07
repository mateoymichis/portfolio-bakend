package com.portfolio.mateofernandez.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EducacionDto {
    @NotBlank
    private String nombreEd;
    @NotBlank
    private String descripcionEd;
    private String fechaIEd;
    private String fechaFEd;

    public EducacionDto() {
    }

    public EducacionDto(String nombreEd, String descripcionEd, String fechaIEd, String fechaFEd) {
        this.nombreEd = nombreEd;
        this.descripcionEd = descripcionEd;
        this.fechaIEd = fechaIEd;
        this.fechaFEd = fechaFEd;
    }
    
    
}
