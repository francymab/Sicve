package com.francescomabilia.model.infrazione;

public abstract class InfrazioneBuilder {
    //VARIABILI D'ISTANZA
    protected Infrazione infrazione;

    //BUILD
    abstract void builDescrizione(String descrizione);

    abstract void buildTarga(String targa);

    abstract void buildVelocitaIstantanea(int velocitaIstantanea);

    abstract void buildVelocitaMedia(double velocitaMedia);

    abstract void buildKmTratta(int kmTratta);

    final Infrazione getResult(){
        return infrazione;
    }

    public void creazioneInfrazione(){

    }
}
