package com.example.zoo.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Zivotinja {

    @Id
    @GeneratedValue
    private Long id;
    private Long indetifikator;
    private boolean skupZivotinja;
    private Long brojZivotnja;
    @ManyToOne
    @JoinColumn(name = "nastanba_id")
    private Nastanba nastanba;
    private boolean postojanjeZivotinje;
    private Date dolazakZivotinje;



    @ManyToOne
    @JoinColumn(name = "vrstaZivotinje")
    private VrstaZivotinje vrstaZivotinja;
    @ManyToOne
    @JoinColumn(name = "porijekloZivotinjeId")
    private PorijekloZivotinje porijekloZivotinj;

    public Zivotinja()
    {

    }

    public Zivotinja(Long id, Long indetifikator, boolean skupZivotinja,
                     Long brojZivotnja, Nastanba nastanba, boolean postojanjeZivotinje,
                     Date dolazakZivotinje,
                     VrstaZivotinje vrstaZivotinja,
                     PorijekloZivotinje porijekloZivotinj) {
        this.id = id;
        this.indetifikator = indetifikator;
        this.skupZivotinja = skupZivotinja;
        this.brojZivotnja = brojZivotnja;
        this.nastanba = nastanba;
        this.postojanjeZivotinje = postojanjeZivotinje;
        this.dolazakZivotinje = dolazakZivotinje;
        this.vrstaZivotinja = vrstaZivotinja;
        this.porijekloZivotinj = porijekloZivotinj;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIndetifikator() {
        return indetifikator;
    }

    public void setIndetifikator(Long indetifikator) {
        this.indetifikator = indetifikator;
    }

    public boolean isSkupZivotinja() {
        return skupZivotinja;
    }

    public void setSkupZivotinja(boolean skupZivotinja) {
        this.skupZivotinja = skupZivotinja;
    }

    public Long getBrojZivotnja() {
        return brojZivotnja;
    }

    public void setBrojZivotnja(Long brojZivotnja) {
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

    public VrstaZivotinje getVrstaZivotinja() {
        return vrstaZivotinja;
    }

    public void setVrstaZivotinja(VrstaZivotinje vrstaZivotinja) {
        this.vrstaZivotinja = vrstaZivotinja;
    }

    public PorijekloZivotinje getPorijekloZivotinj() {
        return porijekloZivotinj;
    }

    public void setPorijekloZivotinj(PorijekloZivotinje porijekloZivotinj) {
        this.porijekloZivotinj = porijekloZivotinj;
    }
}
