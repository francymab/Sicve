package com.francescomabilia.controller;

import com.francescomabilia.model.sensore.Autovelox;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Classe per la gestione della view per l' aggiunta di un autovelox alla tratta
 */
public class AggiungiAutovelox {
    /**
     * TextField utile per l' inserimento dell' id dell' autovelox
     */
    @FXML
    private TextField idAutoveloxTextField;

    /**
     * TextField utile per l' inserimento del km dell' autovelox
     */
    @FXML
    private TextField kmAutoveloxTextField;

    /**
     * Metodo che acquisisce i valori inseriti
     * @return Nuovo autoveicolo
     */
    public Autovelox addAutovelox() {
        int idAutovelox = Integer.parseInt(idAutoveloxTextField.getText().trim());
        int kmAutovelox = Integer.parseInt(kmAutoveloxTextField.getText().trim());

        return new Autovelox(kmAutovelox, idAutovelox);
    }
}
