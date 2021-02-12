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

/**
 * Classe per la gestione della view per la homepage della polizia
 */
public class HomePolizia {
    /**
     * Variabile statica che rappresenta il percorso alla view del login per la polizia
     */
    private static final String fileName = "src/com/francescomabilia/view/fxml/loginPolizia.fxml";

    /**
     * ListView per la visualizzazione della lista delle multe in quel determinato comune
     */
    @FXML
    private ListView<Multa> multeListView;

    /**
     * Button per la gestione del caso in cui si voglia effettuare il logout
     */
    @FXML
    private Button logoutButton;

    /**
     * Metodo che starta la homepage della polizia con la stazione di polizia corrente
     * @param stazioneDiPolizia Stazione di polizia corrente
     */
    public void init(StazioneDiPolizia stazioneDiPolizia){
        try {
            multeListView.getItems().setAll(SicveDb.getInstance().getMulteDaComune(SicveDb.getInstance().connection(), stazioneDiPolizia.getComune()));
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Questo metodo inizializza la view a cui è collegato il controller corrente
     */
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

    //METODI

    /**
     * Metodo per l' operazione di logout
     * @throws IOException
     */
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
