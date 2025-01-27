package com.astinil.car.carcurdoperations.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID")
    private Integer id;
    @Column(name = "CAR_NAME")
    private String name;
    @Column(name = "CAR_BRAND")
    private String brand;
    @Column(name = "CAR_MODEL")
    private String model;
    @Column(name = "CAR_COLOR")
    private String color;
    @Column(name = "CAR_PRICE")
    private String price;
    @Column(name = "CAR_TYPE")
    private String type;

    public Car() {
    }

    public Car(Integer id, String name, String brand, String model, String color, String price, String type) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
