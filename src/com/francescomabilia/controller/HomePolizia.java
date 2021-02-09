package com.francescomabilia.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

public class HomePolizia {
    private static final String fileName = "src/com/francescomabilia/view/fxml/loginAdmin.fxml";
    private static final String fileNameMulte = "src/com/francescomabilia/view/fxml/mostraMulte.fxml";

    @FXML
    private Button showMulteButton;

    @FXML
    private Button logoutButton;

    @FXML
    public void initialize(){
        logoutButton.setOnAction(e -> {
            try{
                logoutAlert();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });

        showMulteButton.setOnAction(e ->{
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = loader.load(new FileInputStream(fileNameMulte));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            Stage loginStage = new Stage();
            loginStage.setTitle("SICVE");
            loginStage.setScene(new Scene(root, 810, 400));
            loginStage.show();
        });
    }

    public void logoutAlert() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit!");
        alert.setContentText("Sicuro di voler effettuare il logout?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && (result.get() == ButtonType.OK)){
            Stage stage = (Stage) logoutButton.getScene().getWindow();
            stage.close();

            FXMLLoader loader = new FXMLLoader();
            Parent root = loader.load(new FileInputStream(fileName));

            Stage loginStage = new Stage();
            loginStage.setTitle("SICVE");
            loginStage.setScene(new Scene(root, 600, 500));
            loginStage.show();
        }
    }

}
