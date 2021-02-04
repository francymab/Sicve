package com.francescomabilia.model.infrazione;

public class InfrazioneVelocitaIstantaneaBuilder extends InfrazioneBuilder{
    //MEDOTI SOVRASCRITTI
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
        infrazione.setVelocitaMedia(velocitaMedia);
    }

    @Override
    public void buildKmTratta(int kmTratta) {
        infrazione.setKmInfrazione(kmTratta);
    }
}
