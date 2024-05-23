package com.example.zoo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class VrstaIncidenta {
    @Id
    @GeneratedValue
    private long Id;

    private String naziv;

    public VrstaIncidenta()
    {

    }

    public VrstaIncidenta(long id, String naziv) {
        Id = id;
        this.naziv = naziv;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
