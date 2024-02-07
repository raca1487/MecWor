package com.jrstudio.mecwor.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCTOS")
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduct")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String nameProduct, remarks;
    private double price;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "REPARACIONES", joinColumns = @JoinColumn(name = "idProduct"), inverseJoinColumns = @JoinColumn(name = "idVehicle"))
    private List<Vehicle> vehicles;

    // CONSTRUCTORS
    public Product() {
    }
    public Product(String nameProduct, String remarks, double price) {
        this.nameProduct = nameProduct;
        this.remarks = (remarks != null) ? remarks : "---";
        this.price = price;
    }

    // GETTERS
    public Long getIdProduct() {
        return idProduct;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public String getRemarks() {
        return remarks;
    }
    public double getPrice() {
        return price;
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    // SETTERS
    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        getVehicles().add(vehicle);
        vehicle.getProducts().add(this);
    }
    public void removeVehicle(Vehicle vehicle) {
        getVehicles().remove(vehicle);
        vehicle.getProducts().remove(this);
    }

}
