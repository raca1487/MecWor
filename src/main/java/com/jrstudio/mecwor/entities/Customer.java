package com.jrstudio.mecwor.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLIENTES")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCustomer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCustomer;
    private String name, surname1, surname2, phone, mail;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Vehicle.class, mappedBy = "customer", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Vehicle> vehicles;


    // CONSTRUCTORS
    public Customer() {
    }
    public Customer(String name, String surname1, String surname2, String phone, String mail) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = (surname2 != null) ? surname2 : "---";
        this.phone = phone;
        this.mail = mail;
    }

    // GETTERS
    public Long getIdCustomer() {
        return idCustomer;
    }
    public String getName() {
        return name;
    }
    public String getSurname1() {
        return surname1;
    }
    public String getSurname2() {
        return surname2;
    }
    public String getPhone() {
        return phone;
    }
    public String getMail() {
        return mail;
    }
    public List<Vehicle> getVehicle() {
        return vehicles;
    }

    // SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }
    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void addVehicle(Vehicle vehicle) {
        getVehicle().add(vehicle);
        vehicle.setCustomer(this);
    }

}

