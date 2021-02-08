package com.francescomabilia.model.infrazione;

import java.util.Objects;

public class Infrazione {
    //VARIABILI D'ISTANZA
    private String descrizione;
    private String targa;
    private Integer velocitaIstantanea;
    private Double velocitaMedia;
    private int kmInfrazione;
    public static final double PREZZO_ISTANTANEA = 1.00D;
    public static final double PREZZO_MEDIA = 2.47D;
    private int idTratta;

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
     * @param velocitaIstantanea velocita istantanea dell' autoveicolo
     */
    public void setVelocitaInstantanea(Integer velocitaIstantanea) {
        this.velocitaIstantanea = velocitaIstantanea;
    }

    /**
     * Setter della velocita media dell' autoveicolo
     * @param velocitaMedia Velocita media dell' autoveicolo
     */
    public void setVelocitaMedia(Double velocitaMedia) {
        this.velocitaMedia = velocitaMedia;
    }

    /**
     * Setter del km dell' ifrazione
     * @param kmInfrazione Km dell' infrazione
     */
    public void setKmInfrazione(int kmInfrazione) {
        this.kmInfrazione = kmInfrazione;
    }

    public void setIdTratta(int idTratta) {
        this.idTratta = idTratta;
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
    public Integer getVelocitaIstantanea() {
        return this.velocitaIstantanea;
    }

    /**
     * Getter della velocita media dell' autoveicolo
     * @return Velocita media dell' autoveicolo
     */
    public Double getVelocitaMedia() {
        return this.velocitaMedia;
    }

    /**
     * Getter del km dell' infrazione
     * @return Km dell' infrazione
     */
    public int getKmInfrazione() {
        return this.kmInfrazione;
    }

    public int getIdTratta() {
        return this.idTratta;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Infrazione)) return false;
        Infrazione that = (Infrazione) o;
        return velocitaIstantanea == that.velocitaIstantanea &&
                Double.compare(that.velocitaMedia, velocitaMedia) == 0 &&
                kmInfrazione == that.kmInfrazione &&
                descrizione.equals(that.descrizione) &&
                targa.equals(that.targa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descrizione, targa, velocitaIstantanea, velocitaMedia, kmInfrazione);
    }

    @Override
    public String toString() {
        return "Infrazione{" +
                "descrizione='" + descrizione + '\'' +
                ", targa='" + targa + '\'' +
                ", velocittaInstantanea=" + velocitaIstantanea +
                ", velocitaMedia=" + velocitaMedia +
                ", kmInfrazione=" + kmInfrazione +
                ", idTratta= " + idTratta +
                '}';
    }
}
