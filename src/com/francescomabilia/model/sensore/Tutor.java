package com.francescomabilia.model.sensore;

import com.francescomabilia.model.infrazione.InfrazioneBuilder;
import java.util.List;
import java.util.Objects;

public class Tutor {
    //VARIABILI D'ISTANZA

    /*Sensore di inizio della tratta*/
    private Sensore inizio;

    /*Sensore di fine della tratta*/
    private Sensore fine;

    /*Lista degli autovelox della tratta*/
    private List<Autovelox> autovelox;

    /**/
    private InfrazioneBuilder infrazioneBuilder;

    //COSTRUTTORI

    /**
     * Costruttore del tutor
     * @param inizio Sensore di inizio della tratta
     * @param fine Sensore di fine della tratta
     * @param autovelox Lista degli autovelox della tratta
     */
    public Tutor(Sensore inizio, Sensore fine, List<Autovelox> autovelox) {
        this.inizio = inizio;
        this.fine = fine;
        this.autovelox = autovelox;
    }

    /**
     * Costruttore del tutor con l' infrazione
     * @param inizio
     * @param fine
     * @param autovelox
     * @param infrazioneBuilder
     */
    public Tutor(Sensore inizio, Sensore fine, List<Autovelox> autovelox, InfrazioneBuilder infrazioneBuilder) {
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

    public void setAutovelox(List<Autovelox> autovelox) {
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

    public List<Autovelox> getAutovelox() {
        return this.autovelox;
    }

    public InfrazioneBuilder getInfrazioneBuilder() {
        return this.infrazioneBuilder;
    }

    //METODI
    public void builderVelocitaIstantanea(int kmTratta, String descrizione, String targa, Integer velocitaIstantanea){
        this.infrazioneBuilder.buildKmTratta(kmTratta);
        this.infrazioneBuilder.builDescrizione(descrizione);
        this.infrazioneBuilder.buildTarga(targa);
        this.infrazioneBuilder.buildVelocitaIstantanea(velocitaIstantanea);
        this.infrazioneBuilder.buildVelocitaMedia(null);
    }

    public void builderVelocitaMedia(int kmTratta, String descrizione, String targa, Double velocitaMedia){
        this.infrazioneBuilder.buildKmTratta(kmTratta);
        this.infrazioneBuilder.builDescrizione(descrizione);
        this.infrazioneBuilder.buildTarga(targa);
        this.infrazioneBuilder.buildVelocitaIstantanea(null);
        this.infrazioneBuilder.buildVelocitaMedia(velocitaMedia);
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
