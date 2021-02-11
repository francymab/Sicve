package com.francescomabilia.model.sensore;

import com.francescomabilia.model.percorrimenti.Percorrimento;

/**
 * Classe che definisce l' interfaccia Sensore
 */
public interface Sensore {
    //METODI

    /**
     * Calcolo della velocità media dell' autoveicolo
     * @param percorrimento percporrimento
     * @return La velocità media dell' autoveicolo
     */
    double calcolaVelocitaMedia(Percorrimento percorrimento);
}
