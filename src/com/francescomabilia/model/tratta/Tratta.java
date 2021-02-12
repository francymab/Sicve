package com.francescomabilia.model.tratta;

import com.francescomabilia.model.percorrimenti.Percorrimento;
import com.francescomabilia.model.sensore.Tutor;
import java.util.List;
import java.util.Objects;

/**
 * Classe che definisce una Tratta
 */
public class Tratta {
    //VARIABILI D'ISTANZA

    /*Tutor*/
    private Tutor tutor;

    /*Comune della Tratta*/
    private String comune;

    /*Velocita minima della tratta*/
    private int velocitaMin;

    /*Velocita massima della tratta*/
    private int velocitaMax;

    /*Lista dei percorrimenti della tratta*/
    private List<Percorrimento> percorrimento;

    /*Id della tratta*/
    private int idTratta;

    /*Autostrada*/
    private String autostrada;

    /*Direzione dell' autostrada*/
    private String direzione;

    /*Lunghezza della tratta*/
    private int kmTratta;

    //COSTRUTTORI

    /**
     * Costruttore della Tratta
     * @param tutor Tutor
     * @param comune Comune della Tratta
     * @param velocitaMin Velocita minima della tratta
     * @param velocitaMax Velocita massima della tratta
     * @param kmTratta Lunghezza della tratta
     * @param percorrimento Lista di percorrimento della tratta
     * @param direzione Direzione dell' autostrada
     * @param autostrada Nome autostrada
     */
    public Tratta(Tutor tutor, String comune, int velocitaMin, int velocitaMax, int kmTratta, List<Percorrimento> percorrimento, String direzione, String autostrada) {
        this.tutor = tutor;
        this.comune = comune;
        this.velocitaMin = velocitaMin;
        this.velocitaMax = velocitaMax;
        this.percorrimento = percorrimento;
        this.kmTratta = kmTratta;
        this.direzione = direzione;
        this.autostrada = autostrada;
    }

    /**
     * Costruttore della Tratta
     * @param comune Comune della Tratta
     * @param velocitaMin Velocita minima della tratta
     * @param velocitaMax Velocita massima della tratta
     * @param kmTratta Lunghezza della tratta
     */
    public Tratta(String autostrada, String comune, int kmTratta, int velocitaMin, int velocitaMax, String direzione){
        this.comune = comune;
        this.velocitaMin = velocitaMin;
        this.velocitaMax = velocitaMax;
        this.autostrada = autostrada;
        this.direzione = direzione;
        this.kmTratta = kmTratta;
    }

    /**
     * Costruttore di default della tratta
     */
    public Tratta(){
        //Default
    }

    //SETTER

    /**
     * Setter del tutor della tratta
     * @param tutor Tutor
     */
    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    /**
     * Setter del comune della tratta
     * @param comune Comune della tratta
     */
    public void setComune(String comune) {
        this.comune = comune;
    }

    /**
     * Setter della velocita minima della tratta
     * @param velocitaMin Velocita minima della tratta
     */
    public void setVelocitaMin(int velocitaMin) {
        this.velocitaMin = velocitaMin;
    }

    /**
     * Setter della velocita massima della tratta
     * @param velocitaMax Velocita massima della tratta
     */
    public void setVelocitaMax(int velocitaMax) {
        this.velocitaMax = velocitaMax;
    }

    /**
     * Setter dell' id della tratta
     * @param idTratta Id della tratta
     */
    public void setIdTratta(int idTratta) {
        this.idTratta = idTratta;
    }

    /**
     * Setter della lista dei percorrimenti della tratta
     * @param percorrimento Lista dei percorrimenti della tratta
     */
    public void setPercorrimento(List<Percorrimento> percorrimento) {
        this.percorrimento = percorrimento;
    }

    /**
     * Setter del nome dell' autostrada della tratta
     * @param autostrada Nome dell' autostrada
     */
    public void setAutostrada(String autostrada) {
        this.autostrada = autostrada;
    }

    /**
     * Set della direzione dell' autostrada
     * @param direzione Direzione dell' autostrada
     */
    public void setDirezione(String direzione) {
        this.direzione = direzione;
    }

    /**
     * Setter della lunghezza della tratta
     * @param kmTratta Lunghezza della tratta
     */
    public void setKmTratta(int kmTratta) {
        this.kmTratta = kmTratta;
    }

    //GETTER

    /**
     * Getter del tutor della tratta
     * @return Tutor
     */
    public Tutor getTutor() {
        return this.tutor;
    }

    /**
     * Getter del comune della tratta
     * @return Comune della tratta
     */
    public String getComune() {
        return this.comune;
    }

    /**
     * Getter della velocita massima della tratta
     * @return Velocita massima della tratta
     */
    public int getVelocitaMax(){
        return this.velocitaMax;
    }

    /**
     * Getter della velocita minima della tratta
     * @return Velocita minima della tratta
     */
    public int getVelocitaMin(){
        return this.velocitaMin;
    }

    /**
     * Getter della lista dei percorrimenti della tratta
     * @return Lista dei percorrimenti della tratta
     */
    public List<Percorrimento> getPercorrimento(){
        return this.percorrimento;
    }

    /**
     * Getter della id della tratta
     * @return Id della tratta
     */
    public int getIdTratta() {
        return this.idTratta;
    }

    /**
     * Getter del nome dell' autostrada
     * @return Nome dell' autostrada
     */
    public String getAutostrada() {
        return this.autostrada;
    }

    /**
     * Getter della direzione
     * @return Direzione
     */
    public String getDirezione() {
        return this.direzione;
    }

    /**
     * Getter della lunghezza della tratta
     * @return Lunghezza della tratta
     */
    public int getKmTratta() {
        return this.kmTratta;
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo equals atto a constatare l'uguaglianza di due oggetti di tipo Tratta
     * @return true se i due oggetti sono uguali ritorna, altrimenti false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tratta)) return false;
        Tratta tratta = (Tratta) o;
        return velocitaMin == tratta.velocitaMin &&
                velocitaMax == tratta.velocitaMax &&
                comune.equals(tratta.comune);
    }

    /**
     * Override del metodo hascode
     * @return Il valore intero rappresentato dall'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(tutor, comune, velocitaMin, velocitaMax, percorrimento);
    }

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo Tratta
     * @return Stringa dell'oggetto di tipo Tratta
     */
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
