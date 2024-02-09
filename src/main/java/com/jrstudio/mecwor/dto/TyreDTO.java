package com.jrstudio.mecwor.dto;

import javax.validation.constraints.NotBlank;

public class TyreDTO extends ProductDTO {

    @NotBlank
    private String brand, size, loadIndex;
    @NotBlank
    private Long diameter;

    // CONSTRUCTORS
    public TyreDTO() {
        super();
    }
    public TyreDTO(@NotBlank String nameProduct, @NotBlank String brand, String remarks, @NotBlank float price, @NotBlank long quantity, @NotBlank String size, @NotBlank Long diameter, @NotBlank String loadIndex) {
        super(nameProduct, brand, remarks, price, quantity);
        this.brand = brand;
        this.size = size;
        this.diameter = diameter;
        this.loadIndex = loadIndex;
    }

    // GETTERS
    public String getBrand() {
        return brand;
    }
    public String getSize() {
        return size;
    }
    public Long getDiameter() {
        return diameter;
    }
    public String getLoadIndex() {
        return loadIndex;
    }

    // SETTERS
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }
    public void setLoadIndex(String loadIndex) {
        this.loadIndex = loadIndex;
    }

}
