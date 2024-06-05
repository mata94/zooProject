package com.example.zoo.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class HranaZaZivotinje {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name="zivotinja_id")
    private Zivotinja zivotinja;
    private float price;

    @ManyToOne
    @JoinColumn(name="dobavljac_id")
    private Dobavljac dobavljac;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datum;

    public HranaZaZivotinje(){

    }

    public HranaZaZivotinje(Long id, Zivotinja zivotinja, float price, Dobavljac dobavljac, Date datum) {
        this.id = id;
        this.zivotinja = zivotinja;
        this.price = price;
        this.dobavljac = dobavljac;
        this.datum = datum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Zivotinja getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(Zivotinja zivotinja) {
        this.zivotinja = zivotinja;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Dobavljac getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(Dobavljac dobavljac) {
        this.dobavljac = dobavljac;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
