package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.Amministratore;
import com.francescomabilia.model.Utente;
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

/**
 * Classe per la gestione della view per il login dell' amministratore
 */
public class LoginAdmin {
    /**
     * Variabile statica che rappresenta il percorso alla view della pagina di start dell' applicativo
     */
    private static final String fileName = "src/com/francescomabilia/view/fxml/sicve.fxml";

    /**
     * Variabile statica che rappresenta il percorso alla view della homepage dell' amminiestratore
     */
    private static final String fileNameHomeAdmin = "src/com/francescomabilia/view/fxml/homeAdmin.fxml";

    /**
     * Variabile per l'inizializzazione dell' istanza al database
     */
    private final SicveDb sicveDb = SicveDb.getInstance();

    /**
     * Button per la gestione del caso in cui si voglia tornare indietro
     */
    @FXML
    private Button backButton;

    /**
     * Button per la gestione del caso in cui si voglia effettuare l' accesso
     */
    @FXML
    private Button loginButton;

    /**
     * TextField utile per l' inserimento del username dell' amministratore per il login
     */
    @FXML
    private TextField usernameTextField;

    /**
     * PasswordField utile per l' inserimento della password dell' amministratore per il login
     */
    @FXML
    private PasswordField passwordField;

    /**
     * Label per l' errore di accesso
     */
    @FXML
    private Label errorLogin;

    /**
     * Questo metodo inizializza la view a cui è collegato il controller corrente
     */
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

    //METODI

    /**
     * Metodo per tornare indietro
     * @throws IOException
     */
    private void goBack() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(new FileInputStream(fileName));


        Stage loginStage = new Stage();
        loginStage.setTitle("SICVE");
        loginStage.setScene(new Scene(root, 600, 500));
        loginStage.show();
    }

    /**
     * Metodo per effettruare il login dell' amministratore
     * @throws Exception
     */
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
