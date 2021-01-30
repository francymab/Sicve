package com.francescomabilia.model.infrazione;

import com.francescomabilia.model.Proprietario;

import java.util.List;
import java.util.Objects;

public class Multa {
    //VARIABILI D'ISTANZA
    private List<Infrazione> infrazioni;
    private Proprietario proprietario;

    //COSTRUTTORI
    public Multa (List<Infrazione> infrazioni, Proprietario proprietario){
        this.infrazioni = infrazioni;
        this.proprietario = proprietario;
    }

    //SETTER
    public void setInfrazioni(List<Infrazione> infrazioni) {
        this.infrazioni = infrazioni;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    //GETTER
    public List<Infrazione> getInfrazioni() {
        return this.infrazioni;
    }

    public Proprietario getProprietario() {
        return this.proprietario;
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
