package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.StazioneDiPolizia;
import com.francescomabilia.model.infrazione.Multa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public class HomePolizia {
    private static final String fileName = "src/com/francescomabilia/view/fxml/loginPolizia.fxml";

    @FXML
    private ListView<Multa> multeListView;

    @FXML
    private Button logoutButton;

    public void init(StazioneDiPolizia stazioneDiPolizia){
        try {
            multeListView.getItems().setAll(SicveDb.getInstance().getMulteDaComune(SicveDb.getInstance().connection(), stazioneDiPolizia.getComune()));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize(){
        logoutButton.setOnAction(e -> {
            try{
                logoutAlert();
            }catch (Exception exception){
                exception.printStackTrace();
            }
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
