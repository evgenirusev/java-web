package com.cardealer.entities;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String make;

    @Basic
    private String model;

    @Basic
    private Long traveled_distance;

    public Car() {
    }

    public Car(String make, String model, Long traveled_distance) {
        this.make = make;
        this.model = model;
        this.traveled_distance = traveled_distance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getTraveled_distance() {
        return traveled_distance;
    }

    public void setTraveled_distance(Long traveled_distance) {
        this.traveled_distance = traveled_distance;
    }
}
