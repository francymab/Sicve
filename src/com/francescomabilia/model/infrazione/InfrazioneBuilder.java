package com.francescomabilia.model.infrazione;

public abstract class InfrazioneBuilder {
    //VARIABILI D'ISTANZA
    protected Infrazione infrazione;

    //BUILD
    public abstract void builDescrizione(String descrizione);

    public abstract void buildTarga(String targa);

    public abstract void buildVelocitaIstantanea(Integer velocitaIstantanea);

    public abstract void buildVelocitaMedia(Double velocitaMedia);

    public abstract void buildKmTratta(int kmTratta);

    final Infrazione getResult(){
        return infrazione;
    }

    public void creazioneInfrazione(){

    }
}
