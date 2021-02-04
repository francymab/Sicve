package com.francescomabilia.controller;

import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AggiungiTratta {
    @FXML
    private TextField kmTrattaFineTextField;

    @FXML
    private TextField autostradaTextField;

    @FXML
    private TextField velocitaMaxTextField;

    @FXML
    private TextField velocitaMinTextField;

    @FXML
    private TextField cittaFineTrattaTextField;

    @FXML
    private TextField kmTrattaInizioTextField;

    @FXML
    private TextField direzioneTextField;

    public Tratta addTratta() {
        int kmTrattaFine = Integer.parseInt(kmTrattaFineTextField.getText().trim());
        String autostrada = autostradaTextField.getText().trim();
        int velocitaMax = Integer.parseInt(velocitaMaxTextField.getText().trim());
        int velocitàMin = Integer.parseInt(velocitaMinTextField.getText().trim());
        String cittaFineTratta = cittaFineTrattaTextField.getText().trim();
        int kmTrattaInizio = Integer.parseInt(kmTrattaInizioTextField.getText().trim());
        String direzione = direzioneTextField.getText().trim();

        return new Tratta(autostrada, cittaFineTratta, kmTrattaInizio, velocitàMin, velocitaMax, kmTrattaFine, direzione);
    }
}
