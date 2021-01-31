package com.francescomabilia.model;

import com.francescomabilia.model.tratta.Tratta;
import java.util.Objects;

public class GestoreStatistiche {
    //VARIABILI D'ISTANZA
    private int velocitaIstantaneaAlta;
    private int velocitaIstantaneaBassa;
    private int velocitaMediaAlta;
    private int velocitaMediaBassa;
    private int nVeicoliGiornata;
    private int nVeicoliSettimana;
    private int nVeicoliMese;
    private int nMulteEffettuate;
    private double tempoPercorrenzaMedio;
    private Tratta tratta;

    //COSTRUTTORI

    public GestoreStatistiche(Tratta tratta) {
        this.tratta = tratta;
    }

    //SETTER
    public void setVelocitaIstantaneaAlta(int velocitaIstantaneaAlta) {
        this.velocitaIstantaneaAlta = velocitaIstantaneaAlta;
    }

    public void setVelocitaIstantaneaBassa(int velocitaIstantaneaBassa) {
        this.velocitaIstantaneaBassa = velocitaIstantaneaBassa;
    }

    public void setVelocitaMediaAlta(int velocitaMediaAlta) {
        this.velocitaMediaAlta = velocitaMediaAlta;
    }

    public void setVelocitaMediaBassa(int velocitaMediaBassa) {
        this.velocitaMediaBassa = velocitaMediaBassa;
    }

    public void setnVeicoliGiornata(int nVeicoliGiornata) {
        this.nVeicoliGiornata = nVeicoliGiornata;
    }

    public void setnVeicoliSettimana(int nVeicoliSettimana) {
        this.nVeicoliSettimana = nVeicoliSettimana;
    }

    public void setnVeicoliMese(int nVeicoliMese) {
        this.nVeicoliMese = nVeicoliMese;
    }

    public void setnMulteEffettuate(int nMulteEffettuate) {
        this.nMulteEffettuate = nMulteEffettuate;
    }

    public void setTempoPercorrenzaMedio(double tempoPercorrenzaMedio) {
        this.tempoPercorrenzaMedio = tempoPercorrenzaMedio;
    }

    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

    //GETTER
    public int getVelocitaIstantaneaAlta() {
        return this.velocitaIstantaneaAlta;
    }

    public int getVelocitaIstantaneaBassa() {
        return this.velocitaIstantaneaBassa;
    }

    public int getVelocitaMediaAlta() {
        return this.velocitaMediaAlta;
    }

    public int getVelocitaMediaBassa() {
        return this.velocitaMediaBassa;
    }

    public int getnVeicoliGiornata() {
        return this.nVeicoliGiornata;
    }

    public int getnVeicoliSettimana() {
        return this.nVeicoliSettimana;
    }

    public int getnVeicoliMese() {
        return this.nVeicoliMese;
    }

    public int getnMulteEffettuate() {
        return this.nMulteEffettuate;
    }

    public double getTempoPercorrenzaMedio() {
        return this.tempoPercorrenzaMedio;
    }

    public Tratta getTratta() {
        return this.tratta;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GestoreStatistiche)) return false;
        GestoreStatistiche that = (GestoreStatistiche) o;
        return velocitaIstantaneaAlta == that.velocitaIstantaneaAlta &&
                velocitaIstantaneaBassa == that.velocitaIstantaneaBassa &&
                velocitaMediaAlta == that.velocitaMediaAlta &&
                velocitaMediaBassa == that.velocitaMediaBassa &&
                nVeicoliGiornata == that.nVeicoliGiornata &&
                nVeicoliSettimana == that.nVeicoliSettimana &&
                nVeicoliMese == that.nVeicoliMese &&
                nMulteEffettuate == that.nMulteEffettuate &&
                Double.compare(that.tempoPercorrenzaMedio, tempoPercorrenzaMedio) == 0 &&
                tratta.equals(that.tratta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(velocitaIstantaneaAlta, velocitaIstantaneaBassa, velocitaMediaAlta, velocitaMediaBassa,
                            nVeicoliGiornata, nVeicoliSettimana, nVeicoliMese, nMulteEffettuate, tempoPercorrenzaMedio, tratta);
    }

    @Override
    public String toString() {
        return "GestoreStatistiche{" +
                "velocitaIstantaneaAlta=" + velocitaIstantaneaAlta +
                ", velocitaIstantaneaBassa=" + velocitaIstantaneaBassa +
                ", velocitaMediaAlta=" + velocitaMediaAlta +
                ", velocitaMediaBassa=" + velocitaMediaBassa +
                ", nVeicoliGiornata=" + nVeicoliGiornata +
                ", nVeicoliSettimana=" + nVeicoliSettimana +
                ", nVeicoliMese=" + nVeicoliMese +
                ", nMulteEffettuate=" + nMulteEffettuate +
                ", tempoPercorrenzaMedio=" + tempoPercorrenzaMedio +
                ", tratta=" + tratta +
                '}';
    }
}
