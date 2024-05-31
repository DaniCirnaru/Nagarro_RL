package com.nagarro.remotelearning.model;


import com.nagarro.remotelearning.annotation.Column;
import com.nagarro.remotelearning.annotation.Table;



import com.nagarro.remotelearning.annotation.ForeignKey;
import com.nagarro.remotelearning.annotation.JoinColumn;
import com.nagarro.remotelearning.annotation.OneToOne;

import java.time.LocalDate;

@Table(name = "Student")
public class Student {
    @Column(name = "id", type = "INT", primaryKey = true, autoIncrement = true)
    private int id;

    @Column(name = "name", type = "VARCHAR(255)")
    private String name;

    @Column(name = "cnp", type = "VARCHAR(13)")
    private String cnp;

    @Column(name = "sex", type = "ENUM('MALE', 'FEMALE')")
    private Sex sex;

    @Column(name = "date_of_birth", type = "DATE")
    private LocalDate dateOfBirth;

    @OneToOne
    @ForeignKey(referencedTable = "Address", referencedColumnName = "id")
    @JoinColumn(name = "address_id")
    @Column(name = "address_id", type = "INT")
    private int address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }
}