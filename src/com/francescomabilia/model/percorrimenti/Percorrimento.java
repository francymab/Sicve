package com.francescomabilia.model.percorrimenti;

import java.time.LocalTime;
import java.util.Objects;

public class Percorrimento {
    //VARIABILI D'ISTANZA
    private LocalTime orarioEntrata;
    private LocalTime orarioUscita;
    private String targa;
    private String idTratta;

    //COSTRUTTORI


    public Percorrimento(LocalTime orarioEntrata, LocalTime orarioUscita, String targa, String idTratta) {
        this.orarioEntrata = orarioEntrata;
        this.orarioUscita = orarioUscita;
        this.targa = targa;
        this.idTratta = idTratta;
    }

    //SETTER
    public void setOrarioEntrata(LocalTime orarioEntrata) {
        this.orarioEntrata = orarioEntrata;
    }

    public void setOrarioUscita(LocalTime orarioUscita) {
        this.orarioUscita = orarioUscita;
    }


    //GETTER


    public LocalTime getOrarioEntrata() {
        return this.orarioEntrata;
    }

    public LocalTime getOrarioUscita() {
        return this.orarioUscita;
    }



    //METODI SOVRASCRITTI

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Percorrimento)) return false;
        Percorrimento that = (Percorrimento) o;
        return orarioEntrata.equals(that.orarioEntrata) &&
                orarioUscita.equals(that.orarioUscita) &&
                targa.equals(that.targa) &&
                idTratta.equals(that.idTratta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orarioEntrata, orarioUscita, targa, idTratta);
    }

    @Override
    public String toString() {
        return "Percorrimento{" +
                ", orarioEntrata= " + orarioEntrata +
                ", orarioUscita= " + orarioUscita +
                ", targa= " + targa +
                ", idTratta= " + idTratta +
                '}';
    }
}
