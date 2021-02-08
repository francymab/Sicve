package com.francescomabilia.db;

import com.francescomabilia.model.infrazione.Infrazione;

import java.sql.SQLException;

public class InfrazioneIstantaneaStrategy implements InfrazioneStrategy{
    @Override
    public void salvaInfrazione(Infrazione infrazione) throws SQLException {
        SicveDb sicveDb = SicveDb.getInstance();
        sicveDb.insertInfrazioneIstantanea(sicveDb.connection(), infrazione);
    }
}
