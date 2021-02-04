package com.francescomabilia.controller;

import com.francescomabilia.db.SicveDb;
import com.francescomabilia.model.sensore.Autovelox;
import com.francescomabilia.model.sensore.SensoreIstantaneo;
import com.francescomabilia.model.tratta.Tratta;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MostraAutovelox {
    Tratta tratta;

    @FXML
    private ListView<SensoreIstantaneo> autoveloxListView;

    public void init() {
        autoveloxListView.getItems().setAll(this.tratta.getTutor().getAutovelox());
    }

    @FXML
    public void initialize() {

    }

    //SETTER
    public void setTratta(Tratta tratta) {
        this.tratta = tratta;
    }

}
