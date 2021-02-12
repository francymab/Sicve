package com.francescomabilia.model.sensore;

import com.francescomabilia.model.percorrimenti.Percorrimento;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

/**
 * Classe che definisce un Autovelox
 */
public class Autovelox implements SensoreIstantaneo{
    //VARIABILI D'ISTANZA

    /*Km dell' autovelox*/
    /*Km dell' autovelox*/
    private int kmAutovelox;

    /*Id dell' autovelox*/
    private int idAutovelox;

    //COSTRUTTORI

    /**
     * Costruttore dell' autovelox
     * @param kmAutovelox Km dell' autovelox
     */
    public Autovelox(int kmAutovelox, int idAutovelox){
        this.kmAutovelox = kmAutovelox;
        this.idAutovelox = idAutovelox;
    }

    /**
     * Costruttore dell' Autovelox di default
     */
    public Autovelox(){
        //Default
    }

    //SETTER

    /**
     * Setter del km dell' autovelox
     * @param kmAutovelox Km dell' autovelox
     */
    public void setKmAutovelox(int kmAutovelox) {
        this.kmAutovelox = kmAutovelox;
    }

    /**
     * Setter dell' id dell' autovelox
     * @param idAutovelox id dell' Autovelox
     */
    public void setIdAutovelox(int idAutovelox) {
        this.idAutovelox = idAutovelox;
    }


    //GETTER

    /**
     * Getter del km dell' autovelox
     * @return Km dell' autovelox
     */
    public int getKmAutovelox() {
        return kmAutovelox;
    }

    /**
     * Getter dell' id dell' autovelox
     * @return id dell' autovelox
     */
    public int getIdAutovelox() {
        return idAutovelox;
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo calcolaVelocitaMedia dato un percorrimento
     * @param percorrimento Percporrimento
     * @return Velocita media dell' autoveicolo
     */
    @Override
    public double calcolaVelocitaMedia(Percorrimento percorrimento) {
        return Math.abs(this.kmAutovelox/(Duration.between(percorrimento.getOrarioUscita().toInstant(), percorrimento.getOrarioEntrata().toInstant()).toMinutes()/60D));
    }

    /**
     * Override del metodo equals atto a constatare l'uguaglianza di due oggetti di tipo Autovelox
     * @return true se i due oggetti sono uguali ritorna, altrimenti false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Autovelox)) return false;
        Autovelox autovelox = (Autovelox) o;
        return kmAutovelox == autovelox.kmAutovelox;
    }

    /**
     * Override del metodo hascode
     * @return Il valore intero rappresentato dall'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(kmAutovelox);
    }

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo Autovelox
     * @return Stringa dell'oggetto di tipo Autovelox
     */
    @Override
    public String toString() {
        return "Autovelox{" +
                "idAutovelox=" + idAutovelox +
                ", kmAutovelox=" + kmAutovelox +
                '}';
    }

    /**
     * Override del medoto calcolaVelocitaIstantanea atto a calcolare la velocita istantanea dato un tempo di rilevamento
     * @param time Tempo di rilevamento
     * @return Velocita istantanea dell' autoveicolo all' istante time
     */
    @Override
    public int calcolaVelocitaIstantanea(LocalDateTime time){

        Random random = new Random();
        long i = Double.valueOf((1.3D + 0.7D * random.nextDouble())*1000D).longValue();
        System.out.println( "1 = " + i);
        LocalDateTime timeEnd = time.plus(Duration.ofMillis(i));
        System.out.println("2 = " + time + " " + timeEnd);

        double x = (Duration.between(time, timeEnd).toMillis())/1000D;
        System.out.println("3 = " + x);
        int n =(int) (45/((Duration.between(time, timeEnd).toMillis())/1000D));
        return (int) (n*3.6);
    }
}
