package com.francescomabilia.model.infrazione;

import com.francescomabilia.model.Proprietario;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Multa {
    //VARIABILI D'ISTANZA
    /* Lista delle Infrazioni*/
    private List<Infrazione> infrazioni;

    /*Proprietario dell' autoveicolo*/
    private Proprietario proprietario;

    /*Data della multa*/
    private LocalDate dataMulta;

    //COSTRUTTORI

    /**
     * Costruttore della multa
     * @param infrazioni Lista delle Infrazioni
     * @param proprietario Proprietario dell' autoveicolo
     */
    public Multa (List<Infrazione> infrazioni, Proprietario proprietario, LocalDate dataMulta){
        this.infrazioni = infrazioni;
        this.proprietario = proprietario;
        this.dataMulta = dataMulta;
    }

    //SETTER

    /**
     * Setter dell' infrazione
     * @param infrazioni infrazioni
     */
    public void setInfrazioni(List<Infrazione> infrazioni) {
        this.infrazioni = infrazioni;
    }

    /**
     * Setter del proprietario
     * @param proprietario
     */
    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * Setter della data della multa
     * @param dataMulta Data della multa
     */
    public void setDataMulta(LocalDate dataMulta){
        this.dataMulta = dataMulta;
    }

    //GETTER

    /**
     * Getter della lista delle infrazioni
     * @return lista delle infrazioni
     */
    public List<Infrazione> getInfrazioni() {
        return this.infrazioni;
    }

    /**
     * Getter del proprietario
     * @return prorprietario
     */
    public Proprietario getProprietario() {
        return this.proprietario;
    }

    /**
     * Getter della data della multa
     * @return Data della multa
     */
    public LocalDate getDataMulta() {
        return this.dataMulta;
    }

    //METODI SOVRASCRITTI
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Multa)) return false;
        Multa multa = (Multa) o;
        return infrazioni.equals(multa.infrazioni) &&
                proprietario.equals(multa.proprietario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infrazioni, proprietario);
    }

    @Override
    public String toString() {
        return "Multa{" +
                "infrazioni=" + infrazioni +
                ", proprietario=" + proprietario +
                '}';
    }
}
