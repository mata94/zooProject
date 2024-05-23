package com.example.zoo.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalTime;
import java.util.Date;

public class KalendarRadnik {

    @Id
    @GeneratedValue
    private Long id;

    private LocalTime radnoVrijemeOd;
    private LocalTime radnoVrijemeDo;
    private Date godisnjiOd;
    private Date godisnjiDo;
    private Date nedostupnostOd;
    private Date nedostupnostDo;

    @ManyToOne
    @JoinColumn(name = "radnik_id")
    private Radnik radnik;

    public KalendarRadnik(){}

    public KalendarRadnik(Long id, LocalTime radnoVrijemeOd, LocalTime radnoVrijemeDo, Date godisnjiOd, Date godisnjiDo, Date nedostupnostOd, Date nedostupnostDo, Radnik radnik) {
        this.id = id;
        this.radnoVrijemeOd = radnoVrijemeOd;
        this.radnoVrijemeDo = radnoVrijemeDo;
        this.godisnjiOd = godisnjiOd;
        this.godisnjiDo = godisnjiDo;
        this.nedostupnostOd = nedostupnostOd;
        this.nedostupnostDo = nedostupnostDo;
        this.radnik = radnik;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getRadnoVrijemeOd() {
        return radnoVrijemeOd;
    }

    public void setRadnoVrijemeOd(LocalTime radnoVrijemeOd) {
        this.radnoVrijemeOd = radnoVrijemeOd;
    }

    public LocalTime getRadnoVrijemeDo() {
        return radnoVrijemeDo;
    }

    public void setRadnoVrijemeDo(LocalTime radnoVrijemeDo) {
        this.radnoVrijemeDo = radnoVrijemeDo;
    }

    public Date getGodisnjiOd() {
        return godisnjiOd;
    }

    public void setGodisnjiOd(Date godisnjiOd) {
        this.godisnjiOd = godisnjiOd;
    }

    public Date getGodisnjiDo() {
        return godisnjiDo;
    }

    public void setGodisnjiDo(Date godisnjiDo) {
        this.godisnjiDo = godisnjiDo;
    }

    public Date getNedostupnostOd() {
        return nedostupnostOd;
    }

    public void setNedostupnostOd(Date nedostupnostOd) {
        this.nedostupnostOd = nedostupnostOd;
    }

    public Date getNedostupnostDo() {
        return nedostupnostDo;
    }

    public void setNedostupnostDo(Date nedostupnostDo) {
        this.nedostupnostDo = nedostupnostDo;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }
}
