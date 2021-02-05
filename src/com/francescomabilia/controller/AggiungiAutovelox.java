package com.francescomabilia.controller;

import com.francescomabilia.model.sensore.Autovelox;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AggiungiAutovelox {
    @FXML
    private TextField idAutoveloxTextField;

    @FXML
    private TextField kmAutoveloxTextField;

    public Autovelox addAutovelox() {
        int idAutovelox = Integer.parseInt(idAutoveloxTextField.getText().trim());
        int kmAutovelox = Integer.parseInt(kmAutoveloxTextField.getText().trim());

        return new Autovelox(kmAutovelox, idAutovelox);
    }
}
