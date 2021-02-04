package com.francescomabilia.db;

import com.francescomabilia.model.auto.Autoveicolo;
import com.francescomabilia.model.sensore.Autovelox;
import com.francescomabilia.model.sensore.Tutor;
import com.francescomabilia.model.tratta.Tratta;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SicveDb {
    /*Singleton - Lazy Iniziatilation*/
    private static SicveDb instance;

    private String username = "";
    private String password = "";
    private String address = "";
    private String driver = "";

    private SicveDb (){
        Properties configFile = new Properties();

        try{
            configFile.load(new FileInputStream("config.properties"));
            this.username = configFile.getProperty("username");
            this.password = configFile.getProperty("password");
            this.address = configFile.getProperty("address");
            this.driver = configFile.getProperty("driver");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static SicveDb getInstance(){
        if (instance == null){
            instance = new SicveDb();
        }
        return instance;
    }

    public Connection connection(){
        Connection connection = null;
        try {
            Class.forName(this.driver);
            connection = DriverManager.getConnection(this.address, this.username, this.password);
            System.out.println("avvenuta la connessione");
        }catch (ClassNotFoundException | SQLException e){
            if (e instanceof ClassNotFoundException){
                System.out.println("driver not found!");
            }else{
                System.out.println("connection not found!");
            }
        }
        return connection;
    }

    public ResultSet getAuto(Connection conn, String targa, String password) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = "SELECT * FROM `autoveicolo` WHERE (`targa` = ? AND `password`= ?);";
        ps = conn.prepareStatement(qry);
        ps.setString(1, targa);
        ps.setString(2, password);
        rs = ps.executeQuery();
        return rs;
    }

    public void changeStateMandaSMS(Connection connection, Autoveicolo autoveicolo) throws SQLException {
        PreparedStatement ps = null;
        String qry = "UPDATE `autoveicolo` SET `sms` = ? WHERE `autoveicolo`.`targa` = ?;";
        ps = connection.prepareStatement(qry);
        int sendSMS = 1;
        if (autoveicolo.isMandaSMS()){
            sendSMS = 0;
        }
        ps.setInt(1, sendSMS);
        ps.setString(2, autoveicolo.getTarga());
        ps.executeUpdate();
    }

    public ResultSet getAdmin(Connection conn, String username, String password) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = "SELECT * FROM `amministratore` WHERE (`username` = ? AND `password`= ?);";
        ps = conn.prepareStatement(qry);
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();
        return rs;
    }

    public ResultSet getPolizia(Connection conn, String username, String password) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = "SELECT * FROM `stazione` WHERE (`username` = ? AND `password`= ?);";
        ps = conn.prepareStatement(qry);
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.executeQuery();
        return rs;
    }

    public int insertTratta(Connection connection, Tratta tratta) throws SQLException {
        PreparedStatement ps = null;
        String qry = "INSERT INTO `tratta` (`comune`, `autostrada`, `velocita_minima`, `velocità_massima`, `kmTratta`, `direzione`) " +
                     "VALUES (?, ?, ?, ?, ?, ?);";

        ps = connection.prepareStatement(qry);

        ps.setString(1, tratta.getComune());
        ps.setString(2, tratta.getAutostrada());
        ps.setInt(3, tratta.getVelocitaMin());
        ps.setInt(4, tratta.getVelocitaMax());
        ps.setInt(5, tratta.getKmTratta());
        ps.setString(6, tratta.getDirezione());

        return ps.executeUpdate();
    }

    public List<Tratta> getTratte(Connection connection) throws SQLException{
        List<Tratta> tratte = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = "SELECT * FROM `tratta`;";
        ps = connection.prepareStatement(qry);
        rs = ps.executeQuery();
//TODO: completare costruzione tratte con tutor e autovelox
        while (rs.next()){
            Tratta t = new Tratta();

            t.setAutostrada(rs.getString("autostrada"));
            t.setComune(rs.getString("comune"));
            t.setKmTratta(rs.getInt("kmTratta"));
            t.setIdTratta(rs.getInt("id_tratta"));
            t.setVelocitaMax(rs.getInt("velocita_massima"));
            t.setVelocitaMin(rs.getInt("velocita_minima"));
            t.setDirezione(rs.getString("direzione"));
            t.setTutor(new Tutor(
                    percorrimento -> {
                        return 0;
                    },
                    percorrimento -> {
                        return t.getKmTratta()/(Duration.between(percorrimento.getOrarioUscita(), percorrimento.getOrarioEntrata()).toMinutes()/60D);
                    },
                    getAutovelox(this.connection(), t.getIdTratta())
            ));

            tratte.add(t);
        }

        return tratte;
    }

    public int updateTratta(Connection connection, Tratta oldTratta, Tratta newTratta) throws SQLException {
        PreparedStatement ps = null;
        String qry = "UPDATE `tratta` SET `comune` = ?, `autostrada` = ?, `velocita_minima` = ?, `velocita_massima` = ?," +
                                         "`kmTratta` = ?, `direzione` = ? " +
                                     "WHERE `tratta`.`id_tratta` = ?;";
        ps = connection.prepareStatement(qry);

        ps.setString(1, newTratta.getComune());
        ps.setString(2, newTratta.getAutostrada());
        ps.setInt(3, newTratta.getVelocitaMin());
        ps.setInt(4, newTratta.getVelocitaMax());
        ps.setInt(5, newTratta.getKmTratta());
        ps.setString(6, newTratta.getDirezione());
        ps.setInt(7, oldTratta.getIdTratta());

        return ps.executeUpdate();
    }

    public List<Autovelox> getAutovelox(Connection conn, int idTratta) throws SQLException {
        //Inizializzo Lista di autovelox a vuoto
        List<Autovelox> autoveloxes = new ArrayList<>();

        PreparedStatement ps = null;
        ResultSet rs = null;

        String qry = "SELECT * FROM `autovelox` WHERE (`id_tratta` = ?);";
        ps = conn.prepareStatement(qry);
        ps.setInt(1, idTratta);
        rs = ps.executeQuery();

        while (rs.next()){
            Autovelox autovelox = new Autovelox();

            autovelox.setIdAutovelox(rs.getInt("id_autovelox"));
            autovelox.setKmAutovelox(rs.getInt("posizione_km"));

            autoveloxes.add(autovelox);
        }

        return autoveloxes;
    }

    public int insertPercorrenza(Connection connection, Tratta tratta, Autoveicolo autoveicolo, LocalDateTime start, LocalDateTime end) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String s = start.format(formatter);
        String e = end.format(formatter);

        PreparedStatement ps = null;
        String qry = "INSERT INTO `percorrenza` (`id_tratta`, `orario_fine`, `orario_inizio`, `targa`) " +
                "VALUES (?, ?, ?, ?);";

        ps = connection.prepareStatement(qry);

        ps.setInt(1, tratta.getIdTratta());
        ps.setString(2, e);
        ps.setString(3, s);
        ps.setString(4, autoveicolo.getTarga());

        return ps.executeUpdate();
    }

}
