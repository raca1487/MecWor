package com.jrstudio.mecwor.dto;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.jrstudio.mecwor.entities.Vehicle;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ProductDTO {

    @NotBlank
    private String nameProduct;
    private String remarks;
    @NotBlank
    private double price;

    @JsonIdentityReference(alwaysAsId = true)
    private List<Vehicle> vehicles;

    // CONSTRUCTORS
    public ProductDTO() {
    }
    public ProductDTO(@NotBlank String nameProduct, String remarks, @NotBlank double price) {
        this.nameProduct = nameProduct;
        this.remarks = (remarks != null) ? remarks : "---";
        this.price = price;
    }

    // GETTERS
    public String getNameProduct() {
        return nameProduct;
    }
    public String getRemarks() {
        return remarks;
    }
    public double getPrice() {
        return price;
    }

    // SETTERS
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public void setPrice(double price) {
        this.price = price;
    }

}
