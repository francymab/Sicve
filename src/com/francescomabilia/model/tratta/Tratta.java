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
    private int kmTratta;
    private List<Percorrimento> percorrimento;
    private int idTratta;
    private String autostrada;

    //COSTRUTTORI
    public Tratta(Tutor tutor, String comune, int velocitaMin, int velocitaMax, int kmTratta, int idTratta, List<Percorrimento> percorrimento) {
        this.tutor = tutor;
        this.comune = comune;
        this.velocitaMin = velocitaMin;
        this.velocitaMax = velocitaMax;
        this.kmTratta = kmTratta;
        this.percorrimento = percorrimento;
        this.idTratta = idTratta;
    }

    public Tratta(int idTratta, String autostrada, String comune, int kmTratta, int velocitaMin, int velocitaMax){
        this.comune = comune;
        this.velocitaMin = velocitaMin;
        this.velocitaMax = velocitaMax;
        this.kmTratta = kmTratta;
        this.idTratta = idTratta;
        this.autostrada = autostrada;
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

    public void setKmTratta(int kmTratta) {
        this.kmTratta = kmTratta;
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

    public int getKmTratta(){
        return this.kmTratta;
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

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tratta)) return false;
        Tratta tratta = (Tratta) o;
        return velocitaMin == tratta.velocitaMin &&
                velocitaMax == tratta.velocitaMax &&
                kmTratta == tratta.kmTratta &&
                tutor.equals(tratta.tutor) &&
                comune.equals(tratta.comune) &&
                percorrimento.equals(tratta.percorrimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutor, comune, velocitaMin, velocitaMax, kmTratta, percorrimento);
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "idTratta=" + idTratta +
                "tutor=" + tutor +
                ", comune='" + comune + '\'' +
                ", velocitaMin=" + velocitaMin +
                ", velocitaMax=" + velocitaMax +
                ", kmTratta=" + kmTratta +
                ", percorrimento=" + percorrimento +
                '}';
    }
}
