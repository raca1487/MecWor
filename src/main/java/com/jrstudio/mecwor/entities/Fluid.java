package com.jrstudio.mecwor.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FLUIDO/LIQUIDO")
public class Fluid extends Product {

    private String viscosity, quantityFluid;

    // CONSTRUCTORS
    public Fluid() {
    }
    public Fluid(String nameProduct, String brand, String remarks, float price, long quantity, String viscosity, String quantityFluid) {
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
