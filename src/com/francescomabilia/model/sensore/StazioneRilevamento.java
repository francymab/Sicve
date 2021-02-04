package com.francescomabilia.model.sensore;

import com.francescomabilia.model.auto.Autoveicolo;
import com.francescomabilia.model.percorrimenti.Percorrimento;

public class StazioneRilevamento implements Sensore {
    //METODI SOVRASCRITTI

    /**
     * Calcola la velocita media dell' autoveicolo
     * @param percorrimento percorrimento
     * @return Velocita media dell' autoveicolo
     */
    @Override
    public double calcolaVelocitaMedia(Percorrimento percorrimento) {
        return 0;
    }
}
