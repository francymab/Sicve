package com.francescomabilia.model.tratta;

import com.francescomabilia.model.auto.AutoveicoloObservable;
import com.francescomabilia.model.percorrimenti.PercorrimentiObserver;
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
    private int kmTrattaInizio;
    private int kmTrattaFine;
    private List<Percorrimento> percorrimento;
    private int idTratta;
    private String autostrada;

    //COSTRUTTORI
    public Tratta(Tutor tutor, String comune, int velocitaMin, int velocitaMax, int kmTrattaInizio, int idTratta, List<Percorrimento> percorrimento) {
        this.tutor = tutor;
        this.comune = comune;
        this.velocitaMin = velocitaMin;
        this.velocitaMax = velocitaMax;
        this.kmTrattaInizio = kmTrattaInizio;
        this.percorrimento = percorrimento;
        this.idTratta = idTratta;
    }

    public Tratta(String autostrada, String comune, int kmTrattaInizio, int velocitaMin, int velocitaMax, int kmTrattaFine){
        this.comune = comune;
        this.velocitaMin = velocitaMin;
        this.velocitaMax = velocitaMax;
        this.kmTrattaInizio = kmTrattaInizio;
        this.autostrada = autostrada;
        this.kmTrattaFine = kmTrattaFine;
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

    public void setKmTrattaInizio(int kmTrattaInizio) {
        this.kmTrattaInizio = kmTrattaInizio;
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

    public void setKmTrattaFine(int kmTrattaFine) {
        this.kmTrattaFine = kmTrattaFine;
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

    public int getKmTrattaInizio(){
        return this.kmTrattaInizio;
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

    public int getKmTrattaFine() {
        return kmTrattaFine;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tratta)) return false;
        Tratta tratta = (Tratta) o;
        return velocitaMin == tratta.velocitaMin &&
                velocitaMax == tratta.velocitaMax &&
                tutor.equals(tratta.tutor) &&
                comune.equals(tratta.comune) &&
                percorrimento.equals(tratta.percorrimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutor, comune, velocitaMin, velocitaMax, kmTrattaInizio, percorrimento);
    }

    @Override
    public String toString() {
        return  "Id Tratta= " + idTratta +
                ", Autostrada= " + autostrada +
                ", Velocita Min= " + velocitaMin +
                ", Velocita Max= " + velocitaMax +
                ", Km Tratta Iniziale= " + kmTrattaInizio +
                ", Km Tratta Finale= " + kmTrattaFine;
    }
}
