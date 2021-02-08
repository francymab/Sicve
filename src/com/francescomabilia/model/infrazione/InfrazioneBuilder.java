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

    public abstract void buildIdTratta(int idTratta);

    public abstract void buildIdAutovelox(Integer idAutovelox);

    public final Infrazione getResult(){
        return infrazione;
    }

    public void creazioneInfrazione(){
        this.infrazione = new Infrazione();
    }
}
