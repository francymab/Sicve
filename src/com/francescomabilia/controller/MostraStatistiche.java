package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.GestoreStatistiche;
import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;

/**
 * Classe per la gestione della view per mostrare la lista delle statistiche di una tratta
 */
public class MostraStatistiche {

    /**
     * TextField utile per il setting della media della velocita istantanea
     */
    @FXML
    private TextField velocitaIstantaneaMediaTextField;

    /**
     * TextField utile per il setting della media della velocita media
     */
    @FXML
    private TextField velocitaMediaMediaTextField;

    /**
     * TextField utile per il setting del numero dei percorrimenti
     */
    @FXML
    private TextField percorrimentiTextField;

    /**
     * TextField utile per il setting della media della velocita istantanea
     */
    @FXML
    private TextField multeTextField;

    /**
     * TextField utile per il setting del tempo medio di percorrenza
     */
    @FXML
    private TextField tempoTextField;

    public void init(Tratta tratta){
        SicveDb sicveDb = SicveDb.getInstance();
        try {
            velocitaIstantaneaMediaTextField.setText((GestoreStatistiche.calcolaVelocitaIstantaneaMedia(sicveDb.getVelocitaIstantanee(sicveDb.connection(), tratta.getIdTratta()))).toString() + " km/h");
            velocitaMediaMediaTextField.setText(String.format("%.2f km/h", GestoreStatistiche.calcolaVelocitaMediaMedia(sicveDb.getVelocitaMedie(sicveDb.connection(), tratta.getIdTratta()))));
            percorrimentiTextField.setText((GestoreStatistiche.calcolaNPercorrimenti(sicveDb.getPercorrenza(sicveDb.connection(), tratta.getIdTratta()))).toString());
            multeTextField.setText((GestoreStatistiche.calcolaMultaEffettuate()).toString());
            tempoTextField.setText((GestoreStatistiche.calcolaTempoPercorrenzaMedio(sicveDb.getTempoMedio(sicveDb.connection(), tratta.getIdTratta()))).toString() + " min");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    /**
     * Questo metodo inizializza la view a cui è collegato il controller corrente
     */
    @FXML
    public void initialize(){

    }
}
