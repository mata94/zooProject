package com.example.zoo.models;

import jakarta.persistence.*;

import java.time.LocalTime;
@Entity
public class HranjenjeZivotinje{
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="radnikId")
    private Radnik radnik;
    @ManyToOne
    @JoinColumn(name="zivotinjaId")
    private Zivotinja zivotinja;
    private LocalTime datumHranjenja;
    private boolean nahranjena;

    public HranjenjeZivotinje()
    {

    }




    public HranjenjeZivotinje(Long idHranjenjaZivotinja,
                              Radnik radnik, Zivotinja zivotnja,
                              LocalTime datumHranjenja, boolean nahranjena) {
        this.id = id;
        this.radnik = radnik;
        this.zivotinja = zivotnja;
        this.datumHranjenja = datumHranjenja;
        this.nahranjena = nahranjena;
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

    public Zivotinja getZivotnja() {
        return zivotinja;
    }

    public void setZivotnja(Zivotinja zivotinja) {
        this.zivotinja = zivotinja;
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
