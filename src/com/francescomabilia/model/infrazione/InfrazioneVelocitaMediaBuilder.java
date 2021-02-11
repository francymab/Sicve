package com.francescomabilia.model.infrazione;

/**
 * Questa classe è il ConcreteBuilder del Builder Pattern e si occupa di costruire l' Infrazione Media in base ai metodi definiti
 * nell' InfrazioneBuilder
 */
public class InfrazioneVelocitaMediaBuilder extends InfrazioneBuilder{
    //METODI SOVRASCRITTI

    /**
     * Metodo per buildare la descrizione dell' infrazione
     * @param descrizione Descrizione dell' infrazione
     */
    @Override
    public void builDescrizione(String descrizione) {
        infrazione.setDescrizione(descrizione);
    }

    /**
     * Metodo per buildare la targa dell' autoveicolo nell' infrazione
     * @param targa Targa dell' autoveicolo
     */
    @Override
    public void buildTarga(String targa) {
        infrazione.setTarga(targa);
    }

    /**
     * Metodo per buildare la velocita istantanea dell' autoveicolo nell' infrazione
     * @param velocitaIstantanea Velocita istantanea dell' autoveicolo
     */
    @Override
    public void buildVelocitaIstantanea(Integer velocitaIstantanea) {
        infrazione.setVelocitaInstantanea(velocitaIstantanea);
    }

    /**
     * Metodo per buildare la velocita media dell' autoveicolo nell' infrazione
     * @param velocitaMedia Velocita media dell' autoveicolo
     */
    @Override
    public void buildVelocitaMedia(Double velocitaMedia) {
        infrazione.setVelocitaMedia(velocitaMedia);
    }

    /**
     * Metodo per buildare il km della tratte dell' infrazione
     * @param kmTratta Km tratta
     */
    @Override
    public void buildKmTratta(int kmTratta) {
        infrazione.setKmInfrazione(kmTratta);
    }

    /**
     * Metodo per buildare l' id della tratta
     * @param idTratta Id della tratta
     */
    @Override
    public void buildIdTratta(int idTratta) {
        infrazione.setIdTratta(idTratta);
    }

    /**
     * Metodo per buildare l' id dell' autovelox
     * @param idAutovelox Id dell' autovelox
     */
    @Override
    public void buildIdAutovelox(Integer idAutovelox) {
        infrazione.setIdAutovelox(idAutovelox);
    }
}
