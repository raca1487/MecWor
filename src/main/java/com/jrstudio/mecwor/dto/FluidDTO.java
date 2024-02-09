package com.jrstudio.mecwor.dto;

import javax.validation.constraints.NotBlank;

public class FluidDTO extends ProductDTO {

    @NotBlank
    private String viscosity, quantityFluid;

    // CONSTRUCTORS
    public FluidDTO() {
    }
    public FluidDTO(@NotBlank String nameProduct, @NotBlank String brand, String remarks, @NotBlank float price, @NotBlank long quantity, @NotBlank String viscosity, @NotBlank String quantityFluid) {
        super(nameProduct, brand, remarks, price, quantity);
        this.viscosity = viscosity;
        this.quantityFluid = quantityFluid;
    }

    // GETTERS
    public String getViscosity() {
        return viscosity;
    }
    public String getQuantityFluid() {
        return quantityFluid;
    }

    // SETTERS
    public void setViscosity(String viscosity) {
        this.viscosity = viscosity;
    }
    public void setQuantityFluid(String quantityFluid) {
        this.quantityFluid = quantityFluid;
    }

}
