package com.cardealer.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic
    private String name;

    @Basic
    private LocalDate birth_date;

    @Basic
    private boolean is_young_driver;

    public Customer() {
    }

    public Customer(String name, LocalDate birth_date, boolean is_young_driver) {
        this.name = name;
        this.birth_date = birth_date;
        this.is_young_driver = is_young_driver;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public boolean isIs_young_driver() {
        return is_young_driver;
    }

    public void setIs_young_driver(boolean is_young_driver) {
        this.is_young_driver = is_young_driver;
    }
}