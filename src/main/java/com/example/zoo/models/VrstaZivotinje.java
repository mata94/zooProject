package com.example.zoo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VrstaZivotinje {

    @Id
    @GeneratedValue
    private Long id;

    private String imeHrv;
    private String imeEng;
    private String imeLat;

    public VrstaZivotinje(){}

    public VrstaZivotinje(Long id, String imeHrv, String imeEng, String imeLat) {
        this.id = id;
        this.imeHrv = imeHrv;
        this.imeEng = imeEng;
        this.imeLat = imeLat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImeHrv() {
        return imeHrv;
    }

    public void setImeHrv(String ime_hrv) {
        this.imeHrv = ime_hrv;
    }

    public String getImeEng() {
        return imeEng;
    }

    public void setImeEng(String ime_eng) {
        this.imeEng = ime_eng;
    }

    public String getImeLat() {
        return imeLat;
    }

    public void setImeLat(String ime_lat) {
        this.imeLat = ime_lat;
    }
}
