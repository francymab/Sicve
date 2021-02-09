package com.francescomabilia.controller;

import com.francescomabilia.model.infrazione.Multa;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import java.sql.SQLException;

public class MostraMulte {

    @FXML
    private ListView<Multa> multaListView;

    @FXML
    public void initialize() throws SQLException {

//        multaListView.getItems().setAll();
//        multaListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

    }
}
