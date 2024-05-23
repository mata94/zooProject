package com.example.zoo.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class OblikNastanbe {

    @Id
    @GeneratedValue
    private Long id;

    private String naziv;

    private OblikNastanbe(){}
    public OblikNastanbe(Long id, String naziv) {
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

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
