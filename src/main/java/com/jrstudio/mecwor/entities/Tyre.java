package com.jrstudio.mecwor.entities;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Access(value = AccessType.FIELD)
@DiscriminatorValue("NEUMATICO")
public class Tyre extends Product {
    private Long width, serie, diameter;
    private String loadIndex;

    // CONSTRUCTORS
    public Tyre() {
        super();
    }
    public Tyre(String nameProduct, String brand, String remarks, float price, long quantity, Long width, Long serie, Long diameter, String loadIndex) {
        super(nameProduct, brand, remarks, price, quantity);
        this.width = width;
        this.serie = serie;
        this.diameter = diameter;
        this.loadIndex = loadIndex;
    }

    // GETTERS
    public Long getWidth() {
        return width;
    }
    public Long getSerie() {
        return serie;
    }
    public Long getDiameter() {
        return diameter;
    }
    public String getLoadIndex() {
        return loadIndex;
    }

    // SETTERS
    public void setWidth(Long width) {
        this.width = width;
    }
    public void setSerie(Long serie) {
        this.serie = serie;
    }
    public void setDiameter(Long diameter) {
        this.diameter = diameter;
    }
    public void setLoadIndex(String loadIndex) {
        this.loadIndex = loadIndex;
    }

}
