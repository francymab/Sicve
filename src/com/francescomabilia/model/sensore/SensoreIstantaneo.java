package com.francescomabilia.model.sensore;

import java.time.LocalDateTime;

/**
 * Classe che definisce l' interfacci SensoreIstantaneo
 */
public interface SensoreIstantaneo extends Sensore{
    //METODI

    /**
     * Calcolo della velocita istantanea
     * @param time Istante di tempo
     * @return Velocita istantanea dell' autoveicolo
     */
    int calcolaVelocitaIstantanea(LocalDateTime time);
}
