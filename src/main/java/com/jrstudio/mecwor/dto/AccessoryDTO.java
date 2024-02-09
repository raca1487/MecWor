package com.jrstudio.mecwor.dto;

import javax.validation.constraints.NotBlank;

public class AccessoryDTO extends ProductDTO {

    private String compatibilty, size, voltage;

    // CONSTRUCTORS
    public AccessoryDTO() {
    }
    public AccessoryDTO(@NotBlank String nameProduct, @NotBlank String brand, String remarks, @NotBlank float price, @NotBlank long quantity, String compatibilty, String size, String voltage) {
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
