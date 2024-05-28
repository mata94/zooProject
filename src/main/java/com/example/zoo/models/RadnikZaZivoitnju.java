package com.example.zoo.models;

import jakarta.persistence.*;

@Entity
public class RadnikZaZivoitnju {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "radnik_id")
    private Radnik radnik;

    @ManyToOne()
    @JoinColumn(name = "zivotinja_id")
    private Zivotinja zivotinja;

    public RadnikZaZivoitnju(){}

    public RadnikZaZivoitnju(Long id, Radnik radnik, Zivotinja zivotinja) {
        this.id = id;
        this.radnik = radnik;
        this.zivotinja = zivotinja;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Zivotinja getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(Zivotinja zivotinja) {
        this.zivotinja = zivotinja;
    }
}
