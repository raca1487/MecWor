package com.jrstudio.mecwor.dto;

import javax.validation.constraints.NotBlank;

public class ElectronicDTO extends ProductDTO {

    @NotBlank
    private String powerSupply;

    // CONSTRUCTORS
    public ElectronicDTO() {
    }
    public ElectronicDTO(@NotBlank String nameProduct, @NotBlank String brand, String remarks, @NotBlank float price, @NotBlank long quantity, @NotBlank String powerSupply) {
        super(nameProduct, brand, remarks, price, quantity);
        this.powerSupply = powerSupply;
    }

    // GETTERS
    public String getPowerSupply() {
        return powerSupply;
    }

    // SETTERS
    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

}
