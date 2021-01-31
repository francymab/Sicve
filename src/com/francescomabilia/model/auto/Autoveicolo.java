package com.francescomabilia.model.auto;

import com.francescomabilia.model.Utente;
import com.francescomabilia.model.percorrimenti.PercorrimentiObserver;
import java.util.List;
import java.util.Objects;

/**
 * Classe che definisce un Autoveicolo
 */

public class Autoveicolo {
    //VARIABILI D'ISTANZA

    /*Marca dell' autoveicolo*/
    private String marca;

    /*Modello dell' autoveicolo*/
    private String modello;

    /*Targa dell' autoveicolo*/
    private String targa;

    /*Telefono dell' autoveicolo*/
    private String telefono;

    /*Valore booleano per la selezione della scelta della ricezione SMS*/
    private boolean mandaSMS;

    /*Lista degli observer dei Percorrimenti*/
    private List<PercorrimentiObserver> trattaObserver;

    /*Password dell' autoveicolo*/
    private String password;

    //COSTRUTTORI
    /**
     * Costruttore di un Autoveicolo
     * @param marca Marca dell' autoveicolo
     * @param modello Modello dell' autoveicolo
     * @param targa Targa dell' autoveicolo
     * @param telefono Telefono dell' autoveicolo
     * @param mandaSMS Valore booleano per la selezione della scelta della ricezione SMS
     * @param password Password dell' Utente
     **/
    public Autoveicolo(String marca, String modello, String targa, String telefono, boolean mandaSMS, String password){
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.telefono = telefono;
        this.mandaSMS = mandaSMS;
    }

    public Autoveicolo(){
        //Default
    }

    //SETTER

    /**
     * Setter della marca dell' autoveicolo
     * @param marca Marca dell' autoveicolo
     */
    public void setMarca(String marca){
        this.marca = marca;
    }

    /**
     * Setter del modello dell' autoveicolo
     * @param modello Modello dell' autoveicolo
     */
    public void setModello(String modello){
        this.modello = modello;
    }

    /**
     * Setter della targa dell' autoveicolo
     * @param targa Targa dell' autoveicolo
     */
    public void setTarga(String targa){
        this.targa = targa;
    }

    /**
     * Setter del telefono dell' autoveicolo
     * @param telefono Telefono dell' autoveicolo
     */
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    /**
     * Setter della scelta della ricezione del SMS
     * @param mandaSMS Valore booleano per la selezione della scelta della ricezione SMS
     */
    public void setMandaSMS(boolean mandaSMS){
        this.mandaSMS = mandaSMS;
    }

    /**
     * Setter dell' observer della tratta
     * @param trattaObserver Observer della tratta
     */
    public void setTrattaObserver(List<PercorrimentiObserver> trattaObserver) {
        this.trattaObserver = trattaObserver;
    }

    /**
     * Setter della password dell' autoveicolo
     * @param password Password dell' autoveicolo
     */
    public void setPassword(String password) {
        this.password = password;
    }

    //GETTER

    /**
     * Gettter della marca dell' autoveicolo
     * @return Marca dell' autoveicolo
     */
    public String getMarca(){
        return this.marca;
    }

    /**
     * Getter del modello dell' autoveicolo
     * @return Modello dell' autoveicolo
     */
    public String getModello(){
        return this.modello;
    }

    /**
     * Getter della targa dell' autoveicolo
     * @return Targa dell' autoveicolo
     */
    public String getTarga(){
        return this.targa;
    }

    /**
     * Getter del telefono dell' autoveicolo
     * @return Telefono dell' autoveicolo
     */
    public String getTelefono(){
        return this.telefono;
    }

    /**
     * Getter della scelta della ricezione del SMS
     * @return Scelta della ricezione del SMS
     */
    public boolean isMandaSMS(){
        return this.mandaSMS;
    }

    /**
     * Getter della lista degli observer della tratta
     * @return Lista degli observer della tratta
     */
    public List<PercorrimentiObserver> getTrattaObserver() {
        return trattaObserver;
    }

    /**
     * Getter della password dell' autoveicolo
     * @return Password dell' autoveicolo
     */
    public String getPassword() {
        return password;
    }

    //METODI SOVRASCRITTI

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autoveicolo)) return false;
        if (!super.equals(o)) return false;
        Autoveicolo that = (Autoveicolo) o;
        return mandaSMS == that.mandaSMS &&
                marca == that.marca &&
                modello.equals(that.modello) &&
                targa.equals(that.targa) &&
                telefono.equals(that.telefono) &&
                trattaObserver.equals(that.trattaObserver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), marca, modello, targa, telefono, mandaSMS, trattaObserver);
    }

    @Override
    public String toString() {
        return super.toString() + "\nAutoveicolo{" +
                "marca=" + marca +
                ", modello='" + modello + '\'' +
                ", targa='" + targa + '\'' +
                ", telefono='" + telefono + '\'' +
                ", mandaSMS=" + mandaSMS +
                ", trattaObserver=" + trattaObserver +
                '}';
    }
}
