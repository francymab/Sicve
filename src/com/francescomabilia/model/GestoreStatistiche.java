package com.francescomabilia.model;

import com.francescomabilia.model.infrazione.Multa;
import com.francescomabilia.model.percorrimenti.Percorrimento;
import java.util.List;

/**
 * Classe che definisce il gestore delle Statistiche di una tratta
 */
public class GestoreStatistiche {
    //Metodi

    /**
     * Calcolo medio della velocita istantanea di una tratta
     * @param velocita Lista delle velocita istantanee nella tratta
     * @return Media delle velocita istantanee di una tratta
     */
    public static Integer calcolaVelocitaIstantaneaMedia(List<Integer> velocita) {
        if (velocita.size() == 0){
            return 0;
        }

        int velMax = 0;
        for (Integer vel : velocita) {
            velMax += vel;
        }
        velMax = velMax/(velocita.size());

        return velMax;
    }

    /**
     * Calcolo medio della velocita media di una tratta
     * @param velocita Lista delle velocita media nella tratta
     * @return Media delle velocita medie di una tratta
     */
    public static Double calcolaVelocitaMediaMedia(List<Double> velocita){
        if (velocita.size() == 0){
            return 0D;
        }

        double velMax = 0;
        for (Double vel : velocita) {
            velMax += vel;
        }
        velMax = velMax/(velocita.size());

        return velMax;
    }

    /**
     * Calcolo del numero di percorrimenti di una tratta
     * @param percorrimenti Lista dei percorrimenti di una tratta
     * @return Numero di percorrimenti di una tratta
     */
    public static Integer calcolaNPercorrimenti(List<Percorrimento> percorrimenti){
        return percorrimenti.size();
    }

    /**
     * Calcolo delle multe
     * @return Numero delle multe
     */
    public static Integer calcolaMultaEffettuate(){
        return Multa.counter;
    }

    /**
     * Calcolo medio della percorrenza di una tratta
     * @param time Lista dei tempi di percorrimento della tratta
     * @return Tempo medio del percorrimento di una tratta
     */
    public static Integer calcolaTempoPercorrenzaMedio(List<Long> time){
        if (time.size() == 0){
            return 0;
        }
        long timeMax = 0L;
        for (long tempTime : time) {
            timeMax += tempTime;
        }
        timeMax = timeMax/(time.size());

        return (int)timeMax;
    }

}
