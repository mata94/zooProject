package com.example.zoo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TipNastanbe {

    @Id
    @GeneratedValue
    private Long id;
    private String naziv;
    public TipNastanbe(){}

    public TipNastanbe(Long id, String naziv) {
        this.id = id;
        this.naziv = naziv;
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

    public void setNaziv(String name) {
        this.naziv = naziv;
    }
}
