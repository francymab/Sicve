package com.francescomabilia.model.infrazione;

public class InfrazioneVelocitaMediaBuilder extends InfrazioneBuilder{
    //METODI SOVRASCRITTI
    @Override
    public void builDescrizione(String descrizione) {
        infrazione.setDescrizione(descrizione);
    }

    @Override
    public void buildTarga(String targa) {
        infrazione.setTarga(targa);
    }

    @Override
    public void buildVelocitaIstantanea(Integer velocitaIstantanea) {
        infrazione.setVelocitaInstantanea(velocitaIstantanea);
    }

    @Override
    public void buildVelocitaMedia(Double velocitaMedia) {

    }

    @Override
    public void buildKmTratta(int kmTratta) {

    }
}
