package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.GestoreStatistiche;
import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class MostraStatistiche {

    @FXML
    private TextField velocitaIstantaneaMediaTextField;

    @FXML
    private TextField velocitaMediaMediaTextField;

    @FXML
    private TextField percorrimentiTextField;

    @FXML
    private TextField multeTextField;

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

    @FXML
    public void initialize(){

    }

}
