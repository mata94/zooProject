package com.example.zoo.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class PorijekloZivotinje {

    @Id
    @GeneratedValue
    private Long id;

    private String naziv;

    public PorijekloZivotinje(){}

    public PorijekloZivotinje(Long id, String name) {
        this.id = id;
        this.naziv = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
