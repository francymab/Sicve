package com.francescomabilia.controller;

import com.francescomabilia.model.sensore.Tutor;
import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.time.Duration;
import java.util.ArrayList;

/**
 * Classe per la gestione della view per l' aggiunta di una nuova tratta
 */
public class AggiungiTratta {
    /**
     * TextField utile per l' inserimento della lunghezza della tratta
     */
    @FXML
    private TextField kmTrattaTextField;

    /**
     * TextField utile per l' inserimento del nome dell' autostrada della tratta
     */
    @FXML
    private TextField autostradaTextField;

    /**
     * TextField utile per l' inserimento della velocita massima della tratta
     */
    @FXML
    private TextField velocitaMaxTextField;

    /**
     * TextField utile per l' inserimento della velocita minima della tratta
     */
    @FXML
    private TextField velocitaMinTextField;

    /**
     * TextField utile per l' inserimento della citta della tratta
     */
    @FXML
    private TextField cittaFineTrattaTextField;

    /**
     * TextField utile per l' inserimento della direzione della tratta
     */
    @FXML
    private TextField direzioneTextField;

    /**
     * Metodo per l'aggiunta di una nuova tratta
     * @return Nuova tratta
     */
    public Tratta addTratta() {
        int kmTratta = Integer.parseInt(kmTrattaTextField.getText().trim());
        String autostrada = autostradaTextField.getText().trim();
        int velocitaMax = Integer.parseInt(velocitaMaxTextField.getText().trim());
        int velocitaMin = Integer.parseInt(velocitaMinTextField.getText().trim());
        String cittaFineTratta = cittaFineTrattaTextField.getText().trim();
        String direzione = direzioneTextField.getText().trim();

        return new Tratta(new Tutor(
                percorrimento -> {
                    return 0;
                },
                percorrimento -> {
                    return kmTratta/(Duration.between(percorrimento.getOrarioUscita().toInstant(), percorrimento.getOrarioEntrata().toInstant()).toMinutes()/60D);
                },
                new ArrayList<>()
        ),cittaFineTratta, velocitaMin, velocitaMax, kmTratta, new ArrayList<>(), direzione, autostrada);
    }
}
