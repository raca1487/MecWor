package com.jrstudio.mecwor.dto;

import javax.validation.constraints.NotBlank;

public class CustomerDTO {

    @NotBlank
    private String name, surname1, surname2, phone, mail;

    public CustomerDTO() {
    }
    public CustomerDTO(@NotBlank String name, @NotBlank String surname1, @NotBlank String surname2, @NotBlank String phone, @NotBlank String mail) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = (surname2 != null) ? surname2 : "";
        this.phone = phone;
        this.mail = mail;
    }

    // GETTERS
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

}
