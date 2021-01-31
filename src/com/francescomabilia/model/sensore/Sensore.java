package com.francescomabilia.model.sensore;

import com.francescomabilia.model.auto.Autoveicolo;

public interface Sensore {
    //METODI

    /**
     * Calcolo della velocità media dell' autoveicolo
     * @param autoveicolo Autoveicolo
     * @return La velocità media dell' autoveicolo
     */
    double calcolaVelocitaMedia(Autoveicolo autoveicolo);
}
