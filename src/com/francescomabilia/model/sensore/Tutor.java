package com.francescomabilia.model.sensore;

import com.francescomabilia.model.infrazione.InfrazioneBuilder;
import java.util.List;
import java.util.Objects;

public class Tutor {
    //VARIABILI D'ISTANZA
    private Sensore inizio;
    private Sensore fine;
    private List<Sensore> autovelox;
    private InfrazioneBuilder infrazioneBuilder;

    //COSTRUTTORI
    public Tutor(Sensore inizio, Sensore fine, List<Sensore> autovelox) {
        this.inizio = inizio;
        this.fine = fine;
        this.autovelox = autovelox;
    }

    public Tutor(Sensore inizio, Sensore fine, List<Sensore> autovelox, InfrazioneBuilder infrazioneBuilder) {
        this.inizio = inizio;
        this.fine = fine;
        this.autovelox = autovelox;
        this.infrazioneBuilder = infrazioneBuilder;
    }

    //SETTER
    public void setInizio(Sensore inizio) {
        this.inizio = inizio;
    }

    public void setFine(Sensore fine) {
        this.fine = fine;
    }

    public void setAutovelox(List<Sensore> autovelox) {
        this.autovelox = autovelox;
    }

    public void setInfrazioneBuilder(InfrazioneBuilder infrazioneBuilder) {
        this.infrazioneBuilder = infrazioneBuilder;
    }

    //GETTER
    public Sensore getInizio() {
        return this.inizio;
    }

    public Sensore getFine() {
        return this.fine;
    }

    public List<Sensore> getAutovelox() {
        return this.autovelox;
    }

    public InfrazioneBuilder getInfrazioneBuilder() {
        return this.infrazioneBuilder;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tutor)) return false;
        Tutor tutor = (Tutor) o;
        return inizio.equals(tutor.inizio) &&
                fine.equals(tutor.fine) &&
                autovelox.equals(tutor.autovelox) &&
                infrazioneBuilder.equals(tutor.infrazioneBuilder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inizio, fine, autovelox, infrazioneBuilder);
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "inizio=" + inizio +
                ", fine=" + fine +
                ", autovelox=" + autovelox +
                ", infrazioneBuilder=" + infrazioneBuilder +
                '}';
    }
}
