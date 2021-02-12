package com.francescomabilia.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Classe per la gestione della view principale
 */
public class Sicve {
    /**
     * Variabile statica che rappresenta il percorso alla view
     */
    private String fileName = "";

    /**
     * Button per la gestione del caso in cui si voglia entrare nel login dell' autoveicolo
     */
    @FXML
    private Button buttonAutoveicolo;

    /**
     * Button per la gestione del caso in cui si voglia entrare nel login dell' amministratore
     */
    @FXML
    private Button buttonAmministratore;

    /**
     * Button per la gestione del caso in cui si voglia entrare nel login della polizia
     */
    @FXML
    private Button buttonPolizia;

    /**
     * Questo metodo inizializza la view a cui è collegato il controller corrente
     */
    @FXML
    public void initialize(){
        buttonAutoveicolo.setOnAction(e ->{
            try {
                Stage stage = (Stage) buttonAutoveicolo.getScene().getWindow();
                stage.close();
                fileName = "src/com/francescomabilia/view/fxml/loginAuto.fxml";
                showLogin(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        buttonAmministratore.setOnAction(e -> {
            try {
                Stage stage = (Stage) buttonAmministratore.getScene().getWindow();
                stage.close();
                fileName = "src/com/francescomabilia/view/fxml/loginAdmin.fxml";
                showLogin(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        buttonPolizia.setOnAction(e ->{
            try {
                Stage stage = (Stage) buttonPolizia.getScene().getWindow();
                stage.close();
                fileName = "src/com/francescomabilia/view/fxml/loginPolizia.fxml";
                showLogin(fileName);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    //METODI

    /**
     * Metodo per mostrare la view del login
     * @param fileName nome del file per il login
     * @throws IOException
     */
    private void showLogin(String fileName) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(new FileInputStream(fileName));

        Stage loginStage = new Stage();
        loginStage.setTitle("SICVE");
        loginStage.setScene(new Scene(root, 600, 500));
        loginStage.show();
    }
}
