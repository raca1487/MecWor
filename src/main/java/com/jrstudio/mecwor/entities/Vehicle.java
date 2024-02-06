package com.jrstudio.mecwor.entities;

import javax.persistence.*;

@Entity
@Table(name = "VEHICULOS")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicle;

    private String identificationVehicle, brand, model, color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CUSTOMER", referencedColumnName = "idCustomer", nullable = false)
    private Customer customer;

    // CONSTRUCTORS
    public Vehicle() {
    }
    public Vehicle(String identificationVehicle, String brand, String model, String color) {
        this.identificationVehicle = identificationVehicle;
        this.brand = brand;
        this.model = model;
        this.color = color;
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
