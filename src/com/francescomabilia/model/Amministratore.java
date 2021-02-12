package com.francescomabilia.model;

/**
 * Classe che definisce un Amministratore
 */
public class Amministratore extends Utente{
    //VARIABILI D'ISTANZA

    //COSTRUTTORI

    /**
     * Costruttore di un Amministratore
     * @param username Username dell' utente
     * @param password Password dell' utente
     */
    public Amministratore(String username, String password){
        super(username, password);
    }

    public Amministratore(){
        super();
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo Amministratore
     * @return Stringa dell'oggetto di tipo Amministratore
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
