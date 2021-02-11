package com.francescomabilia.db;

import com.francescomabilia.model.auto.Autoveicolo;
import com.francescomabilia.model.infrazione.Infrazione;
import com.francescomabilia.model.infrazione.Multa;
import com.francescomabilia.model.percorrimenti.Percorrimento;
import com.francescomabilia.model.sensore.Autovelox;
import com.francescomabilia.model.sensore.SensoreIstantaneo;
import com.francescomabilia.model.sensore.Tutor;
import com.francescomabilia.model.tratta.Tratta;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Questa classe si occupa di utilizzare un database. Inoltre vi è applicato un singleton
 * Che restituisce una singola istanza per evitare la costruzione di molteplici db
 */
public class SicveDb {
    /*Singleton - Lazy Iniziatilation*/
    private static SicveDb instance;

    private String username = "";
    private String password = "";
    private String address = "";
    private String driver = "";

    /**
     * Metodo costruttore privato volto alla realizzazione di un Singleton Pattern
     * */
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

    /**
     * Metodo atto a ritornare la singola istanza di TaxiFinderData (Singleton - versione Lazy)
     * @return Istanza di SicveDb (singleton)
     * */
    public static SicveDb getInstance(){
        if (instance == null){
            instance = new SicveDb();
        }
        return instance;
    }

    /**
     * Metodo per la connessione al database
     * @return Connessione al database
     */
    public Connection connection(){
        Connection connection = null;
        try {
            Class.forName(this.driver);
            connection = DriverManager.getConnection(this.address, this.username, this.password);
        }catch (ClassNotFoundException | SQLException e){
            if (e instanceof ClassNotFoundException){
                System.out.println("driver not found!");
            }else{
                System.out.println("connection not found!");
            }
        }
        return connection;
    }

    /**
     * Metodo per la selezione dell' autoveicolo giusto dal database
     * @param conn connection al databasse
     * @param targa Targa dell' autoveicolo
     * @param password Password dell' autoveicolo
     * @return Resultset con le informazioni del db dell' autoveicolo selezionato
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
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

    /**
     * Metodo per il cambiamento dell' opzione di sms nel db dell' autoveicolo corrente
     * @param connection Connection al db
     * @param autoveicolo Autoveicolo corrente
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
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

    /**
     * Metodo per la selezione dell' amministratore giusto dal database
     * @param conn Connection al db
     * @param username Username dell' amministratore
     * @param password Password dell' amministratore
     * @return Resultset con le informazioni del db dell' amministratore selezionato
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
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

    /**
     * Metodo per la selezione della polizia giusto dal database
     * @param conn Connection al db
     * @param username Username della polizia
     * @param password Password della polizia
     * @return Resultset con le informazioni del db della polizia selezionato
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
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

    /**
     * Metodo per l' inserimento di una nuova tratta nel db
     * @param connection Connection al db
     * @param tratta Nuova tratta da inserire nel db
     * @return 0 se la query non ha avuto esito positivo, altrimenti n!=0
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public int insertTratta(Connection connection, Tratta tratta) throws SQLException {
        PreparedStatement ps = null;
        String qry = "INSERT INTO `tratta` (`comune`, `autostrada`, `velocita_minima`, `velocita_massima`, `kmTratta`, `direzione`) " +
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

    /**
     * Metodo per visualizzare tutte le tratte contenute nel db
     * @param connection Connection al db
     * @return Lista di tratte
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public List<Tratta> getTratte(Connection connection) throws SQLException{
        List<Tratta> tratte = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = "SELECT * FROM `tratta`;";
        ps = connection.prepareStatement(qry);
        rs = ps.executeQuery();

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
                        return Math.abs(t.getKmTratta()/(Duration.between(percorrimento.getOrarioUscita().toInstant(), percorrimento.getOrarioEntrata().toInstant()).toMinutes()/60D));
                    },
                    getAutovelox(this.connection(), t.getIdTratta())
            ));
            t.setPercorrimento(getPercorrenza(connection(), t.getIdTratta()));

            tratte.add(t);
        }

        return tratte;
    }

    /**
     * Metodo per aggiornare una tratta gia esistente
     * @param connection Connection al db
     * @param oldTratta Vecchia tratta
     * @param newTratta Nuova tratta
     * @return 0 se la query non ha avuto esito positivo, altrimenti n!=0
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
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

    /**
     * Metodo per vedere la lista di autovelox appartenenti ad una determinata tratta
     * @param conn Connection al db
     * @param idTratta Id della tratta selezionata
     * @return Lista degli autovelox appartenenti a quella tratta
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public List<SensoreIstantaneo> getAutovelox(Connection conn, int idTratta) throws SQLException {
        //Inizializzo Lista di autovelox a vuoto
        List<SensoreIstantaneo> autoveloxes = new ArrayList<>();

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

    /**
     * Metodo per l' inserimento di una percorrenza di una tratta e ricezione dal db dell' id di quest'ultima
     * @param connection Connection al db
     * @param tratta Tratta percorsa
     * @param autoveicolo Autoveicolo che l' ha percorsa
     * @param start Orario e tempo di entrata
     * @param end  Orario e tempo di uscita
     * @return Id della percorrenza appena inserita
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public int insertPercorrenza(Connection connection, Tratta tratta, Autoveicolo autoveicolo, LocalDateTime start, LocalDateTime end) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String s = start.format(formatter);
        String e = end.format(formatter);

        PreparedStatement ps = null;
        int id = 0;
        String qry = "INSERT INTO `percorrenza` (`id_tratta`, `orario_fine`, `orario_inizio`, `targa`) " +
                     "VALUES (?, ?, ?, ?);";

        ps = connection.prepareStatement(qry);

        ps.setInt(1, tratta.getIdTratta());
        ps.setString(2, e);
        ps.setString(3, s);
        ps.setString(4, autoveicolo.getTarga());

        int i = ps.executeUpdate();

        if (i != 0){
            ResultSet rs = null;
            String qrys = "SELECT id_percorrenza FROM `percorrenza` WHERE (`id_tratta` = ? AND `orario_fine` = ? AND `orario_inizio` = ? AND `targa` = ?)";
            ps = connection.prepareStatement(qrys);
            ps.setInt(1, tratta.getIdTratta());
            ps.setString(2, e);
            ps.setString(3, s);
            ps.setString(4, autoveicolo.getTarga());
            rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id_percorrenza");
            }
        }

        return id;
    }

    /**
     * Metodo per l' inserimento di una percorrenza di un autovelox
     * @param connection Connection al db
     * @param idPercorrenza Id della percorrenza corrente
     * @param start Orario e tempo di entrata
     * @param velocita Velocita istantanea
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public void insertPercorrenzaAutovelox(Connection connection, int idPercorrenza, LocalDateTime start, int velocita) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String s = start.format(formatter);

        PreparedStatement ps = null;
        String qry = "INSERT INTO `percorrenza_autovelox` (`id_percorrenza`, `istante_rilevamento`, `velocita`) " +
                "VALUES (?, ?, ?);";

        ps = connection.prepareStatement(qry);

        ps.setInt(1, idPercorrenza);
        ps.setString(2, s);
        ps.setInt(3, velocita);

        int i = ps.executeUpdate();
        if (i == 0){
            throw new SQLException();
        }
    }

    /**
     * Metodo per vedere la lista delle percorrenze di una tratta
     * @param connection Connection al db
     * @param idTratta Id della tratta
     * @return Lista delle percorrenze
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public List<Percorrimento> getPercorrenza(Connection connection, int idTratta) throws SQLException{
        List<Percorrimento> percorrimentoList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = "SELECT * FROM `percorrenza` WHERE  id_tratta = ?";
        ps = connection.prepareStatement(qry);
        ps.setInt(1, idTratta);
        rs = ps.executeQuery();

        while(rs.next()){
            Percorrimento percorrimento = new Percorrimento();

            percorrimento.setOrarioEntrata(rs.getTimestamp("orario_inizio"));
            percorrimento.setOrarioUscita((rs.getTimestamp("orario_fine")));
            percorrimento.setIdTratta(rs.getInt("id_tratta"));
            percorrimento.setTarga(rs.getString("targa"));

            percorrimentoList.add(percorrimento);
        }

        return percorrimentoList;
    }

    /**
     * Metodo per l' inserimento di un nuovo autovelox in una determinata tratta
     * @param connection Connection al db
     * @param autovelox Autovelox da inserire
     * @param tratta Tratta a cui aggiungere l' autovelox
     * @return 0 se la query non ha avuto esito positivo, altrimenti n!=0
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public int insertAutovelox(Connection connection, Autovelox autovelox, Tratta tratta) throws SQLException{
        System.out.println(autovelox);
        PreparedStatement ps = null;
        String qry = "INSERT INTO `autovelox` (`id_tratta`, `id_autovelox`, `posizione_km`) " +
                     "VALUES (?, ?, ?);";

        ps = connection.prepareStatement(qry);

        ps.setInt(1, tratta.getIdTratta());
        ps.setInt(2, autovelox.getIdAutovelox());
        ps.setInt(3, autovelox.getKmAutovelox());

        int i = ps.executeUpdate();
        if (i != 0) {
            tratta.setTutor(new Tutor(
                    percorrimento -> {
                        return 0;
                    },
                    percorrimento -> {
                        return Math.abs(tratta.getKmTratta() / (Duration.between(percorrimento.getOrarioUscita().toInstant(), percorrimento.getOrarioEntrata().toInstant()).toMinutes() / 60D));
                    },
                    getAutovelox(this.connection(), tratta.getIdTratta())
            ));
        }else {
            throw new SQLException();
        }

        return i;
    }

    /**
     * Metodo per l' inserimento dell' infrazione per velocita istantanea
     * @param connection Connection al db
     * @param infrazione Infrazione
     * @throws Exception Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public void insertInfrazioneIstantanea(Connection connection, Infrazione infrazione) throws Exception{
        PreparedStatement ps = null;
        String qry = "INSERT INTO `infrazione` (`id_tratta`, `id_autovelox`, `descrizione`, `targa`, `velocita_istantanea`, `id_infrazione`) " +
                "VALUES (?, ?, ?, ?, ?, ?);";

        ps = connection.prepareStatement(qry);

        ps.setInt(1, infrazione.getIdTratta());
        ps.setInt(2, infrazione.getIdAutovelox());
        ps.setString(3, infrazione.getDescrizione());
        ps.setString(4, infrazione.getTarga());
        ps.setInt(5, infrazione.getVelocitaIstantanea());
        ps.setInt(6, infrazione.getIdInfrazione());

        int i = ps.executeUpdate();
        if (i == 0){
            throw new SQLException();
        }
    }

    /**
     * Metodo per l' inserimento dell' infrazione per velocita media
     * @param connection Connection al db
     * @param infrazione Infrazione
     * @throws Exception Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public void insertInfrazioneMedia(Connection connection, Infrazione infrazione) throws Exception{
        PreparedStatement ps = null;
        String qry = "INSERT INTO `infrazione` (`id_tratta`, `descrizione`, `targa`, `velocita_media`, `id_infrazione`) " +
                "VALUES (?, ?, ?, ?, ?);";

        ps = connection.prepareStatement(qry);

        ps.setInt(1, infrazione.getIdTratta());
        ps.setString(2, infrazione.getDescrizione());
        ps.setString(3, infrazione.getTarga());
        ps.setDouble(4, infrazione.getVelocitaMedia());
        ps.setInt(5, infrazione.getIdInfrazione());


        int i = ps.executeUpdate();
        if (i == 0){
            throw new SQLException();
        }
    }

    /**
     * Metodo per la creazione della lista delle multe
     * @param connection Connection al db
     * @return Lista delle multe
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public List<Multa> getMulte(Connection connection) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Multa> multe = new ArrayList<>();

        String qry = "SELECT * FROM `infrazione` ";

        ps = connection.prepareStatement(qry);
        rs = ps.executeQuery();

        while(rs.next()){
            Multa multa = new Multa();

            multa.setInfrazioni(getIfrazioneDaMulta(connection(), Multa.counter));

            multe.add(multa);
        }

        return multe;
    }

    /**
     * Metodo per prendere le informazioni di una specifica tratta
     * @param connection Connection al db
     * @param idTratta Id della tratta da selezionare
     * @return Tratta
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public Tratta getTratta(Connection connection, int idTratta) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        String qry = "SELECT * FROM `tratta` WHERE `id_tratta` = ?;";
        ps = connection.prepareStatement(qry);
        ps.setInt(1, idTratta);
        rs = ps.executeQuery();
        Tratta t = new Tratta();

        while (rs.next()){

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
                        return Math.abs(t.getKmTratta()/(Duration.between(percorrimento.getOrarioUscita().toInstant(), percorrimento.getOrarioEntrata().toInstant()).toMinutes()/60D));
                    },
                    getAutovelox(this.connection(), t.getIdTratta())
            ));
            t.setPercorrimento(getPercorrenza(connection(), t.getIdTratta()));
        }

        return t;
    }

    /**
     * Metodo per prendere le infrazioni per la multa
     * @param connection Connection al db
     * @param idInfrazione Id dell' infrazione
     * @return Lista di infrazioni con lo stesso id
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public List<Infrazione> getIfrazioneDaMulta(Connection connection, int idInfrazione) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Infrazione> infrazioneList = new ArrayList<>();

        String qry = "SELECT * FROM `infrazione` WHERE `id_infrazione` = ?";

        ps = connection.prepareStatement(qry);
        ps.setInt(1, idInfrazione);
        rs = ps.executeQuery();

        while(rs.next()){
            Infrazione infrazione = new Infrazione();

            infrazione.setDescrizione(rs.getString("descrizione"));
            infrazione.setIdAutovelox(rs.getInt("id_autovelox"));
            infrazione.setIdTratta(rs.getInt("id_tratta"));
            infrazione.setIdInfrazione(rs.getInt("id_infrazione"));
            infrazione.setTarga(rs.getString("targa"));
            infrazione.setVelocitaInstantanea(rs.getInt("velocita_istantanea"));
            infrazione.setVelocitaMedia(rs.getDouble("velocita_media"));

            infrazioneList.add(infrazione);
        }

        return infrazioneList;
    }

    /**
     * Metodo per prendere le multe di un determinato comune
     * @param connection Connection al db
     * @param comune Comune della polizia
     * @return Lista delle multe in quel comune
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public List<Multa> getMulteDaComune(Connection connection, String comune) throws SQLException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Multa> multe = new ArrayList<>();

        String qry = "SELECT `infrazione`.`id_infrazione`, `infrazione`.`id_tratta`, `infrazione`.`id_autovelox`, " +
                            "`infrazione`.`descrizione`, `infrazione`.`targa`, `infrazione`.`velocita_istantanea`, `infrazione`.`velocita_media` " +
                            "FROM infrazione INNER JOIN tratta ON `tratta`.`comune` = ? ";

        ps = connection.prepareStatement(qry);
        ps.setString(1, comune);
        rs = ps.executeQuery();

        while(rs.next()){
            Multa multa = new Multa(getIfrazioneDaMulta(connection(), Multa.counter));

            multe.add(multa);
        }

        return multe;
    }

    /**
     * Metodo per prendere tutte le velocita istantanee di una tratta
     * @param connection Connection al db
     * @param idTratta Id della tratta
     * @return Lista delle velocita istantanee della tratta
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public List<Integer> getVelocitaIstantanee(Connection connection, int idTratta) throws SQLException{
        List<Integer> velocita = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String qry = "SELECT `percorrenza_autovelox`.`velocita` FROM percorrenza_autovelox " +
                     "INNER JOIN percorrenza ON `percorrenza_autovelox`.`id_percorrenza` = `percorrenza`.`id_percorrenza` " +
                     "INNER JOIN tratta ON `percorrenza`.`id_tratta` = ?";

        ps = connection.prepareStatement(qry);
        ps.setInt(1, idTratta);
        rs = ps.executeQuery();

        while (rs.next()){

            velocita.add(rs.getInt("velocita"));
        }

        return velocita;
    }

    /**
     * Metodo per prendere tutte le velocita medie di una tratta
     * @param connection Connection al db
     * @param idTratta Id della tratta
     * @return Lista delle velocita medie della tratta
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public List<Double> getVelocitaMedie(Connection connection, int idTratta) throws SQLException{
        List<Double> velocita = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String qry = "SELECT `percorrenza`.`orario_inizio`, `percorrenza`.`orario_fine`, `tratta`.`kmTratta`" +
                     "FROM `percorrenza` " +
                     "INNER JOIN `tratta` " +
                     "ON `percorrenza`.`id_tratta` = ?";

        ps = connection.prepareStatement(qry);
        ps.setInt(1, idTratta);
        rs = ps.executeQuery();

        while (rs.next()){
            Timestamp tStart = rs.getTimestamp("orario_inizio");
            Timestamp tEnd = rs.getTimestamp("orario_fine");

            velocita.add(Math.abs(rs.getInt("kmTratta")/(Duration.between(tStart.toInstant(), tEnd.toInstant()).toMinutes()/60D)));

        }

        return velocita;
    }

    /**
     * Metodo per prendere tutti i tempi medi di una tratta
     * @param connection Connection al db
     * @param idTratta Id della tratta
     * @return Lista dei tempi medii della tratta
     * @throws SQLException Questo metodo può lanciare una exception nel caso in cui vi sia un errore di accesso al database o altri errori
     */
    public List<Long> getTempoMedio(Connection connection, int idTratta) throws SQLException{
        List<Long> tempo = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String qry = "SELECT `percorrenza`.`orario_inizio`, `percorrenza`.`orario_fine`" +
                "FROM `percorrenza` " +
                "INNER JOIN `tratta` " +
                "ON `percorrenza`.`id_tratta` = ?";

        ps = connection.prepareStatement(qry);
        ps.setInt(1, idTratta);
        rs = ps.executeQuery();

        while (rs.next()){
            Timestamp tStart = rs.getTimestamp("orario_inizio");
            Timestamp tEnd = rs.getTimestamp("orario_fine");

            tempo.add(Math.abs((Duration.between(tStart.toInstant(), tEnd.toInstant()).toMinutes())));

        }

        return tempo;
    }

}
