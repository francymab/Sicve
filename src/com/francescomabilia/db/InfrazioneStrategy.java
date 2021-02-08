package com.francescomabilia.db;

import com.francescomabilia.model.infrazione.Infrazione;

import java.sql.SQLException;

public interface InfrazioneStrategy{
    void salvaInfrazione(Infrazione infrazione) throws SQLException;
}
