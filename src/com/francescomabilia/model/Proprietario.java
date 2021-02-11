package com.francescomabilia.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe che definisce un proprietario di un autoveicolo
 */
public class Proprietario {
    //VARIABILI D'ISTANZA

    /*Nome del proprietario dell' autoveicolo*/
    private String nome;

    /*Cognome del proprietario dell' autoveicolo*/
    private String cognome;

    /*Codice fisscale del proprietario dell' autoveicolo*/
    private String codiceFiscale;

    /*Indirizzo del proprietario dell' autoveicolo*/
    private String indirizzo;

    /*Data di nascita del proprietario dell' autoveicolo*/
    private LocalDate dataNascita;

    /*Cap del proprietario dell' autoveicolo*/
    private String cap;

    //COSTRUTTORI

    /**
     * Costruttore del proprietario dell' autoveicolo
     * @param nome Nome del proprietario dell' autoveicolo
     * @param cognome Cognome del proprietario dell' autoveicolo
     * @param codiceFiscale Codice fisscale del proprietario dell' autoveicolo
     * @param indirizzo Indirizzo del proprietario dell' autoveicolo
     * @param dataNascita Data di nascita del proprietario dell' autoveicolo
     * @param cap Cap del proprietario dell' autoveicolo
     */
    public Proprietario(String nome, String cognome, String codiceFiscale, String indirizzo, LocalDate dataNascita, String cap){
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.indirizzo = indirizzo;
        this.dataNascita = dataNascita;
        this.cap = cap;
    }

    /**
     * Costruttore di default del prorpietario dell' autoveicolo
     */
    public Proprietario(){
        //Default
    }

    //SETTER

    /**
     * Setter del nome del proprietario dell' autoveicolo
     * @param nome Nome del proprietario dell' autoveicolo
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Setter del cognome del proprietario dell' autoveicolo
     * @param cognome Cognome del proprietario dell' autoveicolo
     */
    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    /**
     * Setter del codice fiscale del proprietario dell' autoveicolo
     * @param codiceFiscale Codice fiscale del proprietario dell' autoveicolo
     */
    public void setCodiceFiscale(String codiceFiscale){
        this.codiceFiscale = codiceFiscale;
    }

    /**
     * Setter dell' indirizzo del proprietario dell' autoveicolo
     * @param indirizzo Indirizzo del proprietario dell' autoveicolo
     */
    public void setIndirizzo(String indirizzo){
        this.indirizzo = indirizzo;
    }

    /**
     * Setter della data di nascita del proprietario dell' autoveicolo
     * @param dataNascita Data di nascita del proprietario dell' autoveicolo
     */
    public void setDataNascita(LocalDate dataNascita){
        this.dataNascita = dataNascita;
    }

    /**
     * Setter del cap del proprietario dell' autoveicolo
     * @param cap Cap del proprietario dell' autoveicolo
     */
    public void setCap(String cap){
        this.cap = cap;
    }

    //GETTER

    /**
     * Getter del nome del proprietario dell' autoveicolo
     * @return Nome del proprietario dell' autoveicolo
     */
    public String getNome(){
        return this.nome;
    }

    /**
     * Getter del cognome del proprietario dell' autoveicolo
     * @return Cognome del proprietario dell' autoveicolo
     */
    public String getCognome(){
        return this.cognome;
    }

    /**
     * Getter del codice fiscale del proprietario dell' autoveicolo
     * @return Codice fiscsale del proprietario dell' autoveicolo
     */
    public String getCodiceFiscale(){
        return this.codiceFiscale;
    }

    /**
     * Getter dell' indirizzo del proprietario dell' autoveicolo
     * @return Indirizzo del proprietario dell' autoveicolo
     */
    public String getIndirizzo(){
        return this.indirizzo;
    }

    /**
     * Getter della data di nascita del proprietario dell' autoveicolo
     * @return Data di nascita del proprietario dell' autoveicolo
     */
    public LocalDate getDataNascita(){
        return this.dataNascita;
    }

    /**
     * Getter del cap del proprietario dell' autoveicolo
     * @return Cap del proprietario dell' autoveicolo
     */
    public String getCap(){
        return this.cap;
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo equals atto a constatare l'uguaglianza di due oggetti di tipo Proprietario
     * @return true se i due oggetti sono uguali ritorna, altrimenti false
     */
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

    /**
     * Override del metodo hascode
     * @return Il valore intero rappresentato dall'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, codiceFiscale, indirizzo, dataNascita, cap);
    }

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo Proprietario
     * @return Stringa dell'oggetto di tipo Propretario
     */
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
