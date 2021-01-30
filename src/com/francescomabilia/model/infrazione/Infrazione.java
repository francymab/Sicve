package com.francescomabilia.model.infrazione;

import java.util.Objects;

public class Infrazione {
    //VARIABILI D'ISTANZA
    private String descrizione;
    private String targa;
    private int velocittaIstantanea;
    private double velocitaMedia;
    private int kmInfrazione;

    //COSTRUTTORI
    public Infrazione(){
        //Default
    }

    //SETTER
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public void setVelocittaInstantanea(int velocittaIstantanea) {
        this.velocittaIstantanea = velocittaIstantanea;
    }

    public void setVelocitaMedia(double velocitaMedia) {
        this.velocitaMedia = velocitaMedia;
    }

    public void setKmInfrazione(int kmInfrazione) {
        this.kmInfrazione = kmInfrazione;
    }

    //GETTER
    public String getDescrizione() {
        return this.descrizione;
    }

    public String getTarga() {
        return this.targa;
    }

    public int getVelocittaIstantanea() {
        return this.velocittaIstantanea;
    }

    public double getVelocitaMedia() {
        return this.velocitaMedia;
    }

    public int getKmInfrazione() {
        return this.kmInfrazione;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Infrazione)) return false;
        Infrazione that = (Infrazione) o;
        return velocittaIstantanea == that.velocittaIstantanea &&
                Double.compare(that.velocitaMedia, velocitaMedia) == 0 &&
                kmInfrazione == that.kmInfrazione &&
                descrizione.equals(that.descrizione) &&
                targa.equals(that.targa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descrizione, targa, velocittaIstantanea, velocitaMedia, kmInfrazione);
    }

    @Override
    public String toString() {
        return "Infrazione{" +
                "descrizione='" + descrizione + '\'' +
                ", targa='" + targa + '\'' +
                ", velocittaInstantanea=" + velocittaIstantanea +
                ", velocitaMedia=" + velocitaMedia +
                ", kmInfrazione=" + kmInfrazione +
                '}';
    }
}
