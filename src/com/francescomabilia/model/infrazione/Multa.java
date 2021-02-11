package com.francescomabilia.model.infrazione;

import java.util.List;
import java.util.Objects;

/**
 * Classe che definisce la Multa
 */
public class Multa {
    //VARIABILI D'ISTANZA
    /* Lista delle Infrazioni*/
    private List<Infrazione> infrazioni;

    /*Counter delle multe*/
    public static int counter = 0;

    //COSTRUTTORI

    /**
     * Costruttore della multa
     * @param infrazioni Lista delle Infrazioni
     */
    public Multa (List<Infrazione> infrazioni){
        this.infrazioni = infrazioni;
    }

    /**
     * Costruttore di default della multa
     */
    public Multa(){
        counter++;
    }

    //SETTER

    /**
     * Setter dell' infrazione
     * @param infrazioni infrazioni
     */
    public void setInfrazioni(List<Infrazione> infrazioni) {
        this.infrazioni = infrazioni;
    }

    //GETTER

    /**
     * Getter della lista delle infrazioni
     * @return lista delle infrazioni
     */
    public List<Infrazione> getInfrazioni() {
        return this.infrazioni;
    }

    //METODI SOVRASCRITTI

    /**
     * Override del metodo equals atto a constatare l'uguaglianza di due oggetti di tipo Multa
     * @return trye se i due oggetti sono uguali ritorna, altrimenti false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Multa)) return false;
        Multa multa = (Multa) o;
        return infrazioni.equals(multa.infrazioni);
    }

    /**
     * Override del metodo hascode
     * @return Il valore intero rappresentato dall'oggetto
     */
    @Override
    public int hashCode() {
        return Objects.hash(infrazioni);
    }

    /**
     * Override del metodo to String atto a creare una stringa dato un oggetto di tipo Multa
     * @return Stringa dell'oggetto di tipo Multa
     */
    @Override
    public String toString() {
        return "Multa{" +
                "infrazioni=" + infrazioni +
                '}';
    }
}
