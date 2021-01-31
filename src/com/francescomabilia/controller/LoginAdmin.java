package com.francescomabilia.controller;

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

public class LoginAdmin {
    private static final String fileName = "src/com/francescomabilia/view/fxml/sicve.fxml";

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
            if(usernameTextField.getText().isEmpty() || passwordField.getText().isEmpty()){
                errorLogin.setText("Username o password errate. Riprovare o registrarsi!");
            }else {
                if (true) {
                    try {
                        login();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }else {
                    errorLogin.setText("Username o password errate. Riprovare o registrarsi!");
                }
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

    private void login() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(new FileInputStream(fileName));

        Stage homePage = new Stage();
        homePage.setTitle("SICVE");
        homePage.setScene(new Scene(root, 600, 500));
        homePage.show();
    }
}
