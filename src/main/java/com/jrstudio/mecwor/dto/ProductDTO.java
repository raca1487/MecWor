package com.jrstudio.mecwor.dto;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.jrstudio.mecwor.entities.Vehicle;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ProductDTO {

    @NotBlank
    private String nameProduct;
    @NotBlank
    private String brand;
    private String remarks;
    @NotBlank
    private float price;
    private long quantity;

    @JsonIdentityReference(alwaysAsId = true)
    private List<Vehicle> vehicles;

    // CONSTRUCTORS
    public ProductDTO() {
    }
    public ProductDTO(@NotBlank String nameProduct, @NotBlank String brand, String remarks, @NotBlank float price, long quantity) {
        this.nameProduct = nameProduct;
        this.brand = brand;
        this.remarks = (remarks != null) ? remarks : "---";
        this.price = price;
        this.quantity = quantity;
    }

    // GETTERS
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

    // SETTERS
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

}
