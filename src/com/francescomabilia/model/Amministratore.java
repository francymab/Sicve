package com.francescomabilia.model;

public class Amministratore extends Utente{
    //VARIABILI D'ISTANZA

    //COSTRUTTORI
    public Amministratore(String username, String password){
        super(username, password);
    }

    public Amministratore(){
        super();
    }
    //SETTER

    //GETTER

    //METODI SOVRASCRITTI
    @Override
    public String toString() {
        return super.toString();
    }
}
