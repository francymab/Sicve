package com.francescomabilia.model.sensore;

import com.francescomabilia.model.auto.Autoveicolo;
import com.francescomabilia.model.percorrimenti.Percorrimento;

public interface Sensore {
    //METODI

    /**
     * Calcolo della velocità media dell' autoveicolo
     * @param percorrimento percporrimento
     * @return La velocità media dell' autoveicolo
     */
    double calcolaVelocitaMedia(Percorrimento percorrimento);
}
