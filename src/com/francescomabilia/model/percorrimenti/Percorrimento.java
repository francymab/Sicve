package com.francescomabilia.model.percorrimenti;

import java.sql.Timestamp;
import java.util.Objects;

public class Percorrimento {
    //VARIABILI D'ISTANZA
    private Timestamp orarioEntrata;
    private Timestamp orarioUscita;
    private String targa;
    private int idTratta;

    //COSTRUTTORI


    public Percorrimento(Timestamp orarioEntrata, Timestamp orarioUscita, String targa, int idTratta) {
        this.orarioEntrata = orarioEntrata;
        this.orarioUscita = orarioUscita;
        this.targa = targa;
        this.idTratta = idTratta;
    }

    public Percorrimento(){}

    //SETTER
    public void setOrarioEntrata(Timestamp orarioEntrata) {
        this.orarioEntrata = orarioEntrata;
    }

    public void setOrarioUscita(Timestamp orarioUscita) {
        this.orarioUscita = orarioUscita;
    }

    public void setIdTratta(int idTratta) {
        this.idTratta = idTratta;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    //GETTER


    public Timestamp getOrarioEntrata() {
        return this.orarioEntrata;
    }

    public Timestamp getOrarioUscita() {
        return this.orarioUscita;
    }

    public String getTarga() {
        return targa;
    }

    public int getIdTratta() {
        return idTratta;
    }

    //METODI SOVRASCRITTI

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Percorrimento)) return false;
        Percorrimento that = (Percorrimento) o;
        return orarioEntrata.equals(that.orarioEntrata) &&
                orarioUscita.equals(that.orarioUscita) &&
                targa.equals(that.targa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orarioEntrata, orarioUscita, targa, idTratta);
    }

    @Override
    public String toString() {
        return "Percorrimento{" +
                "idTratta= " + idTratta +
                ", targa= " + targa +
                ", orarioEntrata= " + orarioEntrata +
                ", orarioUscita= " + orarioUscita +
                '}';
    }
}
