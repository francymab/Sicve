package com.francescomabilia;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.infrazione.Multa;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void init(){
        SicveDb sicveDb = SicveDb.getInstance();
        try {
            sicveDb.getMulte(sicveDb.connection());
            System.out.println(Multa.counter);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("view/fxml/sicve.fxml"));
        primaryStage.setTitle("SICVE");
        primaryStage.setScene(new Scene(root, 500, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop(){

    }

}
