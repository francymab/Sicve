package com.francescomabilia.model;

import java.util.Objects;

/**
 * Classe che definisce una stazione di polizia
 */
public class StazioneDiPolizia extends Utente{
    //VARIABILI D'ISTANZA

    /*Comune della Stazione di polizia*/
    private String comune;

    /*Indirizzo della stazione di polizia*/
    private String indirizzo;

    //COSTRUTTORI

    /**
     * Costruttore della stazione di polizia
     * @param comune Comune della stazione della polizia
     * @param indirizzo Indirizzo della stazione di polizia
     * @param username Username dell' utente
     * @param password Password dell' utente
     */
    public StazioneDiPolizia(String comune, String indirizzo, String username, String password){
        super(username, password);
        this.comune = comune;
        this.indirizzo = indirizzo;
    }

    /**
     * Costruttore di default della stazione di polizia
     */
    public StazioneDiPolizia(){
        //Default
    }

    //SETTER

    /**
     * Setter del comune della stazione di polizia
     * @param comune Comune della stazione di polizia
     */
    public void setComune(String comune){
        this.comune = comune;
    }

    /**
     * Setter dell' indirizzo della stazione di polizia
     * @param indirizzo Indirizzo della stazione di polizia
     */
    public void setIndirizzo(String indirizzo){
        this.indirizzo = indirizzo;
    }

    //GETTER

    /**
     * Getter del comune della stazione di polizia
     * @return Comune della stazione di polizia
     */
    public String getComune(){
        return this.comune;
    }

    /**
     * Getter dell' indirizzo della stazione di polizia
     * @return Indirizzo della stazione di polizia
     */
    public String getIndirizzo(){
        return this.indirizzo;
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo equals atto a constatare l'uguaglianza di due oggetti di tipo StazioneDiPolizia
     * @return true se i due oggetti sono uguali ritorna, altrimenti false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StazioneDiPolizia)) return false;
        if (!super.equals(o)) return false;
        StazioneDiPolizia that = (StazioneDiPolizia) o;
        return comune.equals(that.comune) &&
                indirizzo.equals(that.indirizzo);
    }

    /**
     * Override del metodo hascode
     * @return Il valore intero rappresentato dall'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), comune, indirizzo);
    }

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo StazioneDiPolizia
     * @return Stringa dell'oggetto di tipo StazioneDiPolizia
     */
    @Override
    public String toString() {
        return super.toString() + "\nStazioneDiPolizia{" +
                "comune='" + comune + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
