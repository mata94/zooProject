package com.example.zoo.models;

import jakarta.persistence.*;

@Entity
public class Posjete {

    @Id
    @GeneratedValue
    private Long Id;
    @ManyToOne
    @JoinColumn(name="radnik_id")
    private Radnik radnik;
    private String nazivGrupe;

    public Posjete(){}

    public Posjete(Long id, Radnik radnik, String nazivGrupe) {
        Id = id;
        this.radnik = radnik;
        this.nazivGrupe = nazivGrupe;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public String getNazivGrupe() {
        return nazivGrupe;
    }

    public void setNazivGrupe(String nazivGrupe) {
        this.nazivGrupe = nazivGrupe;
    }
}
