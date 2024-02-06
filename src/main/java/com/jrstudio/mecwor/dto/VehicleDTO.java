package com.jrstudio.mecwor.dto;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.jrstudio.mecwor.entities.Customer;

import javax.validation.constraints.NotBlank;

public class VehicleDTO {

    @NotBlank
    private String identificationVehicle, brand, model, color;
    @JsonIdentityReference(alwaysAsId = true)
    private Customer customer;

    public VehicleDTO() {
    }
    public VehicleDTO(@NotBlank String identificationVehicle, @NotBlank String brand, @NotBlank String model, @NotBlank String color, Customer customer) {
        this.identificationVehicle = identificationVehicle;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.customer = customer;
    }

    // GETTERS
    public String getIdentificationVehicle() {
        return identificationVehicle;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }
    public Customer getCustomer() {
        return customer;
    }

    // SETTERS
    public void setIdentificationVehicle(String identificationVehicle) {
        this.identificationVehicle = identificationVehicle;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
