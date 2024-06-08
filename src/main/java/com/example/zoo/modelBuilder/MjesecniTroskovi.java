package com.example.zoo.modelBuilder;

public class MjesecniTroskovi {

    private String dobavljac;
    private double ukupnaCijena;
    private int mjesec;
    private int godina;

    public MjesecniTroskovi(){}
    public MjesecniTroskovi(String dobavljac, double ukupnaCijena, int mjesec,int godina) {
        this.dobavljac = dobavljac;
        this.ukupnaCijena = ukupnaCijena;
        this.mjesec = mjesec;
        this.godina = godina;
    }

    public String getDobavljac() {
        return dobavljac;
    }

    public void setDobavljac(String dobavljac) {
        this.dobavljac = dobavljac;
    }

    public double getUkupnaCijena() {
        return ukupnaCijena;
    }

    public void setUkupnaCijena(double ukupnaCijena) {
        this.ukupnaCijena = ukupnaCijena;
    }

    public int getMjesec() {
        return mjesec;
    }

    public void setMjesec(int mjesec) {
        this.mjesec = mjesec;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }
}
