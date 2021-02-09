package com.francescomabilia.model.tratta;

import com.francescomabilia.model.percorrimenti.Percorrimento;
import com.francescomabilia.model.sensore.Tutor;
import java.util.List;
import java.util.Objects;

public class Tratta {
    //VARIABILI D'ISTANZA
    private Tutor tutor;
    private String comune;
    private int velocitaMin;
    private int velocitaMax;
    private List<Percorrimento> percorrimento;
    private int idTratta;
    private String autostrada;
    private String direzione;
    private int kmTratta;

    //COSTRUTTORI
    public Tratta(Tutor tutor, String comune, int velocitaMin, int velocitaMax, int kmTratta, List<Percorrimento> percorrimento) {
        this.tutor = tutor;
        this.comune = comune;
        this.velocitaMin = velocitaMin;
        this.velocitaMax = velocitaMax;
        this.percorrimento = percorrimento;
    }

    public Tratta(String autostrada, String comune, int kmTratta, int velocitaMin, int velocitaMax, String direzione){
        this.comune = comune;
        this.velocitaMin = velocitaMin;
        this.velocitaMax = velocitaMax;
        this.autostrada = autostrada;
        this.direzione = direzione;
        this.kmTratta = kmTratta;
    }

    public Tratta(){
        //Default
    }

    //SETTER
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public void setVelocitaMin(int velocitaMin) {
        this.velocitaMin = velocitaMin;
    }

    public void setVelocitaMax(int velocitaMax) {
        this.velocitaMax = velocitaMax;
    }

    public void setIdTratta(int idTratta) {
        this.idTratta = idTratta;
    }

    public void setPercorrimento(List<Percorrimento> percorrimento) {
        this.percorrimento = percorrimento;
    }

    public void setAutostrada(String autostrada) {
        this.autostrada = autostrada;
    }

    public void setDirezione(String direzione) {
        this.direzione = direzione;
    }

    public void setKmTratta(int kmTratta) {
        this.kmTratta = kmTratta;
    }

    //GETTER
    public Tutor getTutor() {
        return this.tutor;
    }

    public String getComune() {
        return this.comune;
    }

    public int getVelocitaMax(){
        return this.velocitaMax;
    }

    public int getVelocitaMin(){
        return this.velocitaMin;
    }

    public List<Percorrimento> getPercorrimento(){
        return this.percorrimento;
    }

    public int getIdTratta() {
        return this.idTratta;
    }

    public String getAutostrada() {
        return this.autostrada;
    }

    public String getDirezione() {
        return this.direzione;
    }

    public int getKmTratta() {
        return this.kmTratta;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tratta)) return false;
        Tratta tratta = (Tratta) o;
        return velocitaMin == tratta.velocitaMin &&
                velocitaMax == tratta.velocitaMax &&
                comune.equals(tratta.comune);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutor, comune, velocitaMin, velocitaMax, percorrimento);
    }

    @Override
    public String toString() {
        return  "Id Tratta= " + idTratta +
                ", Autostrada= " + autostrada +
                ", Direzione = " + direzione +
                ", Citta di Fine = " + comune +
                ", Velocita Max= " + velocitaMax +
                ", Velocita Min= " + velocitaMin;
    }
}
