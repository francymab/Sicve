package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.auto.Autoveicolo;
import com.francescomabilia.model.percorrimenti.Percorrimento;
import com.francescomabilia.model.sensore.Autovelox;
import com.francescomabilia.model.sensore.SensoreIstantaneo;
import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class MostraTratte {
    private static final String fileNameAddTratta = "src/com/francescomabilia/view/fxml/aggiungiTratta.fxml";
    private static final String fileNameMostraAutovelox = "src/com/francescomabilia/view/fxml/mostraAutovelox.fxml";

    private final SicveDb sicveDb = SicveDb.getInstance();
    Autoveicolo autoveicolo;
    private String tipoAccesso;

    @FXML
    private ListView<Tratta> tratteListView;

    @FXML
    private ContextMenu contextMenu;

    @FXML
    private BorderPane borderPane;


    @FXML
    public void initialize() throws SQLException {

        contextMenu = new ContextMenu();
        MenuItem updateMenuItem = new MenuItem("Modifica");
        MenuItem enterMenuItem = new MenuItem("Entra");
        MenuItem autoveloxMenuItem = new MenuItem("Autovelox");

        updateMenuItem.setOnAction(e -> {
            Tratta tratta = tratteListView.getSelectionModel().getSelectedItem();
            try {
                updateTratta(tratta);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        enterMenuItem.setOnAction(e -> {
            Tratta tratta = tratteListView.getSelectionModel().getSelectedItem();

            try {
                generaPercorrenza(tratta);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });

        autoveloxMenuItem.setOnAction(e ->{
            Tratta tratta = tratteListView.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = loader.load(new FileInputStream(fileNameMostraAutovelox));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            MostraAutovelox mostraAutovelox = loader.getController();
            mostraAutovelox.setTratta(tratta);
            mostraAutovelox.init();

            Stage loginStage = new Stage();
            loginStage.setTitle("SICVE");
            loginStage.setScene(new Scene(root, 810, 400));
            loginStage.show();
        });

        contextMenu.getItems().addAll(updateMenuItem, enterMenuItem, autoveloxMenuItem);

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
                    if (getTipoAccesso().equals("Auto")){
                        autoveloxMenuItem.setDisable(true);
                        updateMenuItem.setDisable(true);
                    }else {
                        enterMenuItem.setDisable(true);
                    }
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

    //SETTER
    public void setTipoAccesso(String tipoAccesso) {
        this.tipoAccesso = tipoAccesso;
    }

    public void setAutoveicolo(Autoveicolo autoveicolo) {
        this.autoveicolo = autoveicolo;
    }

    //GETTER
    public String getTipoAccesso() {
        return this.tipoAccesso;
    }

    public Autoveicolo getAutoveicolo() {
        return autoveicolo;
    }

//TODO: controllare valori da generare per le velocita elevate 
    //METODI
    public void generaPercorrenza(Tratta tratta) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println(tratta);
        System.out.println(getAutoveicolo());
        Random random = new Random();
        List<Tratta> tratte = sicveDb.getTratte(sicveDb.connection());

        int velocita = random.nextInt(tratta.getVelocitaMax() - tratta.getVelocitaMin()) + 80 + random.nextInt(15);
        LocalDateTime timeStart = LocalDateTime.now();
        Timestamp timestampTimeStart = Timestamp.valueOf(timeStart);
        System.out.println("timesStamp enter : " + timestampTimeStart);
        String s = timeStart.format(formatter);


        int tMax = (int) (((float)tratta.getKmTratta()/(float) tratta.getVelocitaMin()) * 3600F);
        int tMin = (int) (((float)tratta.getKmTratta()/(float) tratta.getVelocitaMax()) * 3600F);




        Percorrimento percorrimento = new Percorrimento(timestampTimeStart, null, autoveicolo.getTarga(), tratta.getIdTratta());

        double velocitaMedia = tratta.getTutor().getInizio().calcolaVelocitaMedia(percorrimento);
        System.out.println("sei entrato con una velocita di: " + velocita + " all' ora: " + s + " hai avuto una velocita media di : " + velocitaMedia);



        int sec = random.nextInt(tMax - tMin) + tMin;
        LocalDateTime timeEnd = LocalDateTime.now().plus(Duration.ofSeconds(sec));
        s = timeEnd.format(formatter);

        int idPercorrimento = sicveDb.insertPercorrenza(sicveDb.connection(), tratta, autoveicolo, timeStart, timeEnd);

        List<SensoreIstantaneo> autoveloxList = tratta.getTutor().getAutovelox();

        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        int t = sec/(autoveloxList.size()+1);
        int tp = 0;
        int z = random.nextInt(9) + 3;

        for (SensoreIstantaneo autovelox : autoveloxList){
            int i = 0; 
            if (i%2 == 0){
                tp += t + z;
            }else {
                tp += t-z;
                z = random.nextInt(9) + 3;
            }
            percorrimento.setOrarioUscita(Timestamp.valueOf(timeStart.plus(Duration.ofSeconds(tp))));
            System.out.println("uscita" + percorrimento.getOrarioUscita());
            velocitaMedia = autovelox.calcolaVelocitaMedia(percorrimento);
            System.out.println("Sei passato all' autovelox " + autovelox + " all' istante " + timeStart.plus(Duration.ofSeconds(tp)).format(formatter)  + " hai avuto una velocita media di : " + velocitaMedia);
            //autovelox.calcolaVelocitaIstantanea(timeStart.plus(Duration.ofSeconds(tp)));

            i++;
        }

        percorrimento.setOrarioUscita(Timestamp.valueOf(timeEnd));
        velocitaMedia = tratta.getTutor().getFine().calcolaVelocitaMedia(percorrimento);

        System.out.println("sei uscito dalla tratta all' ora: " + s + " hai avuto una velocita media di : " + velocitaMedia);
        tratta.getPercorrimento().add(percorrimento);
    }
}
