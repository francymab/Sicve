package com.francescomabilia.model.sensore;

import com.francescomabilia.model.infrazione.InfrazioneBuilder;
import java.util.List;
import java.util.Objects;

/**
 * Classe che definisce un Tutor
 */
public class Tutor {
    //VARIABILI D'ISTANZA

    /*Sensore di inizio della tratta*/
    private Sensore inizio;

    /*Sensore di fine della tratta*/
    private Sensore fine;

    /*Lista degli autovelox della tratta*/
    private List<SensoreIstantaneo> autovelox;

    /*Infrazione Builder*/
    private InfrazioneBuilder infrazioneBuilder;

    //COSTRUTTORI

    /**
     * Costruttore del tutor
     * @param inizio Sensore di inizio della tratta
     * @param fine Sensore di fine della tratta
     * @param autovelox Lista degli autovelox della tratta
     */
    public Tutor(Sensore inizio, Sensore fine, List<SensoreIstantaneo> autovelox) {
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
    public Tutor(Sensore inizio, Sensore fine, List<SensoreIstantaneo> autovelox, InfrazioneBuilder infrazioneBuilder) {
        this.inizio = inizio;
        this.fine = fine;
        this.autovelox = autovelox;
        this.infrazioneBuilder = infrazioneBuilder;
    }

    //SETTER

    /**
     * Setter del Sensore di inizio
     * @param inizio Sensore di inizio
     */
    public void setInizio(Sensore inizio) {
        this.inizio = inizio;
    }

    /**
     * Setter del Sensore di fine
     * @param fine Sensore di fine
     */
    public void setFine(Sensore fine) {
        this.fine = fine;
    }

    /**
     * Setter della lista degli autovelox
     * @param autovelox Lista degli autovelox
     */
    public void setAutovelox(List<SensoreIstantaneo> autovelox) {
        this.autovelox = autovelox;
    }

    /**
     * Setter del' infrazione builder
     * @param infrazioneBuilder Infrazione builder
     */
    public void setInfrazioneBuilder(InfrazioneBuilder infrazioneBuilder) {
        this.infrazioneBuilder = infrazioneBuilder;
    }

    //GETTER

    /**
     * Getter del sensore di inizio
     * @return Sensore di inizio
     */
    public Sensore getInizio() {
        return this.inizio;
    }

    /**
     * Getter del sensore di fine
     * @return Sensore di fine
     */
    public Sensore getFine() {
        return this.fine;
    }

    /**
     * Getter della lista degli autovelox
     * @return Lista degli autovelox
     */
    public List<SensoreIstantaneo> getAutovelox() {
        return this.autovelox;
    }

    /**
     * Getter dell' infrazione builder
     * @return Infrazione builder
     */
    public InfrazioneBuilder getInfrazioneBuilder() {
        return this.infrazioneBuilder;
    }

    //METODI

    /**
     * Metodo per il builder dell' infrazione con velocita istantanea
     * @param kmTratta Km della tratta
     * @param descrizione descrizione dell' infrazione
     * @param targa Targa dell' autoveicolo
     * @param velocitaIstantanea Velocita istantanea dell' autoveicolo
     * @param idTratta Id della tratta
     * @param idAutovelox Id dell' autovelox
     */
    public void builderVelocitaIstantanea(int kmTratta, String descrizione, String targa, Integer velocitaIstantanea, int idTratta, Integer idAutovelox){
        this.infrazioneBuilder.creazioneInfrazione();
        this.infrazioneBuilder.buildKmTratta(kmTratta);
        this.infrazioneBuilder.builDescrizione(descrizione);
        this.infrazioneBuilder.buildTarga(targa);
        this.infrazioneBuilder.buildVelocitaIstantanea(velocitaIstantanea);
        this.infrazioneBuilder.buildVelocitaMedia(null);
        this.infrazioneBuilder.buildIdTratta(idTratta);
        this.infrazioneBuilder.buildIdAutovelox(idAutovelox);
    }

    /**
     * Metodo per il builder dell' infrazione con velocita media
     * @param kmTratta Km della tratta
     * @param descrizione descrizione dell' infrazione
     * @param targa Targa dell' autoveicolo
     * @param velocitaMedia Velocita media dell' autoveicolo
     * @param idTratta Id della tratta
     */
    public void builderVelocitaMedia(int kmTratta, String descrizione, String targa, Double velocitaMedia, int idTratta){
        this.infrazioneBuilder.creazioneInfrazione();
        this.infrazioneBuilder.buildKmTratta(kmTratta);
        this.infrazioneBuilder.builDescrizione(descrizione);
        this.infrazioneBuilder.buildTarga(targa);
        this.infrazioneBuilder.buildVelocitaIstantanea(null);
        this.infrazioneBuilder.buildVelocitaMedia(velocitaMedia);
        this.infrazioneBuilder.buildIdTratta(idTratta);
        this.infrazioneBuilder.buildIdAutovelox(null);
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo equals atto a constatare l'uguaglianza di due oggetti di tipo Tutor
     * @return true se i due oggetti sono uguali ritorna, altrimenti false
     */
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

    /**
     * Override del metodo hascode
     * @return Il valore intero rappresentato dall'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(inizio, fine, autovelox, infrazioneBuilder);
    }

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo Tutor
     * @return Stringa dell'oggetto di tipo Tutor
     */
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
