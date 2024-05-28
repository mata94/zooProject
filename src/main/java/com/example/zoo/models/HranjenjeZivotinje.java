package com.example.zoo.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
public class HranjenjeZivotinje{
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="radnikZaZivotinju_id")
    private RadnikZaZivoitnju radnikZaZivoitnju;
    private LocalDate datumHranjenja;
    private LocalTime vrijemeHranjenja;

    private boolean nahranjena;

    public HranjenjeZivotinje()
    {

    }

    public HranjenjeZivotinje(RadnikZaZivoitnju radnikZaZivoitnju, LocalDate datumHranjenja) {
        this.radnikZaZivoitnju = radnikZaZivoitnju;
        this.datumHranjenja = datumHranjenja;
        this.nahranjena = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RadnikZaZivoitnju getRadnikZaZivoitnju() {
        return radnikZaZivoitnju;
    }

    public void setRadnikZaZivoitnju(RadnikZaZivoitnju radnikZaZivoitnju) {
        this.radnikZaZivoitnju = radnikZaZivoitnju;
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
