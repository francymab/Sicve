package com.francescomabilia.db;

import com.francescomabilia.model.infrazione.Infrazione;

/**
 * Classe che rappresenta una concreteStrategy per lo Strategy Pattern. In particolare questa classe astrae il concetto
 * Infrazione per salvare l' infrazione media
 */
public class InfrazioneMediaStrategy implements InfrazioneStrategy{
    /**
     * Override del metodo per salvare l' infrazione media
     * @param infrazione infrazione
     * @throws Exception
     */
    @Override
    public void salvaInfrazione(Infrazione infrazione) throws Exception {
        SicveDb sicveDb = SicveDb.getInstance();
        sicveDb.insertInfrazioneMedia(sicveDb.connection(), infrazione);
    }
}
