package com.francescomabilia.model.infrazione;

public class InfrazioneVelocitaIstantaneaBuilder extends InfrazioneBuilder{
    //MEDOTI SOVRASCRITTI
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
        infrazione.setVelocitaMedia(velocitaMedia);
    }

    @Override
    void buildKmTratta(int kmTratta) {
        infrazione.setKmInfrazione(kmTratta);
    }
}
