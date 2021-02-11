package com.francescomabilia.model.infrazione;

import java.util.Objects;

/**
 * Classe che definisce un' infrazione
 */
public class Infrazione {
    //VARIABILI D'ISTANZA

    /*Descrizione dell' infrazione*/
    private String descrizione;

    /*Targa dell' autoveicolo*/
    private String targa;

    /*Velocita istantanea dell' autoveicolo*/
    private Integer velocitaIstantanea;

    /*Velocita media dell' autoveicolo*/
    private Double velocitaMedia;

    /*Km dell' infrazione*/
    private int kmInfrazione;

    /*Prezzo per km oltre il limite per velocita istantanea*/
    public static final double PREZZO_ISTANTANEA = 1.00D;

    /*Prezzo per km oltre il limite per velocita media*/
    public static final double PREZZO_MEDIA = 2.47D;

    /*Id della tratta*/
    private int idTratta;

    /*Id dell' autovelox*/
    private Integer idAutovelox;

    /*Id dell' infrazione*/
    private int idInfrazione;

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

    /**
     * Setter dell' id della tratta
     * @param idTratta Id della tratta
     */
    public void setIdTratta(int idTratta) {
        this.idTratta = idTratta;
    }

    /**
     * Setter dell' id dell' autovelox
     * @param idAutovelox Id dell' autovelox
     */
    public void setIdAutovelox(Integer idAutovelox) {
        this.idAutovelox = idAutovelox;
    }

    /**
     * Setter dell' id dell' infrazione
     * @param idInfrazione Id dell' infrazione
     */
    public void setIdInfrazione(int idInfrazione) {
        this.idInfrazione = idInfrazione;
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

    /**
     * Getter dell' id della tratta
     * @return Id della tratta
     */
    public int getIdTratta() {
        return this.idTratta;
    }

    /**
     * Getter dell' id dell' autovelox
     * @return Id dell' autovelox
     */
    public Integer getIdAutovelox() {
        return this.idAutovelox;
    }

    /**
     * Getter dell' id dell' infrazione
     * @return Id dell' infrazione
     */
    public int getIdInfrazione() {
        return idInfrazione;
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo equals atto a constatare l'uguaglianza di due oggetti di tipo Infrazione
     * @return true se i due oggetti sono uguali ritorna, altrimenti false
     */
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

    /**
     * Override del metodo hascode
     * @return Il valore intero rappresentato dall'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(descrizione, targa, velocitaIstantanea, velocitaMedia, kmInfrazione);
    }

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo Infrazione
     * @return Stringa dell'oggetto di tipo Infrazione
     */
    @Override
    public String toString() {
        return "Infrazione{" +
                "id infrazione= " + idInfrazione +
                ", descrizione='" + descrizione + '\'' +
                ", targa='" + targa + '\'' +
                ", velocittaInstantanea=" + velocitaIstantanea +
                ", velocitaMedia=" + velocitaMedia +
                ", kmInfrazione=" + kmInfrazione +
                ", idTratta= " + idTratta +
                ", id Autovelox= " + idAutovelox +
                '}';
    }
}
