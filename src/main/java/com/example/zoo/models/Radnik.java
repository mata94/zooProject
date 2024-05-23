package com.example.zoo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Radnik {

    @Id
    @GeneratedValue
    private Long id;
    private String ime;
    private String prezime;
    @ManyToOne
    @JoinColumn(name = "kvalifikacija_id")
    private Kvalifikacija kvalifikacija;
    public Radnik(){}

    public Radnik(Long id, String ime, String prezime, Kvalifikacija kvalifikacija) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.kvalifikacija = kvalifikacija;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public Kvalifikacija getKvalifikacija() {
        return kvalifikacija;
    }

    public void setKvalifikacija(Kvalifikacija kvalifikacija) {
        this.kvalifikacija = kvalifikacija;
    }
}
