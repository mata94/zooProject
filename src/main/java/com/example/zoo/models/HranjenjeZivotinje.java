package com.example.zoo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
public class HranjenjeZivotinje{
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne()
    @JoinColumn(name = "radnik_id")
    private Radnik radnik;

    @ManyToOne()
    @JoinColumn(name = "zivotinja_id")
    private Zivotinja zivotinja;
    private LocalDate datumHranjenja;
    private LocalTime vrijemeHranjenja;

    private boolean nahranjena;

    public HranjenjeZivotinje()
    {

    }

    public HranjenjeZivotinje(Zivotinja zivotinja,Radnik radnik,LocalDate datumHranjenja) {
        this.zivotinja = zivotinja;
        this.radnik = radnik;
        this.datumHranjenja = datumHranjenja;
        this.nahranjena = false;
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

    public LocalDate getDatumHranjenja() {
        return datumHranjenja;
    }

    public void setDatumHranjenja(LocalDate datumHranjenja) {
        this.datumHranjenja = datumHranjenja;
    }

    public LocalTime getVrijemeHranjenja() {
        return vrijemeHranjenja;
    }

    public void setVrijemeHranjenja(LocalTime vrijemeHranjenja) {
        this.vrijemeHranjenja = vrijemeHranjenja;
    }

    public boolean isNahranjena() {
        return nahranjena;
    }

    public void setNahranjena(boolean nahranjena) {
        this.nahranjena = nahranjena;
    }
}
