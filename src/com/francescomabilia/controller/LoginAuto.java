package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.auto.Autoveicolo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAuto {
    private static final String fileName = "src/com/francescomabilia/view/fxml/sicve.fxml";

    private final SicveDb sicveDb = SicveDb.getInstance();

    @FXML
    private Button backButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLogin;

    @FXML
    public void initialize(){
        backButton.setOnAction(e ->{
            try{
                goBack();
                Stage stage = (Stage) backButton.getScene().getWindow();
                stage.close();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        });

        loginButton.setOnAction(e ->{
            try {

                login();
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream(fileName));

                Stage homePage = new Stage();
                homePage.setTitle("SICVE");
                homePage.setScene(new Scene(root, 600, 500));
                homePage.show();
            } catch (Exception ioException) {
                errorLogin.setText("Targa o password errate. Riprovare!");
            }
        });
    }

    private void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(new FileInputStream(fileName));


        Stage loginStage = new Stage();
        loginStage.setTitle("SICVE");
        loginStage.setScene(new Scene(root, 600, 500));
        loginStage.show();
    }

    private void login() throws Exception {
        ResultSet rs = sicveDb.getAuto(sicveDb.connection(), usernameTextField.getText().trim(), passwordField.getText().trim());
        Autoveicolo autoveicolo = new Autoveicolo();

        while (rs.next()){
            autoveicolo.setMarca(rs.getString("marca"));
            boolean sms = switch (rs.getInt("sms")){
                case 1 -> true;
                default -> false;
            };
            autoveicolo.setMandaSMS(sms);
            autoveicolo.setTarga(rs.getString("targa"));
        }
        if (autoveicolo.getTarga() == null){
            throw new Exception();
        }

    }
}
