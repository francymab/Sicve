package com.francescomabilia.model.sensore;

import com.francescomabilia.model.auto.Autoveicolo;

public class StazioneRilevamento implements Sensore {
    //METODI SOVRASCRITTI

    /**
     * Calcola la velocita media dell' autoveicolo
     * @param autoveicolo Autoveicolo
     * @return Velocita media dell' autoveicolo
     */
    @Override
    public double calcolaVelocitaMedia(Autoveicolo autoveicolo) {
        return 0;
    }
}
