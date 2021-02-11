package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.sensore.Autovelox;
import com.francescomabilia.model.sensore.SensoreIstantaneo;
import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

/**
 * Classe per la gestione della view per mostrare la lista degli autovelox
 */
public class MostraAutovelox {
    /**
     * Variabile statica che rappresenta il percorso alla view della pagina di aggiunta di un autovelox
     */
    private static final String fileNameAddAutovelox = "src/com/francescomabilia/view/fxml/aggiungiAutovelox.fxml";

    /**
     * Variabile per l'inizializzazione dell' istanza al database
     */
    private final SicveDb sicveDb = SicveDb.getInstance();
    Tratta tratta;

    /**
     * ListView per la visualizzazione degli autovelox
     */
    @FXML
    private ListView<SensoreIstantaneo> autoveloxListView;

    /**
     * Button per la gestione del caso in cui si voglia aggiungere un autovelox
     */
    @FXML
    private Button addAutoveloxButton;

    @FXML
    private BorderPane borderPane;

    public void init(){
        autoveloxListView.getItems().setAll(this.tratta.getTutor().getAutovelox());

        addAutoveloxButton.setOnAction(e ->{
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.initOwner(borderPane.getScene().getWindow());
            dialog.setTitle("Aggiungi una nuova tratta");
            dialog.setHeaderText("Inserire i dati della nuovo autovelox:");
            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = loader.load(new FileInputStream(fileNameAddAutovelox));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            dialog.getDialogPane().setContent(root);

            dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

            Optional<ButtonType> result = dialog.showAndWait();
            if (result.get() == ButtonType.OK){
                AggiungiAutovelox controller = loader.getController();
                Autovelox newAutovelox = controller.addAutovelox();

                int i = 0;
                try {
                    i = sicveDb.insertAutovelox(sicveDb.connection(), newAutovelox, this.tratta);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                if (i == 0){
                    try {
                        throw new Exception();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
                System.out.println(this.tratta.getTutor().getAutovelox());
                autoveloxListView.getItems().setAll(this.tratta.getTutor().getAutovelox());
            }

        });
    }

    /**
     * Questo metodo inizializza la view a cui è collegato il controller corrente
     */
    @FXML
    public void initialize() {

    }

    //SETTER

    /**
     * Setter della tratta corrente
     * @param tratta Tratta
     */
    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

}
