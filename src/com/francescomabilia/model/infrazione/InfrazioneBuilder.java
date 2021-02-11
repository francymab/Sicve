package com.francescomabilia.model.infrazione;

/**
 * Questa classe è l'astrazione di un builder che servirà a specificare un'interfaccia atta alla creazione del product
 */
public abstract class InfrazioneBuilder {
    //VARIABILI D'ISTANZA
    /*Infrazione*/
    protected Infrazione infrazione;

    //BUILD

    /**
     * Metodo per buildare la descrizione dell' infrazione
     * @param descrizione Descrizione dell' infrazione
     */
    public abstract void builDescrizione(String descrizione);

    /**
     * Metodo per buildare la targa dell' autoveicolo nell' infrazione
     * @param targa Targa dell' autoveicolo
     */
    public abstract void buildTarga(String targa);

    /**
     * Metodo per buildare la velocita istantanea dell' autoveicolo nell' infrazione
     * @param velocitaIstantanea Velocita istantanea dell' autoveicolo
     */
    public abstract void buildVelocitaIstantanea(Integer velocitaIstantanea);

    /**
     * Metodo per buildare la velocita media dell' autoveicolo nell' infrazione
     * @param velocitaMedia Velocita media dell' autoveicolo
     */
    public abstract void buildVelocitaMedia(Double velocitaMedia);

    /**
     * Metodo per buildare il km della tratte dell' infrazione
     * @param kmTratta Km tratta
     */
    public abstract void buildKmTratta(int kmTratta);

    /**
     * Metodo per buildare l' id della tratta
     * @param idTratta Id della tratta
     */
    public abstract void buildIdTratta(int idTratta);

    /**
     * Metodo per buildare l' id dell' autovelox
     * @param idAutovelox Id dell' autovelox
     */
    public abstract void buildIdAutovelox(Integer idAutovelox);

    /**
     * Getter dell' infrazione
     * @return Infrazione
     */
    public final Infrazione getResult(){
        return infrazione;
    }

    /**
     * Metodo per creare una nuova istanza di Infrazione
     */
    public void creazioneInfrazione(){
        this.infrazione = new Infrazione();
    }
}
