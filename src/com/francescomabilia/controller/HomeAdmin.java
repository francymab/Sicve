package com.francescomabilia.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

public class HomeAdmin {
    private static final String fileName = "src/com/francescomabilia/view/fxml/aggiungiTratta.fxml";

    @FXML
    private Button addTrattaButton;

    @FXML
    private Button modifyTrattaButton;

    @FXML
    private BorderPane borderPane;

    @FXML
    public void initialize(){
        addTrattaButton.setOnAction(e ->{
            try {
                aggiungiTratta();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public void aggiungiTratta() throws IOException {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(borderPane.getScene().getWindow());
        dialog.setTitle("Aggiungi una nuova tratta");
        dialog.setHeaderText("Inserire i dati della nuova tratta:");
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(new FileInputStream(fileName));
        //fxmlLoader.setLocation(getClass().getResource("../view/fxml/aggiungiTratta.fxml"));
        dialog.getDialogPane().setContent(root);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
    }
}
