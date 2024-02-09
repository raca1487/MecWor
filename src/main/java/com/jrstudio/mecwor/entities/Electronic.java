package com.jrstudio.mecwor.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ELECTRONICA")
public class Electronic extends Product {

    private String powerSupply;

    // CONSTRUCTORS
    public Electronic() {
    }
    public Electronic(String nameProduct, String brand, String remarks, float price, long quantity, String powerSupply) {
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
