package com.francescomabilia.model.percorrimenti;

import java.time.LocalTime;
import java.util.Objects;

public class Percorrimento {
    //VARIABILI D'ISTANZA
    private LocalTime orarioEntrata;
    private LocalTime orarioUscita;
    private double velocitaMedia;
    private int velocitaVeicolo;

    //COSTRUTTORI

    public Percorrimento(LocalTime orarioEntrata) {
        this.orarioEntrata = orarioEntrata;
    }

    //SETTER
    public void setOrarioEntrata(LocalTime orarioEntrata) {
        this.orarioEntrata = orarioEntrata;
    }

    public void setOrarioUscita(LocalTime orarioUscita) {
        this.orarioUscita = orarioUscita;
    }

    public void setVelocitaMedia(double velocitaMedia) {
        this.velocitaMedia = velocitaMedia;
    }

    public void setVelocitaVeicolo(int velocitaVeicolo) {
        this.velocitaVeicolo = velocitaVeicolo;
    }

    //GETTER


    public LocalTime getOrarioEntrata() {
        return this.orarioEntrata;
    }

    public LocalTime getOrarioUscita() {
        return this.orarioUscita;
    }

    public double getVelocitaMedia() {
        return this.velocitaMedia;
    }

    public int getVelocitaVeicolo() {
        return this.velocitaVeicolo;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Percorrimento)) return false;
        Percorrimento that = (Percorrimento) o;
        return Double.compare(that.velocitaMedia, velocitaMedia) == 0 &&
                velocitaVeicolo == that.velocitaVeicolo &&
                orarioEntrata.equals(that.orarioEntrata) &&
                orarioUscita.equals(that.orarioUscita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orarioEntrata, orarioUscita, velocitaMedia, velocitaVeicolo);
    }

    @Override
    public String toString() {
        return "Percorrimento{" +
                "orarioEntrata=" + orarioEntrata +
                ", orarioUscita=" + orarioUscita +
                ", velocitaMedia=" + velocitaMedia +
                ", velocitaVeicolo=" + velocitaVeicolo +
                '}';
    }
}
