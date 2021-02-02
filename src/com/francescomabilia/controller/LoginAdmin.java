package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.Amministratore;
import com.francescomabilia.model.Utente;
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

public class LoginAdmin {
    private static final String fileName = "src/com/francescomabilia/view/fxml/sicve.fxml";
    private static final String fileNameHomeAdmin = "src/com/francescomabilia/view/fxml/homeAdmin.fxml";

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
            try{
                login();
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();
                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream(fileNameHomeAdmin));

                Stage homePage = new Stage();
                homePage.setTitle("SICVE");
                homePage.setScene(new Scene(root, 600, 500));
                homePage.show();
            }catch (Exception exception){
                errorLogin.setText("Username o password errate. Riprovare!");
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
        ResultSet rs = sicveDb.getAdmin(sicveDb.connection(), usernameTextField.getText().trim(), passwordField.getText().trim());
        Utente amministratore = new Amministratore();

        while(rs.next()){
            amministratore.setUsername(rs.getString("username"));
            amministratore.setPassword(rs.getString("password"));
        }

        if (amministratore.getUsername() == null){
            throw new Exception();
        }
    }
}
