package com.jrstudio.mecwor.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "vehicles")
    private List<Product> products;

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
    public List<Product> getProducts() {
        return products;
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
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        getProducts().add(product);
        product.getVehicles().add(this);
    }

}
