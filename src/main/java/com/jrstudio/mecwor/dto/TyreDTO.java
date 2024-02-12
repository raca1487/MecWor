package com.jrstudio.mecwor.dto;

import javax.validation.constraints.NotBlank;

public class TyreDTO extends ProductDTO {
    @NotBlank
    private Long width, serie, diameter;
    @NotBlank
    private String loadIndex;

    // CONSTRUCTORS
    public TyreDTO() {
        super();
    }
    public TyreDTO(@NotBlank String nameProduct, @NotBlank String brand, String remarks, @NotBlank float price, @NotBlank long quantity, @NotBlank Long width, @NotBlank Long serie, @NotBlank Long diameter, @NotBlank String loadIndex) {
        super(nameProduct, brand, remarks, price, quantity);
        this.width = width;
        this.serie = serie;
        this.diameter = diameter;
        this.loadIndex = loadIndex;
    }

    // GETTERS
    public Long getWidth() {
        return width;
    }
    public Long getSerie() {
        return serie;
    }
    public Long getDiameter() {
        return diameter;
    }
    public String getLoadIndex() {
        return loadIndex;
    }

    // SETTERS
    public void setWidth(Long width) {
        this.width = width;
    }
    public void setSerie(Long serie) {
        this.serie = serie;
    }
    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }
    public void setLoadIndex(String loadIndex) {
        this.loadIndex = loadIndex;
    }

}
