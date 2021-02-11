package com.francescomabilia.db;

import com.francescomabilia.model.infrazione.Infrazione;

/**
 * Interfaccia che rappresenta una concreteStrategy per lo Strategy Pattern. In particolare questa classe astrae il concetto
 * Infrazione per salvare l' infrazione
 */
public interface InfrazioneStrategy{
    /**
     * Metodo per salvare l' infrazione
     * @param infrazione infrazione
     * @throws Exception
     */
    void salvaInfrazione(Infrazione infrazione) throws Exception;
}
