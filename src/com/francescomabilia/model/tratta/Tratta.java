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
    private AutoveicoloObservable autoveicolo;
    private int velocitaMin;
    private int velocitaMax;
    private int kmTratta;
    private List<Percorrimento> percorrimento;

    //COSTRUTTORI
    public Tratta(Tutor tutor, String comune, AutoveicoloObservable autoveicolo, int velocitaMin, int velocitaMax, int kmTratta, List<Percorrimento> percorrimento) {
        this.tutor = tutor;
        this.comune = comune;
        this.autoveicolo = autoveicolo;
        this.velocitaMin = velocitaMin;
        this.velocitaMax = velocitaMax;
        this.kmTratta = kmTratta;
        this.percorrimento = percorrimento;
    }

    //SETTER
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public void setComune(String comune) {
        this.comune = comune;
    }

    public void setAutoveicolo(AutoveicoloObservable autoveicolo) {
        this.autoveicolo = autoveicolo;
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

    public void setPercorrimento(List<Percorrimento> percorrimento) {
        this.percorrimento = percorrimento;
    }

    //GETTER
    public Tutor getTutor() {
        return this.tutor;
    }

    public String getComune() {
        return this.comune;
    }

    public AutoveicoloObservable getAutoveicolo() {
        return this.autoveicolo;
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
                autoveicolo.equals(tratta.autoveicolo) &&
                percorrimento.equals(tratta.percorrimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutor, comune, autoveicolo, velocitaMin, velocitaMax, kmTratta, percorrimento);
    }

    @Override
    public String toString() {
        return "Tratta{" +
                "tutor=" + tutor +
                ", comune='" + comune + '\'' +
                ", autoveicolo=" + autoveicolo +
                ", velocitaMin=" + velocitaMin +
                ", velocitaMax=" + velocitaMax +
                ", kmTratta=" + kmTratta +
                ", percorrimento=" + percorrimento +
                '}';
    }
}
