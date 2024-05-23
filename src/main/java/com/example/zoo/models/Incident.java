package com.example.zoo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Incident {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="vrsta_id")
    private VrstaIncidenta vrstaIncidenta;
    @ManyToOne
    @JoinColumn(name="zivotinja_id")
    private Zivotnja zivotnja;
    @ManyToOne
    @JoinColumn(name="nastamba_id")
    private Nastanba nastanba;

    private String komentar;

    private String popravak;
    private Date datum;

    public Incident()
    {
        
    }

    public Incident(Long id, VrstaIncidenta vrstaIncidenta, Zivotnja zivotnja,
                    Nastanba nastanba, String komentar,
                    String popravak, Date datum) {
        this.id = id;
        this.vrstaIncidenta = vrstaIncidenta;
        this.zivotnja = zivotnja;
        this.nastanba = nastanba;
        this.komentar = komentar;
        this.popravak = popravak;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VrstaIncidenta getVrstaIncidenta() {
        return vrstaIncidenta;
    }

    public void setVrstaIncidenta(VrstaIncidenta vrstaIncidenta) {
        this.vrstaIncidenta = vrstaIncidenta;
    }

    public Zivotnja getZivotnja() {
        return zivotnja;
    }

    public void setZivotnja(Zivotnja zivotnja) {
        this.zivotnja = zivotnja;
    }

    public Nastanba getNastanba() {
        return nastanba;
    }

    public void setNastanba(Nastanba nastanba) {
        this.nastanba = nastanba;
    }

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getPopravak() {
        return popravak;
    }

    public void setPopravak(String popravak) {
        this.popravak = popravak;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
