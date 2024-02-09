package com.jrstudio.mecwor.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Access(value = AccessType.FIELD)
@DiscriminatorValue("NEUMATICO")
public class Tyre extends Product {

    private String size, loadIndex;
    private Long diameter;

    // CONSTRUCTORS
    public Tyre() {
        super();
    }
    public Tyre(String nameProduct, String brand, String remarks, float price, long quantity, String size, Long diameter, String loadIndex) {
        super(nameProduct, brand, remarks, price, quantity);
        this.size = size;
        this.diameter = diameter;
        this.loadIndex = loadIndex;
    }

    // GETTERS
    public String getSize() {
        return size;
    }
    public Long getDiameter() {
        return diameter;
    }
    public String getLoadIndex() {
        return loadIndex;
    }

    // SETTERS
    public void setSize(String size) {
        this.size = size;
    }
    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }
    public void setLoadIndex(String loadIndex) {
        this.loadIndex = loadIndex;
    }

}
