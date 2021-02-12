package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.auto.Autoveicolo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Classe per la gestione della view per Homepage dell' Autoveicolo
 */
public class HomeAuto {
    /**
     * Variabile statica che rappresenta il percorso alla view del login per l' Autoveicolo
     */
    private static final String fileName = "src/com/francescomabilia/view/fxml/loginAuto.fxml";

    /**
     * Variabile statica che rappresenta il percorso alla view del mostra lista delle tratte
     */
    private static final String fileNameMostraTratta = "src/com/francescomabilia/view/fxml/mostraTratte.fxml";

    /**
     * Variabile per l' assegnazione dell' autoveicolo corrente
     */
    Autoveicolo autoveicolo = new Autoveicolo();

    /**
     * Variabile per l'inizializzazione dell' istanza al database
     */
    private final SicveDb sicveDb = SicveDb.getInstance();

    /**
     * Labale per il saluto all' utente che ha effettuato l' acesso
     */
    @FXML
    private Label salveLabel;

    /**
     * ToggleButton per la gestione del caso in cui si voglia ricevere un sms una volta entrati in una tratta
     */
    @FXML
    private ToggleButton sendSMSToggleButton;

    /**
     * Button per la gestione del caso in cui si voglia effettuare il logout
     */
    @FXML
    private Button logoutButton;

    /**
     * Button per la gestione del caso in cui si voglia entrare in una tratta
     */
    @FXML
    private Button enterTratteButton;

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

        sendSMSToggleButton.setOnAction(e ->{
            changeState();
        });

        enterTratteButton.setOnAction(event -> {
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = loader.load(new FileInputStream(fileNameMostraTratta));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            MostraTratte showTratte = loader.getController();
            showTratte.setTipoAccesso("Auto");
            showTratte.setAutoveicolo(this.autoveicolo);

            Stage loginStage = new Stage();
            loginStage.setTitle("SICVE");
            loginStage.setScene(new Scene(root, 810, 400));
            loginStage.show();
        });
    }

    //SETTER

    /**
     * Setter dell' autoveicolo corrente
     * @param autoveicolo Autoveicolo corrente
     */
    public void setAutoveicolo(Autoveicolo autoveicolo) {
        this.autoveicolo = autoveicolo;
    }

    /**
     * Setter del saluto nella homepage dell' autoveicolo
     * @param nome nome del proprietario
     * @param cognome cognome del proprietario
     */
    @FXML
    public void setSalveLabel(String nome, String cognome) {
        nome = nome.substring(0,1).toUpperCase() + nome.substring(1);
        cognome = cognome.substring(0,1).toUpperCase() + cognome.substring(1);
        this.salveLabel.setText("Salve, " + nome + " " + cognome);
    }

    /**
     * Setter del ToggleButton per la ricezione del sms
     * @param mandaSMS variabile booleana del sms
     */
    @FXML
    public void setSendSMSToggleButton(boolean mandaSMS) {
        this.sendSMSToggleButton.setText(Boolean.toString(mandaSMS));
        this.sendSMSToggleButton.setSelected(mandaSMS);
    }

    //GETTER

    /**
     * Getter dell' autoveicolo corrente
     * @return Autoveicolo corrente
     */
    public Autoveicolo getAutoveicolo() {
        return this.autoveicolo;
    }

    //METODI

    /**
     * Metodo per il cambiamento di stato dell' opzione di ricezione del sms
     */
    public void changeState() {
        if(sendSMSToggleButton.isSelected()){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Alert!");
            alert.setContentText("Verrà inviato un SMS al numero \'" + autoveicolo.getTelefono() +"\' all' inizio della tratta, confermare la scelta?");
            Optional<ButtonType> result = alert.showAndWait();

            if(result.isPresent() && (result.get() == ButtonType.OK)){
                sendSMSToggleButton.setSelected(true);
                sendSMSToggleButton.setText("true");
                try {
                    sicveDb.changeStateMandaSMS(sicveDb.connection(), autoveicolo);
                } catch (SQLException ioException) {
                    ioException.printStackTrace();
                }
            }else {
                sendSMSToggleButton.setSelected(false);
                sendSMSToggleButton.setText("false");
            }
        }else {
            sendSMSToggleButton.setSelected(false);
            sendSMSToggleButton.setText("false");
            try {
                sicveDb.changeStateMandaSMS(sicveDb.connection(), autoveicolo);

            } catch (SQLException ioException) {
                ioException.printStackTrace();
            }
        }
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

}
