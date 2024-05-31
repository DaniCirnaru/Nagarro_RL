package com.nagarro.remotelearning.model;

import com.nagarro.remotelearning.annotation.Column;
import com.nagarro.remotelearning.annotation.Table;

@Table(name = "address")
public class Address {
    @Column(name = "id", type = "INT", primaryKey = true, autoIncrement = true)
    private int id;

    @Column(name = "street", type = "VARCHAR(255)")
    private String street;

    @Column(name = "number", type = "INT")
    private int number;

    @Column(name = "city", type = "VARCHAR(255)")
    private String city;

    @Column(name = "country", type = "VARCHAR(255)")
    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
