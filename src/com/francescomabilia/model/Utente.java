package com.francescomabilia.model;

import java.util.Objects;

/**
 * Classe che definisce un Utente
 */
public class Utente {
    //VARIABILI D' ISTANZA

    /*Username dell' utente*/
    private String username;

    /*Password dell' utente*/
    private String password;

    //COSTRUTTORI

    /**
     * Costruttore dell' utente
     * @param username Username dell' utente
     * @param password Password dell' utente
     */
    public Utente(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Costruttore dell' utente di default
     */
    public Utente(){
        //Default
    }
    //SETTER

    /**
     * Setter dell' username dell' utente
     * @param username Username dell' utente
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * Setter della password dell' utente
     * @param password Password dell' utente
     */
    public void setPassword(String password){
        this.password = password;
    }

    //GETTER

    /**
     * Getter dell' username dell' utente
     * @return Username dell' utente
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * Getter della password dell' utente
     * @return Password dell' utente
     */
    public String getUsername(){
        return this.username;
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo equals atto a constatare l'uguaglianza di due oggetti di tipo Utente
     * @return true se i due oggetti sono uguali ritorna, altrimenti false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utente)) return false;
        Utente utente = (Utente) o;
        return username.equals(utente.username) &&
                password.equals(utente.password);
    }

    /**
     * Override del metodo hascode
     * @return Il valore intero rappresentato dall'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo Utente
     * @return Stringa dell'oggetto di tipo Utente
     */
    @Override
    public String toString() {
        return "Utente{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
