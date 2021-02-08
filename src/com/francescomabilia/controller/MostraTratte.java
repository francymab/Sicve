package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.auto.Autoveicolo;
import com.francescomabilia.model.infrazione.Infrazione;
import com.francescomabilia.model.infrazione.InfrazioneVelocitaIstantaneaBuilder;
import com.francescomabilia.model.percorrimenti.Percorrimento;
import com.francescomabilia.model.sensore.Autovelox;
import com.francescomabilia.model.sensore.SensoreIstantaneo;
import com.francescomabilia.model.sensore.Tutor;
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
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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

    //METODI
    public void generaPercorrenza(Tratta tratta) throws Exception {
        List<Infrazione> infrazioneList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println(tratta);
        System.out.println(getAutoveicolo());
        Random random = new Random();
        List<Tratta> tratte = sicveDb.getTratte(sicveDb.connection());

        LocalDateTime timeStart = LocalDateTime.now();
        Timestamp timestampTimeStart = Timestamp.valueOf(timeStart);
        String s = timeStart.format(formatter);


        int tMax = (int) (((float)tratta.getKmTratta()/(float) tratta.getVelocitaMin()) * 3600F);
        int tMin = (int) (((float)tratta.getKmTratta()/((float) tratta.getVelocitaMax()+10F)) * 3600F);

        Percorrimento percorrimento = new Percorrimento(timestampTimeStart, null, autoveicolo.getTarga(), tratta.getIdTratta());

        double velocitaMedia = tratta.getTutor().getInizio().calcolaVelocitaMedia(percorrimento);
        System.out.println("sei entrato nella tratta all' ora: " + s + " hai avuto una velocita media di : " + velocitaMedia);

        int sec = random.nextInt(tMax - tMin) + tMin;
        LocalDateTime timeEnd = LocalDateTime.now().plus(Duration.ofSeconds(sec));
        s = timeEnd.format(formatter);

        int idPercorrimento = sicveDb.insertPercorrenza(sicveDb.connection(), tratta, autoveicolo, timeStart, timeEnd);

        List<SensoreIstantaneo> autoveloxList = tratta.getTutor().getAutovelox();

        formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        int tp;
        int velocitaIstantanea;

        for (SensoreIstantaneo autovelox : autoveloxList){
            Autovelox a = (Autovelox) autovelox;

            tMax = (int) (((float)a.getKmAutovelox()/(float) tratta.getVelocitaMin()) * 3600F);
            tMin = (int) (((float)a.getKmAutovelox()/((float) tratta.getVelocitaMax()+10F)) * 3600F);

            tp = random.nextInt(tMax-tMin) + tMin;

            percorrimento.setOrarioUscita(Timestamp.valueOf(timeStart.plus(Duration.ofSeconds(tp))));
            velocitaMedia = autovelox.calcolaVelocitaMedia(percorrimento);
            velocitaIstantanea = autovelox.calcolaVelocitaIstantanea(timeStart);

            System.out.println("Sei passato all' autovelox " + autovelox + " all' istante " + timeStart.plus(Duration.ofSeconds(tp)).format(formatter) +
                               " con una velocita istantane di " + velocitaIstantanea + "km/h" +
                               " hai avuto una velocita media di : " + velocitaMedia  + "km/h");

            //CONTROLLO
            velocitaIstantanea = random.nextInt(1000) + 120;

            sicveDb.insertPercorrenzaAutovelox(sicveDb.connection(), idPercorrimento, timeStart, velocitaIstantanea);

            if (velocitaIstantanea > (tratta.getVelocitaMax())){
                String descrizione = "Superamento velocita massima della tratta";
                Tutor tutor = tratta.getTutor();
                tutor.setInfrazioneBuilder(new InfrazioneVelocitaIstantaneaBuilder());
                tutor.builderVelocitaIstantanea(a.getKmAutovelox(), descrizione, autoveicolo.getTarga(), velocitaIstantanea, tratta.getIdTratta());
                sicveDb.insertInfrazione(sicveDb.connection(), descrizione, tratta.getIdTratta(), a.getIdAutovelox(), autoveicolo.getTarga(), velocitaIstantanea);
                
                infrazioneList.add(tutor.getInfrazioneBuilder().getResult());
                System.out.println(tutor);
            }
        }

        percorrimento.setOrarioUscita(Timestamp.valueOf(timeEnd));
        velocitaMedia = tratta.getTutor().getFine().calcolaVelocitaMedia(percorrimento);

        System.out.println("sei uscito dalla tratta all' ora: " + s + " hai avuto una velocita media di : " + velocitaMedia);
        tratta.getPercorrimento().add(percorrimento);
        
        if (infrazioneList.size() > 2){
            System.out.println(getInfrazione(infrazioneList));
        }
    }
    
    private List<Infrazione> getInfrazione(List<Infrazione> infrazioni) throws Exception{
        List<Infrazione> infraziones = new ArrayList<>();
        Infrazione maxInfrazione = infrazioni.get(0);
        System.out.println("===============" + infrazioni);
        System.out.println("================= " + maxInfrazione.getIdTratta());
        Tratta tratta = sicveDb.getTratta(sicveDb.connection(), maxInfrazione.getIdTratta());
        System.out.println(tratta);
        return infraziones;
    }
}
