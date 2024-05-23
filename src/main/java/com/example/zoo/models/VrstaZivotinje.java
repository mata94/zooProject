package com.example.zoo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VrstaZivotinje {

    @Id
    @GeneratedValue
    private Long id;

    private String ime_hrv;
    private String ime_eng;
    private String ime_lat;

    public VrstaZivotinje(){}

    public VrstaZivotinje(Long id, String ime_hrv, String ime_eng, String ime_lat) {
        this.id = id;
        this.ime_hrv = ime_hrv;
        this.ime_eng = ime_eng;
        this.ime_lat = ime_lat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme_hrv() {
        return ime_hrv;
    }

    public void setIme_hrv(String ime_hrv) {
        this.ime_hrv = ime_hrv;
    }

    public String getIme_eng() {
        return ime_eng;
    }

    public void setIme_eng(String ime_eng) {
        this.ime_eng = ime_eng;
    }

    public String getIme_lat() {
        return ime_lat;
    }

    public void setIme_lat(String ime_lat) {
        this.ime_lat = ime_lat;
    }
}
