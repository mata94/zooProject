package com.example.zoo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Zivotinja {

    @Id
    @GeneratedValue
    private Long id;

    private String naziv;
    private Integer indentifikator;
    private boolean skupZivotinja;
    private Integer brojZivotnja;
    @ManyToOne
    @JoinColumn(name = "nastanba_id")
    private Nastanba nastanba;
    private boolean postojanjeZivotinje;
    private Date dolazakZivotinje;

    @ManyToOne
    @JoinColumn(name = "vrstaZivotinje")
    private VrstaZivotinje vrstaZivotinje;
    @ManyToOne
    @JoinColumn(name = "porijekloZivotinjeId")
    private PorijekloZivotinje porijekloZivotinje;

    public Zivotinja()
    {

    }

    public Zivotinja(Long id, String naziv, Integer indentifikator, boolean skupZivotinja, Integer brojZivotnja, Nastanba nastanba, boolean postojanjeZivotinje, Date dolazakZivotinje, VrstaZivotinje vrstaZivotinje, PorijekloZivotinje porijekloZivotinje) {
        this.id = id;
        this.naziv = naziv;
        this.indentifikator = indentifikator;
        this.skupZivotinja = skupZivotinja;
        this.brojZivotnja = brojZivotnja;
        this.nastanba = nastanba;
        this.postojanjeZivotinje = postojanjeZivotinje;
        this.dolazakZivotinje = dolazakZivotinje;
        this.vrstaZivotinje = vrstaZivotinje;
        this.porijekloZivotinje = porijekloZivotinje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getIndentifikator() {
        return indentifikator;
    }

    public void setIndentifikator(Integer indentifikator) {
        this.indentifikator = indentifikator;
    }

    public boolean isSkupZivotinja() {
        return skupZivotinja;
    }

    public void setSkupZivotinja(boolean skupZivotinja) {
        this.skupZivotinja = skupZivotinja;
    }

    public Integer getBrojZivotnja() {
        return brojZivotnja;
    }

    public void setBrojZivotnja(Integer brojZivotnja) {
        this.brojZivotnja = brojZivotnja;
    }

    public Nastanba getNastanba() {
        return nastanba;
    }

    public void setNastanba(Nastanba nastanba) {
        this.nastanba = nastanba;
    }

    public boolean isPostojanjeZivotinje() {
        return postojanjeZivotinje;
    }

    public void setPostojanjeZivotinje(boolean postojanjeZivotinje) {
        this.postojanjeZivotinje = postojanjeZivotinje;
    }

    public Date getDolazakZivotinje() {
        return dolazakZivotinje;
    }

    public void setDolazakZivotinje(Date dolazakZivotinje) {
        this.dolazakZivotinje = dolazakZivotinje;
    }

    public VrstaZivotinje getVrstaZivotinje() {
        return vrstaZivotinje;
    }

    public void setVrstaZivotinje(VrstaZivotinje vrstaZivotinje) {
        this.vrstaZivotinje = vrstaZivotinje;
    }

    public PorijekloZivotinje getPorijekloZivotinje() {
        return porijekloZivotinje;
    }

    public void setPorijekloZivotinje(PorijekloZivotinje porijekloZivotinje) {
        this.porijekloZivotinje = porijekloZivotinje;
    }
}
