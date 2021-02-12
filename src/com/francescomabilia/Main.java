package com.francescomabilia;

import com.francescomabilia.db.SicveDb;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.SQLException;

/**
 * La classe Main ha la responsabilità di lanciare l'applizione in modalità finestra, gestendo alcune responsabilità
 * come il comportamento che questa deve avere, quando viene:
 *
 * - inizializzata (init)
 * - lanciata (start)
 * - chiusa (stop)
 *
 */
public class Main extends Application {

    /**
     * Metodo Triggerato non appena viene inizializzata l'applicazione, ereditato da application
     */
    @Override
    public void init(){
        SicveDb sicveDb = SicveDb.getInstance();
        try {
            sicveDb.getMulte(sicveDb.connection());
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * @param primaryStage Stage primario da renderizzare
     * @exception Exception Il metodo start può lanciare un'eccezione
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/fxml/sicve.fxml"));
        primaryStage.setTitle("SICVE");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

    /**
     * @param args
     * Entry point di qualsiasi programma java, in questo caso della nostra applicazione*/
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Metodo Triggerato non appena viene stoppata l'applicazione, ereditato da application
     */
    @Override
    public void stop(){

    }

}
