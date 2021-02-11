package com.francescomabilia.db;

import com.francescomabilia.model.infrazione.Infrazione;

/**
 * Classe che rappresenta una concreteStrategy per lo Strategy Pattern. In particolare questa classe astrae il concetto
 * Infrazione per salvare l' infrazione istantanea
 */
public class InfrazioneIstantaneaStrategy implements InfrazioneStrategy{

    /**
     * Override del metodo per salvare l' infrazione istantanea
     * @param infrazione infrazione
     * @throws Exception
     */
    @Override
    public void salvaInfrazione(Infrazione infrazione) throws Exception {
        SicveDb sicveDb = SicveDb.getInstance();
        sicveDb.insertInfrazioneIstantanea(sicveDb.connection(), infrazione);
    }
}
