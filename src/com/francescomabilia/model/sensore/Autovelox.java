package com.francescomabilia.model.sensore;

import com.francescomabilia.model.auto.Autoveicolo;
import com.francescomabilia.model.percorrimenti.Percorrimento;

import java.util.Objects;

public class Autovelox implements SensoreIstantaneo{
    //VARIABILI D'ISTANZA

    /*Km dell' autovelox*/
    private int kmAutovelox;
    private int idAutovelox;

    //COSTRUTTORI

    /**
     * Costruttore dell' autovelox
     * @param kmAutovelox Km dell' autovelox
     */
    public Autovelox(int kmAutovelox, int idAutovelox){
        this.kmAutovelox = kmAutovelox;
        this.idAutovelox = idAutovelox;
    }

    /**
     * Costruttore dell' Autovelox di default
     */
    public Autovelox(){
        //Default
    }

    //SETTER

    /**
     * Setter del km dell' autovelox
     * @param kmAutovelox Km dell' autovelox
     */
    public void setKmAutovelox(int kmAutovelox) {
        this.kmAutovelox = kmAutovelox;
    }

    /**
     * Setter dell' id dell' autovelox
     * @param idAutovelox id dell' Autovelox
     */
    public void setIdAutovelox(int idAutovelox) {
        this.idAutovelox = idAutovelox;
    }


    //GETTER

    /**
     * Getter del km dell' autovelox
     * @return Km dell' autovelox
     */
    public int getKmAutovelox() {
        return kmAutovelox;
    }

    /**
     * Getter dell' id dell' autovelox
     * @return id dell' autovelox
     */
    public int getIdAutovelox() {
        return idAutovelox;
    }

    //METODI SOVRASCRITTI
    @Override
    public double calcolaVelocitaMedia(Percorrimento percorrimento) {
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
                ", idAutovelox=" + idAutovelox +
                '}';
    }

    @Override
    public int calcolaVelocitaIstantanea(Autoveicolo autoveicolo){
        return 0;
    }
}
