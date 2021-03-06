package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

/**
 * Classe per la gestione della view per Homepage dell' amministratore
 */
public class HomeAdmin {
    /**
     * Variabile statica che rappresenta il percorso alla view del login per l' amministratore
     */
    private static final String fileName = "src/com/francescomabilia/view/fxml/loginAdmin.fxml";

    /**
     * Variabile statica che rappresenta il percorso alla view dell' aggiungi una tratta
     */
    private static final String fileNameAddTratta = "src/com/francescomabilia/view/fxml/aggiungiTratta.fxml";

    /**
     * Variabile statica che rappresenta il percorso alla view del mostra lista tratte
     */
    private static final String fileNameMostraTratta = "src/com/francescomabilia/view/fxml/mostraTratte.fxml";

    /**
     * Variabile per l'inizializzazione dell' istanza al database
     */
    private final SicveDb sicveDb = SicveDb.getInstance();

    /**
     * Button per la gestione del caso in cui si voglia aggiungere una nuova tratta
     */
    @FXML
    private Button addTrattaButton;

    /**
     * Button per la gestione del caso in cui si voglia mostrare le tratte
     */
    @FXML
    private Button showTratteButton;

    @FXML
    private BorderPane borderPane;

    /**
     * Button per la gestione del caso in cui si voglia effettuare il logout
     */
    @FXML
    private Button logoutButton;

    /**
     * Questo metodo inizializza la view a cui è collegato il controller corrente
     */
    @FXML
    public void initialize(){
        addTrattaButton.setOnAction(e ->{
            try {
                aggiungiTratta();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        logoutButton.setOnAction(e -> {
            try{
                logoutAlert();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });

        showTratteButton.setOnAction(e -> {
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = loader.load(new FileInputStream(fileNameMostraTratta));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            MostraTratte showTratte = loader.getController();
            showTratte.setTipoAccesso("Admin");

            Stage loginStage = new Stage();
            loginStage.setTitle("SICVE");
            loginStage.setScene(new Scene(root, 810, 400));
            loginStage.show();
        });
    }

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

    /**
     * Metodo per l' aggiunta di una tratta
     * @throws Exception
     */
    public void aggiungiTratta() throws Exception {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(borderPane.getScene().getWindow());
        dialog.setTitle("Aggiungi una nuova tratta");
        dialog.setHeaderText("Inserire i dati della nuova tratta:");
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(new FileInputStream(fileNameAddTratta));
        dialog.getDialogPane().setContent(root);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.get() == ButtonType.OK){
            AggiungiTratta controller = loader.getController();
            Tratta newTratta = controller.addTratta();

            int i = sicveDb.insertTratta(sicveDb.connection(), newTratta);

            if (i == 0){
                throw new Exception();
            }
        }
    }

}
