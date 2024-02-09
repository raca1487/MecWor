package com.jrstudio.mecwor.entities;

import com.jrstudio.mecwor.enums.Type;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ACCESORIO")
public class Accessory extends Product {

    private String compatibilty, size, voltage;

    // CONSTRUCTORS
    public Accessory() {
    }
    public Accessory(String nameProduct, String brand, String remarks, float price, long quantity, String compatibilty, String size, String voltage) {
        super(nameProduct, brand, remarks, price, quantity);
        this.compatibilty = compatibilty;
        this.size = size;
        this.voltage = voltage;
    }

    // GETTERS
    public String getCompatibilty() {
        return compatibilty;
    }
    public String getSize() {
        return size;
    }
    public String getVoltage() {
        return voltage;
    }

    // SETTERS
    public void setCompatibilty(String compatibilty) {
        this.compatibilty = compatibilty;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

}
