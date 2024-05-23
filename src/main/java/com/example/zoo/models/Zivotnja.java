package com.example.zoo.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Zivotnja {

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

    public Zivotnja()
    {

    }

    public Zivotnja(Long id, Long indetifikator, boolean skupZivotinja,
                    Long brojZivotnja, Nastanba nastanba, boolean postojanjeZivotinje,
                    VrstaZivotinje vrstaZivotinja, PorijekloZivotinje porijekloZivotinj) {
        this.id = id;
        this.indetifikator = indetifikator;
        this.skupZivotinja = skupZivotinja;
        this.brojZivotnja = brojZivotnja;
        this.nastanba = nastanba;
        this.postojanjeZivotinje = postojanjeZivotinje;
        this.vrstaZivotinja = vrstaZivotinja;
        this.porijekloZivotinj = porijekloZivotinj;
    }

    public Long getId() {
        return id;
    }

    public Long getIndetifikator() {
        return indetifikator;
    }

    public boolean isSkupZivotinja() {
        return skupZivotinja;
    }

    public Long getBrojZivotnja() {
        return brojZivotnja;
    }

    public Nastanba getNastanba() {
        return nastanba;
    }

    public boolean isPostojanjeZivotinje() {
        return postojanjeZivotinje;
    }

    public Date getDolazakZivotinje() {
        return dolazakZivotinje;
    }

    public VrstaZivotinje getVrstaZivotinja() {
        return vrstaZivotinja;
    }

    public PorijekloZivotinje getPorijekloZivotinj() {
        return porijekloZivotinj;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIndetifikator(Long indetifikator) {
        this.indetifikator = indetifikator;
    }

    public void setSkupZivotinja(boolean skupZivotinja) {
        this.skupZivotinja = skupZivotinja;
    }

    public void setBrojZivotnja(Long brojZivotnja) {
        this.brojZivotnja = brojZivotnja;
    }

    public void setNastanba(Nastanba nastanba) {
        this.nastanba = nastanba;
    }

    public void setPostojanjeZivotinje(boolean postojanjeZivotinje) {
        this.postojanjeZivotinje = postojanjeZivotinje;
    }

    public void setDolazakZivotinje(Date dolazakZivotinje) {
        this.dolazakZivotinje = dolazakZivotinje;
    }

    public void setVrstaZivotinja(VrstaZivotinje vrstaZivotinja) {
        this.vrstaZivotinja = vrstaZivotinja;
    }

    public void setPorijekloZivotinj(PorijekloZivotinje porijekloZivotinj) {
        this.porijekloZivotinj = porijekloZivotinj;
    }
}
