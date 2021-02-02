package com.francescomabilia.db;

import com.francescomabilia.model.auto.Autoveicolo;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.sql.*;
import java.util.Properties;

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
        String qry = "SELECT * FROM autoveicolo WHERE (targa = ? AND password= ?);";
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
        String qry = "SELECT * FROM amministratore WHERE (username = ? AND password= ?);";
        ps = conn.prepareStatement(qry);
        ps.setString(1, username);
        ps.setString(2, password);
        System.out.println(username + password);
        rs = ps.executeQuery();
        return rs;
    }
}
