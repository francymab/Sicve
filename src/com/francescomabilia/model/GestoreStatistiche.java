package com.francescomabilia.model;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.infrazione.Multa;
import com.francescomabilia.model.percorrimenti.Percorrimento;
import com.francescomabilia.model.tratta.Tratta;

import java.util.List;
import java.util.Objects;

public class GestoreStatistiche {
    //VARIABILI D'ISTANZA
//    private int velocitaIstantaneaAlta;
//    private int velocitaMediaAlta;
//    private int nVeicoliTratta;
//    private int nMulteEffettuate;
//    private double tempoPercorrenzaMedio;

    //Metodi
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

    public static Integer calcolaNPercorrimenti(List<Percorrimento> percorrimenti){
        return percorrimenti.size();
    }

    public static Integer calcolaMultaEffettuate(){
        return Multa.counter;
    }

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
