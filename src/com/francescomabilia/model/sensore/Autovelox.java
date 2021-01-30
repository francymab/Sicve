package com.francescomabilia.model.sensore;

import com.francescomabilia.model.auto.Autoveicolo;

import java.util.Objects;

public class Autovelox implements Sensore{
    //VARIABILI D'ISTANZA
    private int kmAutovelox;

    //COSTRUTTORI
    public Autovelox(int kmAutovelox){
        this.kmAutovelox = kmAutovelox;
    }

    //SETTER
    public void setKmAutovelox(int kmAutovelox) {
        this.kmAutovelox = kmAutovelox;
    }

    //GETTER
    public int getKmAutovelox() {
        return kmAutovelox;
    }

    //METODI SOVRASCRITTI
    @Override
    public double calcolaVelocitaMedia(Autoveicolo autoveicolo) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autovelox)) return false;
        Autovelox autovelox = (Autovelox) o;
        return kmAutovelox == autovelox.kmAutovelox;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kmAutovelox);
    }

    @Override
    public String toString() {
        return "Autovelox{" +
                "kmAutovelox=" + kmAutovelox +
                '}';
    }

    //METODI
    public int calcolaVelocitaIstantanea(Autoveicolo autoveicolo){
        return 0;
    }
}
