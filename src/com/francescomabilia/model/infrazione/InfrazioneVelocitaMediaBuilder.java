package com.francescomabilia.model.infrazione;

public class InfrazioneVelocitaMediaBuilder extends InfrazioneBuilder{
    //METODI SOVRASCRITTI
    @Override
    void builDescrizione(String descrizione) {
        infrazione.setDescrizione(descrizione);
    }

    @Override
    void buildTarga(String targa) {
        infrazione.setTarga(targa);
    }

    @Override
    void buildVelocitaIstantanea(int velocitaIstantanea) {
        infrazione.setVelocittaInstantanea(velocitaIstantanea);
    }

    @Override
    void buildVelocitaMedia(double velocitaMedia) {

    }

    @Override
    void buildKmTratta(int kmTratta) {

    }
}
