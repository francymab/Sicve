package com.francescomabilia.controller;

import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AggiungiTratta {
    @FXML
    private TextField idTrattaTextField;

    @FXML
    private TextField autostradaTextField;

    @FXML
    private TextField velocitaMaxTextField;

    @FXML
    private TextField velocitaMinTextField;

    @FXML
    private TextField cittaFineTrattaTextField;

    @FXML
    private TextField kmTrattaTextField;

    public Tratta addTratta() {
        int idTratta = Integer.parseInt(idTrattaTextField.getText().trim());
        String autostrada = autostradaTextField.getText().trim();
        int velocitaMax = Integer.parseInt(velocitaMaxTextField.getText().trim());
        int velocitàMin = Integer.parseInt(velocitaMinTextField.getText().trim());
        String cittaFineTratta = cittaFineTrattaTextField.getText().trim();
        int kmTratta = Integer.parseInt(kmTrattaTextField.getText().trim());

        return new Tratta(idTratta, autostrada, cittaFineTratta, kmTratta, velocitàMin, velocitaMax);
    }
}
