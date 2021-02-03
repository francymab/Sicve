package com.francescomabilia.model;

import java.util.Objects;

public class StazioneDiPolizia extends Utente{
    //VARIABILI D'ISTANZA
    private String comune;
    private String indirizzo;

    //COSTRUTTORI
    public StazioneDiPolizia(String comune, String indirizzo, String username, String password){
        super(username, password);
        this.comune = comune;
        this.indirizzo = indirizzo;
    }

    public StazioneDiPolizia(){
        //Default
    }

    //SETTER
    public void setComune(String comune){
        this.comune = comune;
    }

    public void setIndirizzo(String indirizzo){
        this.indirizzo = indirizzo;
    }

    //GETTER
    public String getComune(){
        return this.comune;
    }

    public String getIndirizzo(){
        return this.indirizzo;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StazioneDiPolizia)) return false;
        if (!super.equals(o)) return false;
        StazioneDiPolizia that = (StazioneDiPolizia) o;
        return comune.equals(that.comune) &&
                indirizzo.equals(that.indirizzo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comune, indirizzo);
    }

    @Override
    public String toString() {
        return super.toString() + "\nStazioneDiPolizia{" +
                "comune='" + comune + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
