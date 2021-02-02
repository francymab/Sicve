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

public class HomeAuto {
    private static final String fileName = "src/com/francescomabilia/view/fxml/loginAuto.fxml";
    Autoveicolo autoveicolo = new Autoveicolo();
    private final SicveDb sicveDb = SicveDb.getInstance();


    @FXML
    private Label salveLabel;

    @FXML
    private ToggleButton sendSMSToggleButton;

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

        sendSMSToggleButton.setOnAction(e ->{
            changeState();
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

    public void setAutoveicolo(Autoveicolo autoveicolo) {
        this.autoveicolo = autoveicolo;
    }

    public Autoveicolo getAutoveicolo() {
        return this.autoveicolo;
    }

    @FXML
    public void setSalveLabel(String nome, String cognome) {
        nome = nome.substring(0,1).toUpperCase() + nome.substring(1);
        cognome = cognome.substring(0,1).toUpperCase() + cognome.substring(1);
        this.salveLabel.setText("Salve, " + nome + " " + cognome);
    }

    @FXML
    public void setSendSMSToggleButton(boolean mandaSMS) {
        this.sendSMSToggleButton.setText(Boolean.toString(mandaSMS));
        this.sendSMSToggleButton.setSelected(mandaSMS);
    }

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
}
