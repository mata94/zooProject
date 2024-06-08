package com.example.zoo.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class RadnikZaZivoitnju {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "radnik_id")
    private Radnik radnik;

    @ManyToOne()
    @JoinColumn(name = "zivotinja_id")
    private Zivotinja zivotinja;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datumOd;

    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date datumDo;

    public RadnikZaZivoitnju(){}

    public RadnikZaZivoitnju(Long id, Radnik radnik, Zivotinja zivotinja, Date datumOd, Date datumDo) {
        this.id = id;
        this.radnik = radnik;
        this.zivotinja = zivotinja;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
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

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }
}
