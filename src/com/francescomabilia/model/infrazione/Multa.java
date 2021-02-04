package com.francescomabilia.model.infrazione;

import com.francescomabilia.model.Proprietario;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Multa {
    //VARIABILI D'ISTANZA
    /* Lista delle Infrazioni*/
    private List<Infrazione> infrazioni;

    /*Data della multa*/
    private LocalDate dataMulta;

    //COSTRUTTORI

    /**
     * Costruttore della multa
     * @param infrazioni Lista delle Infrazioni
     */
    public Multa (List<Infrazione> infrazioni, LocalDate dataMulta){
        this.infrazioni = infrazioni;
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
        return infrazioni.equals(multa.infrazioni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infrazioni);
    }

    @Override
    public String toString() {
        return "Multa{" +
                "infrazioni=" + infrazioni +
                '}';
    }
}
