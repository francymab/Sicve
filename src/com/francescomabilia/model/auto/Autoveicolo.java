package com.francescomabilia.model.auto;

import com.francescomabilia.model.Utente;
import com.francescomabilia.model.percorrimenti.PercorrimentiObserver;

import java.util.List;
import java.util.Objects;

public class Autoveicolo extends Utente {
    //VARIABILI D'ISTANZA
    private Marca marca;
    private String modello;
    private String targa;
    private String telefono;
    private boolean mandaSMS;
    private List<PercorrimentiObserver> trattaObserver;

    //COSTRUTTORI
    public Autoveicolo(Marca marca, String modello, String targa, String telefono, boolean mandaSMS, String username, String password){
        super(username, password);
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.telefono = telefono;
        this.mandaSMS = mandaSMS;
    }

    //SETTER
    public void setMarca(Marca marca){
        this.marca = marca;
    }

    public void setModello(String modello){
        this.modello = modello;
    }
    
    public void setTarga(String targa){
        this.targa = targa;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void setMandaSMS(boolean mandaSMS){
        this.mandaSMS = mandaSMS;
    }

    public void setTrattaObserver(List<PercorrimentiObserver> trattaObserver) {
        this.trattaObserver = trattaObserver;
    }

    //GETTER
    public Marca getMarca(){
        return this.marca;
    }
    
    public String getModello(){
        return this.modello;
    }
    
    public String getTarga(){
        return this.targa;
    }
    
    public String getTelefono(){
        return this.telefono;
    }
    
    public boolean isMandaSMS(){
        return this.mandaSMS;
    }

    public List<PercorrimentiObserver> getTrattaObserver() {
        return trattaObserver;
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
