package com.francescomabilia.controller;

import com.francescomabilia.model.infrazione.InfrazioneBuilder;
import com.francescomabilia.model.sensore.Tutor;
import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.time.Duration;
import java.util.ArrayList;

public class AggiungiTratta {
    @FXML
    private TextField kmTrattaTextField;

    @FXML
    private TextField autostradaTextField;

    @FXML
    private TextField velocitaMaxTextField;

    @FXML
    private TextField velocitaMinTextField;

    @FXML
    private TextField cittaFineTrattaTextField;

    @FXML
    private TextField direzioneTextField;

    public Tratta addTratta() {
        int kmTratta = Integer.parseInt(kmTrattaTextField.getText().trim());
        String autostrada = autostradaTextField.getText().trim();
        int velocitaMax = Integer.parseInt(velocitaMaxTextField.getText().trim());
        int velocitàMin = Integer.parseInt(velocitaMinTextField.getText().trim());
        String cittaFineTratta = cittaFineTrattaTextField.getText().trim();
        String direzione = direzioneTextField.getText().trim();

        return new Tratta(new Tutor(
                percorrimento -> {
                    return 0;
                },
                percorrimento -> {
                    return kmTratta/(Duration.between(percorrimento.getOrarioUscita(), percorrimento.getOrarioEntrata()).toMinutes()/60D);
                },
                new ArrayList<>()
        ),cittaFineTratta, velocitàMin, velocitaMax, kmTratta, new ArrayList<>());
    }
}
