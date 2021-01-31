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

    /**
     * Costruttore dell' infrazione
     */
    public Infrazione(){
        //Default
    }

    //SETTER

    /**
     * Setter della descrizione dell' infrazione
     * @param descrizione Descrizione dell' infrazione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     * Setter della targa dell' autoveicolo
     * @param targa Targa dell' autoveicolo
     */
    public void setTarga(String targa) {
        this.targa = targa;
    }

    /**
     * Setter della velocita istantanea dell' autoveicolo
     * @param velocittaIstantanea velocita istantanea dell' autoveicolo
     */
    public void setVelocittaInstantanea(int velocittaIstantanea) {
        this.velocittaIstantanea = velocittaIstantanea;
    }

    /**
     * Setter della velocita media dell' autoveicolo
     * @param velocitaMedia Velocita media dell' autoveicolo
     */
    public void setVelocitaMedia(double velocitaMedia) {
        this.velocitaMedia = velocitaMedia;
    }

    /**
     * Setter del km dell' ifrazione
     * @param kmInfrazione Km dell' infrazione
     */
    public void setKmInfrazione(int kmInfrazione) {
        this.kmInfrazione = kmInfrazione;
    }

    //GETTER

    /**
     * Getter della descrizione dell' infrazione
     * @return Descrizione dell' infrazione
     */
    public String getDescrizione() {
        return this.descrizione;
    }

    /**
     * Getter della targa dell' autoveicolo
     * @return Targa dell' autoveicolo
     */
    public String getTarga() {
        return this.targa;
    }

    /**
     * Getter della velocita istantanea dell' autoveicolo
     * @return Velocita istantanea dell' autoveicolo
     */
    public int getVelocittaIstantanea() {
        return this.velocittaIstantanea;
    }

    /**
     * Getter della velocita media dell' autoveicolo
     * @return Velocita media dell' autoveicolo
     */
    public double getVelocitaMedia() {
        return this.velocitaMedia;
    }

    /**
     * Getter del km dell' infrazione
     * @return Km dell' infrazione
     */
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
