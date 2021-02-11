package com.francescomabilia.controller;

import com.francescomabilia.db.InfrazioneIstantaneaStrategy;
import com.francescomabilia.db.InfrazioneMediaStrategy;
import com.francescomabilia.db.InfrazioneStrategy;
import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.auto.Autoveicolo;
import com.francescomabilia.model.infrazione.Infrazione;
import com.francescomabilia.model.infrazione.InfrazioneVelocitaIstantaneaBuilder;
import com.francescomabilia.model.infrazione.InfrazioneVelocitaMediaBuilder;
import com.francescomabilia.model.infrazione.Multa;
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
    private static final String fileNameMostraStatistiche = "src/com/francescomabilia/view/fxml/mostraStatistiche.fxml";

    /**
     * Variabile per l'inizializzazione dell' istanza al database
     */
    private final SicveDb sicveDb = SicveDb.getInstance();
    Autoveicolo autoveicolo;
    private String tipoAccesso;

    /**
     * ListView delle tratte
     */
    @FXML
    private ListView<Tratta> tratteListView;

    /**
     * Menu di scelta delle operazioni sulle tratte
     */
    @FXML
    private ContextMenu contextMenu;

    @FXML
    private BorderPane borderPane;

    /**
     * Questo metodo inizializza la view a cui è collegato il controller corrente
     */
    @FXML
    public void initialize() throws SQLException {

        contextMenu = new ContextMenu();
        MenuItem updateMenuItem = new MenuItem("Modifica");
        MenuItem enterMenuItem = new MenuItem("Entra");
        MenuItem autoveloxMenuItem = new MenuItem("Autovelox");
        MenuItem statisticheMenuItem = new MenuItem("Statistiche");

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

        statisticheMenuItem.setOnAction(e->{
            Tratta tratta = tratteListView.getSelectionModel().getSelectedItem();

            FXMLLoader loader = new FXMLLoader();
            Parent root = null;
            try {
                root = loader.load(new FileInputStream(fileNameMostraStatistiche));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            MostraStatistiche mostraStatistiche = loader.getController();
            mostraStatistiche.init(tratta);

            Stage loginStage = new Stage();
            loginStage.setTitle("SICVE");
            loginStage.setScene(new Scene(root, 810, 400));
            loginStage.show();
        });

        contextMenu.getItems().addAll(updateMenuItem, enterMenuItem, autoveloxMenuItem, statisticheMenuItem);

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
                        statisticheMenuItem.setDisable(true);
                    }else {
                        enterMenuItem.setDisable(true);
                    }
                }
            });

            return cell;
        });
    }

    //SETTER

    /**
     * Setter del tipo dell' accesso
     * @param tipoAccesso Tipo Accesso
     */
    public void setTipoAccesso(String tipoAccesso) {
        this.tipoAccesso = tipoAccesso;
    }

    /**
     * Setter dell' autoveicolo
     * @param autoveicolo Autoveicolo
     */
    public void setAutoveicolo(Autoveicolo autoveicolo) {
        this.autoveicolo = autoveicolo;
    }

    //GETTER

    /**
     * Getter del tipo di accesso
     * @return tipo di accesso
     */
    public String getTipoAccesso() {
        return this.tipoAccesso;
    }

    /**
     * Getter dell' autoveicolo
     * @return autoveicolo
     */
    public Autoveicolo getAutoveicolo() {
        return autoveicolo;
    }

    //METODI

    /**
     * Metodo di generazione di una percorrenza data una tratta
     * @param tratta Tratta
     * @throws Exception
     */
    public void generaPercorrenza(Tratta tratta) throws Exception {
        List<Infrazione> infrazioneList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println(tratta);
        System.out.println(getAutoveicolo());
        Tutor tutor = tratta.getTutor();

        Random random = new Random();

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
//        int i = 0;

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

//            //CONTROLLO
//            if(i != 0) {
//                velocitaIstantanea = random.nextInt(1000) + 120;
//            }
//            i++;

            sicveDb.insertPercorrenzaAutovelox(sicveDb.connection(), idPercorrimento, timeStart, velocitaIstantanea);

            //velocita istantanea
            if (velocitaIstantanea > (tratta.getVelocitaMax())){
                String descrizione = "Superamento velocita massima della tratta";
                tutor.setInfrazioneBuilder(new InfrazioneVelocitaIstantaneaBuilder());
                tutor.builderVelocitaIstantanea(a.getKmAutovelox(), descrizione, autoveicolo.getTarga(), velocitaIstantanea, tratta.getIdTratta(), a.getIdAutovelox());

                infrazioneList.add(tutor.getInfrazioneBuilder().getResult());

            }
        }

        percorrimento.setOrarioUscita(Timestamp.valueOf(timeEnd));
        velocitaMedia = tratta.getTutor().getFine().calcolaVelocitaMedia(percorrimento);

        //velocita media
        if (velocitaMedia > (tratta.getVelocitaMax())){
            String descrizione = "Superamento velocita media della tratta";
            tutor.setInfrazioneBuilder(new InfrazioneVelocitaMediaBuilder());
            tutor.builderVelocitaMedia(tratta.getKmTratta(), descrizione, autoveicolo.getTarga(), velocitaMedia, tratta.getIdTratta());

            infrazioneList.add(tutor.getInfrazioneBuilder().getResult());
        }

        System.out.println("sei uscito dalla tratta all' ora: " + s + " hai avuto una velocita media di : " + velocitaMedia);
        tratta.getPercorrimento().add(percorrimento);
        
        if (infrazioneList.size() > 2){
            List<Infrazione> infrazionePeggioreList = getInfrazione(infrazioneList);
            InfrazioneStrategy infrazioneStrategy;
            for (Infrazione infrazione : infrazionePeggioreList) {
                infrazione.setIdInfrazione(Multa.counter+1);
                try{
                    infrazioneStrategy = new InfrazioneIstantaneaStrategy();
                    infrazioneStrategy.salvaInfrazione(infrazione);

                }catch (Exception sqlException){
                    infrazioneStrategy = new InfrazioneMediaStrategy();
                    infrazioneStrategy.salvaInfrazione(infrazione);
                }

            }
            Multa.counter++;
        }
    }

    /**
     * Metodo per il calcolo della lista di infrazioni peggiori
     * @param infrazioni Lista di infrazioni
     * @return Lista di infrazioni peggiori
     * @throws Exception
     */
    private List<Infrazione> getInfrazione(List<Infrazione> infrazioni) throws Exception{
        List<Infrazione> infraziones = new ArrayList<>();
        int velocitaMaxTratta = sicveDb.getTratta(sicveDb.connection(), infrazioni.get(0).getIdTratta()).getVelocitaMax();
        int indMax=0;

        double valueMax = 0D;
        double value = 0D;

        for (int i = 0; i < infrazioni.size(); i++){
            Infrazione infrazione = infrazioni.get(i);

            if (infrazione.getVelocitaIstantanea() != null) {
                value = (infrazione.getVelocitaIstantanea() - velocitaMaxTratta) * Infrazione.PREZZO_ISTANTANEA;
            }else{
                value = (infrazione.getVelocitaMedia() - velocitaMaxTratta) * Infrazione.PREZZO_MEDIA;
            }

            if (valueMax < value) {
                indMax = i;
            }

            if (((i + 1) % 3 == 0)) {
                infraziones.add(infrazioni.get(indMax));
                indMax = i + 1;
            }
        }

        return infraziones;
    }


    /**
     * Metodo per aggiornare una tratta
     * @param oldTratta Vecchia tratta
     * @throws Exception
     */
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
