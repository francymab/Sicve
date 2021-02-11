package com.francescomabilia.model.percorrimenti;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * Classe che definisce un Percorrimento
 */
public class Percorrimento {
    //VARIABILI D'ISTANZA

    /*Orario di entrata nella tratta*/
    private Timestamp orarioEntrata;

    /*Orario di uscita nella tratta*/
    private Timestamp orarioUscita;

    /*Targa dell' autoveicolo*/
    private String targa;

    /*Id della tratta*/
    private int idTratta;

    //COSTRUTTORI

    /**
     * Costruttore di un percorrimento
     * @param orarioEntrata Orario di entrata nella tratta
     * @param orarioUscita Orario di uscita nella tratta
     * @param targa Targa dell' autoveicolo
     * @param idTratta Id della tratta
     */
    public Percorrimento(Timestamp orarioEntrata, Timestamp orarioUscita, String targa, int idTratta) {
        this.orarioEntrata = orarioEntrata;
        this.orarioUscita = orarioUscita;
        this.targa = targa;
        this.idTratta = idTratta;
    }

    /**
     * Costruttore di default di un percorrimento
     */
    public Percorrimento(){
        //Default
    }

    //SETTER

    /**
     * Setter dell' orario di entrata del percorrimento
     * @param orarioEntrata Orario di entrata
     */
    public void setOrarioEntrata(Timestamp orarioEntrata) {
        this.orarioEntrata = orarioEntrata;
    }

    /**
     * Setter dell' orario di uscita del percorrimento
     * @param orarioUscita Orario di uscita
     */
    public void setOrarioUscita(Timestamp orarioUscita) {
        this.orarioUscita = orarioUscita;
    }

    /**
     * Setter dell' id della tratta
     * @param idTratta Id della tratta
     */
    public void setIdTratta(int idTratta) {
        this.idTratta = idTratta;
    }

    /**
     * Setter della targa dell' autoveicolo
     * @param targa Targa dell' autoveicolo
     */
    public void setTarga(String targa) {
        this.targa = targa;
    }

    //GETTER

    /**
     * Getter dell' orario di entrata nella tratta
     * @return Orario di entrata
     */
    public Timestamp getOrarioEntrata() {
        return this.orarioEntrata;
    }

    /**
     * Getter dell' orario di uscita della tratta
     * @return Orario di uscita
     */
    public Timestamp getOrarioUscita() {
        return this.orarioUscita;
    }

    /**
     * Getter della targa dell' autoveicolo
     * @return Targa dell' autoveicolo
     */
    public String getTarga() {
        return targa;
    }

    /**
     * Getter dell' id della tratta
     * @return Id della tratta
     */
    public int getIdTratta() {
        return idTratta;
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo equals atto a constatare l'uguaglianza di due oggetti di tipo Percorrimento
     * @return true se i due oggetti sono uguali ritorna, altrimenti false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Percorrimento)) return false;
        Percorrimento that = (Percorrimento) o;
        return orarioEntrata.equals(that.orarioEntrata) &&
                orarioUscita.equals(that.orarioUscita) &&
                targa.equals(that.targa);
    }

    /**
     * Override del metodo hascode
     * @return Il valore intero rappresentato dall'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(orarioEntrata, orarioUscita, targa, idTratta);
    }

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo Percorrimento
     * @return Stringa dell'oggetto di tipo Percorrimento
     */
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
