package com.example.zoo.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalTime;

public class HranjenjeZivotinje {
    private Long idHranjenjaZivotinja;
    @ManyToOne
    @JoinColumn(name="radnikId")
    private Radnik radnik;
    @ManyToOne
    @JoinColumn(name="zivotinjaId")
    private Zivotnja zivotnja;
    private LocalTime datumHranjenja;
    private boolean nahranjena;

    private HranjenjeZivotinje()
    {

    }

    public HranjenjeZivotinje(Long idHranjenjaZivotinja,
                              Radnik radnik, Zivotnja zivotnja,
                              LocalTime datumHranjenja, boolean nahranjena) {
        this.idHranjenjaZivotinja = idHranjenjaZivotinja;
        this.radnik = radnik;
        this.zivotnja = zivotnja;
        this.datumHranjenja = datumHranjenja;
        this.nahranjena = nahranjena;
    }

    public Long getIdHranjenjaZivotinja() {
        return idHranjenjaZivotinja;
    }

    public void setIdHranjenjaZivotinja(Long idHranjenjaZivotinja) {
        this.idHranjenjaZivotinja = idHranjenjaZivotinja;
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

    public LocalTime getDatumHranjenja() {
        return datumHranjenja;
    }

    public void setDatumHranjenja(LocalTime datumHranjenja) {
        this.datumHranjenja = datumHranjenja;
    }

    public boolean isNahranjena() {
        return nahranjena;
    }

    public void setNahranjena(boolean nahranjena) {
        this.nahranjena = nahranjena;
    }
}
