package com.jrstudio.mecwor.entities;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PRODUCTOS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_PRODUCTO", discriminatorType = DiscriminatorType.STRING)
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduct")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String nameProduct, brand, remarks;
    private float price;
    private long quantity;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "REPARACIONES", joinColumns = @JoinColumn(name = "idProduct"), inverseJoinColumns = @JoinColumn(name = "idVehicle"))
    private List<Vehicle> vehicles;

    // CONSTRUCTORS
    public Product() {
    }
    public Product(String nameProduct, String brand, String remarks, float price, long quantity) {
        this.nameProduct = nameProduct;
        this.brand = brand;
        this.remarks = (remarks != null) ? remarks : "---";
        this.price = price;
        this.quantity = quantity;
    }

    // GETTERS
    public Long getIdProduct() {
        return idProduct;
    }
    public String getNameProduct() {
        return nameProduct;
    }
    public String getBrand() {
        return brand;
    }
    public String getRemarks() {
        return remarks;
    }
    public float getPrice() {
        return price;
    }
    public long getQuantity() {
        return quantity;
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
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setQuantity(long quantity) {
        this.quantity = quantity;
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
