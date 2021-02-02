package com.francescomabilia.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class Sicve {
    private String fileName = "";

    @FXML
    private Button buttonAutoveicolo;

    @FXML
    private Button buttonAmministratore;

    @FXML
    private Button buttonPolizia;

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
                System.out.println("1");
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

    private void showLogin(String fileName) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(new FileInputStream(fileName));

        Stage loginStage = new Stage();
        loginStage.setTitle("SICVE");
        loginStage.setScene(new Scene(root, 600, 500));
        loginStage.show();
    }
}
