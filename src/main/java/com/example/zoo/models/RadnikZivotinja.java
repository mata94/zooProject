package com.example.zoo.models;

import jakarta.persistence.*;

@Entity
public class RadnikZivotinja {

    @Id
    @GeneratedValue
    private Long id;
    private String opis;
    @ManyToOne()
    @JoinColumn(name="radnik_id")
    private Radnik radnik;
    @ManyToOne()
    @JoinColumn(name="zivotinja_id")
    private Zivotnja zivotnja;
    private float cijena;

    public RadnikZivotinja(){}

    public RadnikZivotinja(Long id, String opis, Radnik radnik, Zivotnja zivotnja, float cijena) {
        this.id = id;
        this.opis = opis;
        this.radnik = radnik;
        this.zivotnja = zivotnja;
        this.cijena = cijena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }

    public Zivotnja getZivotnja() {
        return zivotnja;
    }

    public void setZivotnja(Zivotnja zivotnja) {
        this.zivotnja = zivotnja;
    }

    public float getCijena() {
        return cijena;
    }

    public void setCijena(float cijena) {
        this.cijena = cijena;
    }
}
