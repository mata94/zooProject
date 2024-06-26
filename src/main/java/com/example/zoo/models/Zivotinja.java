package com.example.zoo.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Zivotinja {

    @Id
    @GeneratedValue
    private Long id;

    private String naziv;


    private Integer identifikator;
    private boolean skupZivotinja;
    private Integer brojZivotinja;
    @ManyToOne
    @JoinColumn(name = "nastanba_id")
    private Nastanba nastanba;
    private boolean postojanjeZivotinje;

    @ManyToOne
    @JoinColumn(name = "vrstaZivotinje")
    private VrstaZivotinje vrstaZivotinje;
    @ManyToOne
    @JoinColumn(name = "porijekloZivotinjeId")
    private PorijekloZivotinje porijekloZivotinje;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dolazakZivotinje;
    public Zivotinja()
    {

    }

    public Zivotinja(Long id, String naziv, Integer identifikator, boolean skupZivotinja, Integer brojZivotinja, Nastanba nastanba, boolean postojanjeZivotinje, VrstaZivotinje vrstaZivotinje, PorijekloZivotinje porijekloZivotinje, Date dolazakZivotinje) {
        this.id = id;
        this.naziv = naziv;
        this.identifikator = identifikator;
        this.skupZivotinja = skupZivotinja;
        this.brojZivotinja = brojZivotinja;
        this.nastanba = nastanba;
        this.postojanjeZivotinje = postojanjeZivotinje;
        this.vrstaZivotinje = vrstaZivotinje;
        this.porijekloZivotinje = porijekloZivotinje;
        this.dolazakZivotinje = dolazakZivotinje;
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

    public Integer getIdentifikator() {
        return identifikator;
    }

    public void setIdentifikator(Integer identifikator) {
        this.identifikator = identifikator;
    }

    public boolean isSkupZivotinja() {
        return skupZivotinja;
    }


    public void setSkupZivotinja(boolean skupZivotinja) {
        this.skupZivotinja = skupZivotinja;
    }

    public Integer getBrojZivotinja() {
        return brojZivotinja;
    }


    public void setBrojZivotinja(Integer brojZivotinja) {
        this.brojZivotinja = brojZivotinja;
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

    public Date getDolazakZivotinje() {
        return dolazakZivotinje;
    }

    public void setDolazakZivotinje(Date dolazakZivotinje) {
        this.dolazakZivotinje = dolazakZivotinje;
    }


}
