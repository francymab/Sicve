package com.francescomabilia.model;

import java.time.LocalDate;
import java.util.Objects;

public class Proprietario {
    //VARIABILI D'ISTANZA
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String indirizzo;
    private LocalDate dataNascita;
    private String cap;

    //COSTRUTTORI
    public Proprietario(String nome, String cognome, String codiceFiscale, String indirizzo, LocalDate dataNascita, String cap){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.dataNascita = dataNascita;
        this.cap = cap;
    }

    //SETTER
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public void setCodiceFiscale(String codiceFiscale){
        this.codiceFiscale = codiceFiscale;
    }

    public void setIndirizzo(String indirizzo){
        this.indirizzo = indirizzo;
    }

    public void setDataNascita(LocalDate dataNascita){
        this.dataNascita = dataNascita;
    }

    public void setCap(String cap){
        this.cap = cap;
    }

    //GETTER
    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return this.cognome;
    }

    public String getCodiceFiscale(){
        return this.codiceFiscale;
    }

    public String getIndirizzo(){
        return this.indirizzo;
    }

    public LocalDate getDataNascita(){
        return this.dataNascita;
    }

    public String getCap(){
        return this.cap;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proprietario)) return false;
        Proprietario that = (Proprietario) o;
        return nome.equals(that.nome) &&
                cognome.equals(that.cognome) &&
                codiceFiscale.equals(that.codiceFiscale) &&
                indirizzo.equals(that.indirizzo) &&
                dataNascita.equals(that.dataNascita) &&
                cap.equals(that.cap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, codiceFiscale, indirizzo, dataNascita, cap);
    }

    @Override
    public String toString() {
        return "Proprietario{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", dataNascita=" + dataNascita +
                ", cap='" + cap + '\'' +
                '}';
    }
}
