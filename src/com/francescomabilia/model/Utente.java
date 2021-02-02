package com.francescomabilia.model;

import java.util.Objects;

public class Utente {
    //VARIABILI D' ISTANZA
    private String username;
    private String password;

    //COSTRUTTORI
    public Utente(String username, String password){
        this.username = username;
        this.password = password;
    }

    public Utente(){
        //Default
    }
    //SETTER
    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    //GETTER
    public String getPassword(){
        return this.password;
    }

    public String getUsername(){
        return this.username;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Utente)) return false;
        Utente utente = (Utente) o;
        return username.equals(utente.username) &&
                password.equals(utente.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    @Override
    public String toString() {
        return "Utente{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
