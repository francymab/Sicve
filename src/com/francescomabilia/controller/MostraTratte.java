package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.Optional;

public class MostraTratte {
    private static final String fileNameAddTratta = "src/com/francescomabilia/view/fxml/aggiungiTratta.fxml";

    private final SicveDb sicveDb = SicveDb.getInstance();

    @FXML
    private ListView<Tratta> tratteListView;

    @FXML
    private ContextMenu contextMenu;

    @FXML
    private BorderPane borderPane;

    public void initialize() throws SQLException {

        contextMenu = new ContextMenu();
        MenuItem updateMenuItem = new MenuItem("Modifica");
        updateMenuItem.setOnAction(e -> {
            Tratta tratta = tratteListView.getSelectionModel().getSelectedItem();
            try {
                updateTratta(tratta);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        contextMenu.getItems().addAll(updateMenuItem);

        tratteListView.getItems().setAll(sicveDb.getTratte(sicveDb.connection()));
        tratteListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        tratteListView.setCellFactory((param) ->{
            ListCell<Tratta> cell = new ListCell<Tratta>(){
                @Override
                protected void updateItem(Tratta item, boolean empty) {
                    super.updateItem(item, empty);
                    if(empty){
                        setText(null);
                    }else {
                        setText(item.toString());
                    }
                }
            };

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) ->{
                if (isNowEmpty){
                    cell.setContextMenu(null);
                }else{
                    cell.setContextMenu(contextMenu);
                }
            });

            return cell;
        });
    }

    public void updateTratta(Tratta oldTratta) throws Exception {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(borderPane.getScene().getWindow());
        dialog.setTitle("Aggiungi una nuova tratta");
        dialog.setHeaderText("Inserire i nuvi dati della nuova tratta:");
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(new FileInputStream(fileNameAddTratta));
        dialog.getDialogPane().setContent(root);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Aggiornamento!");
            alert.setContentText("Sicuro di voler aggiornare la tratta: " + oldTratta);
            result = alert.showAndWait();
            if(result.isPresent() && result.get() == ButtonType.OK) {
                AggiungiTratta controller = loader.getController();
                Tratta newTratta = controller.addTratta();

                int i = sicveDb.updateTratta(sicveDb.connection(), oldTratta, newTratta);

                if (i == 0){
                    throw new Exception();
                }
                tratteListView.getItems().setAll(sicveDb.getTratte(sicveDb.connection()));
            }
        }
    }
}