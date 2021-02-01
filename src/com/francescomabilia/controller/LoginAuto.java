package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.Proprietario;
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
    private static final String fileNameHome = "src/com/francescomabilia/view/fxml/homeAuto.fxml";

    private final SicveDb sicveDb = SicveDb.getInstance();
    Autoveicolo autoveicolo = new Autoveicolo();

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

                autoveicolo = login();
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();

                FXMLLoader loader = new FXMLLoader();
                Parent root = loader.load(new FileInputStream(fileNameHome));

                HomeAuto homeAuto = loader.getController();
                homeAuto.setAutoveicolo(autoveicolo);
                homeAuto.setSalveLabel(autoveicolo.getProprietario().getNome(), autoveicolo.getProprietario().getCognome());
                homeAuto.setSendSMSToggleButton(autoveicolo.isMandaSMS());

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

    private Autoveicolo login() throws Exception {
        ResultSet rs = sicveDb.getAuto(sicveDb.connection(), usernameTextField.getText().trim(), passwordField.getText().trim());
        Autoveicolo autoveicolo = new Autoveicolo();
        Proprietario proprietario = new Proprietario();

        while (rs.next()){
            autoveicolo.setMarca(rs.getString("marca"));
            boolean sms = switch (rs.getInt("sms")){
                case 1 -> true;
                default -> false;
            };
            autoveicolo.setMandaSMS(sms);
            autoveicolo.setTarga(rs.getString("targa"));
            autoveicolo.setModello(rs.getString("modello"));
            autoveicolo.setTelefono(rs.getString("telefono"));

            proprietario.setCap(rs.getString("cap"));
            proprietario.setCodiceFiscale(rs.getString("cf"));
            proprietario.setIndirizzo(rs.getString("via_piazza") + rs.getString("civico"));
            proprietario.setNome(rs.getString("nome"));
            proprietario.setCognome(rs.getString("cognome"));
        }
        if (autoveicolo.getTarga() == null){
            throw new Exception();
        }
        autoveicolo.setProprietario(proprietario);

        return autoveicolo;
    }
}
