package com.example.zoo.models;

import jakarta.persistence.*;

@Entity
public class Nastanba {

    @Id
    @GeneratedValue
    private Long id;
    private String naziv;
    private Long brojcanaLokacija;
    @ManyToOne
    @JoinColumn(name ="tipNastanbe_id")
    private TipNastanbe tipNastanbe;
    private String mjestoPromatranja;
    @ManyToOne
    @JoinColumn(name = "oblikNastanbe_id")
    private OblikNastanbe oblikNastanbe;
    private String strukturaNastanbe;

    public Nastanba(){}

    public Nastanba(Long id, String naziv, Long brojcanaLokacija, TipNastanbe tipNastanbe, String mjestoPromatranja, OblikNastanbe oblikNastanbe, String strukturaNastanbe) {
        this.id = id;
        this.naziv = naziv;
        this.brojcanaLokacija = brojcanaLokacija;
        this.tipNastanbe = tipNastanbe;
        this.mjestoPromatranja = mjestoPromatranja;
        this.oblikNastanbe = oblikNastanbe;
        this.strukturaNastanbe = strukturaNastanbe;
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

    public Long getBrojcanaLokacija() {
        return brojcanaLokacija;
    }

    public void setBrojcanaLokacija(Long brojcanaLokacija) {
        this.brojcanaLokacija = brojcanaLokacija;
    }

    public TipNastanbe getTipNastanbe() {
        return tipNastanbe;
    }

    public void setTipNastanbe(TipNastanbe tipNastanbe) {
        this.tipNastanbe = tipNastanbe;
    }

    public String getMjestoPromatranja() {
        return mjestoPromatranja;
    }

    public void setMjestoPromatranja(String mjestoPromatranja) {
        this.mjestoPromatranja = mjestoPromatranja;
    }

    public OblikNastanbe getOblikNastanbe() {
        return oblikNastanbe;
    }

    public void setOblikNastanbe(OblikNastanbe oblikNastanbe) {
        this.oblikNastanbe = oblikNastanbe;
    }

    public String getStrukturaNastanbe() {
        return strukturaNastanbe;
    }

    public void setStrukturaNastanbe(String strukturaNastanbe) {
        this.strukturaNastanbe = strukturaNastanbe;
    }
}
