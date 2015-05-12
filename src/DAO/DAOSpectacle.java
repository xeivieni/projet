package DAO;

import items.Concert;
import items.Reservations;
import items.Salle;
import items.Spectacle;

import java.sql.*;
import java.util.ArrayList;


public class DAOSpectacle {
    Connexion db;
    Connection dbcon;

    public DAOSpectacle() throws SQLException, ClassNotFoundException {
        this.db = new Connexion("root", "root", "jdbc:mysql://localhost:8889/projet", "com.mysql.jdbc.Driver");
        this.dbcon = this.db.getConnexion();
    }

    public Spectacle retrieve(String nom) throws SQLException{
        int flag = 0;
        String rqst = "SELECT * FROM Spectacle";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        Spectacle monSpectacle = null;
        while (rs.next()){
            String name = rs.getString("nom");
            if (name.equals(nom)){
                monSpectacle = new Spectacle(new Salle(rs.getInt("Salle")), new Concert(), rs.getDate("Date"),
                        rs.getInt("nbPT"), rs.getInt("nbDT"), rs.getInt("nbVIP"));
            }
        }
        return monSpectacle;
    }

    public void create(Spectacle spectacle) throws SQLException{
        String rqst = "SELECT * FROM Spectacle";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            String name = rs.getString("Nom");
            String surname = rs.getString("Prenom");
            int age = rs.getInt("ID");
            System.out.println(name +" "+ surname +" "+ age);
            if (name.equals(client.getNom()) && surname.equals(client.getPrenom()) && age == client.getId()){
                System.out.println("Le client demandé existe déjà dans la base de donnée");
                return;
            }
        }
        /* Exécution d'une requête d'écriture */
        int xU = stmt.executeUpdate("INSERT INTO Spectacle " +
                "(Date, Titre, Salle, NbPT, NbDT, NbVIP) VALUES " +
                "(" + spectacle.getDate() + "," + spectacle.getConcert().getTitre() + "," + spectacle.getSalle()+ ","
                + spectacle.getNbPlacesPT()+ "," + spectacle.getNbPlacesDT()+ "," + spectacle.getNbPlacesVIP() + ");");
    }

    public void update(Spectacle spectacle) throws SQLException{
        String rqst = "SELECT * FROM Spectacle";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            String titre = rs.getString("Titre");
            String date = rs.getString("Date");
            int salle = rs.getInt("Salle");
            int nbPT = rs.getInt("NbPT");
            int nbDT = rs.getInt("NbDT");
            int nbVIP = rs.getInt("NbVIP");
            if (titre.equals(spectacle.getConcert().getTitre()) || date.equals(spectacle.getDate().toString())
                    || salle == spectacle.getSalle().getNumero() || nbDT == spectacle.getNbPlacesDT() ||
                    nbPT == spectacle.getNbPlacesPT() || nbVIP == spectacle.nbPlacesVIP){
                rs.updateString("Titre", spectacle.getConcert().getTitre());
                rs.updateString("Date", spectacle.getDate().toString());
                rs.updateInt("Salle", spectacle.getSalle().getNumero());
                rs.updateInt("NbPT", spectacle.getNbPlacesPT());
                rs.updateInt("NbDT", spectacle.getNbPlacesDT());
                rs.updateInt("NbVIP", spectacle.getNbPlacesVIP());
            }
        }
    }

    public void delete(Spectacle spectacle) throws SQLException{
        String query = "DELETE FROM Spectacle WHERE Titre = ?";
        PreparedStatement preparedStmt = dbcon.prepareStatement(query);
        preparedStmt.setString(1, spectacle.getConcert().getTitre());

        // execute the preparedstatement
        preparedStmt.execute();
    }



    public ArrayList<Spectacle> findAll() throws Exception {
        ArrayList<Spectacle> R = new ArrayList<Spectacle>();

        String rqst = "SELECT * FROM Resa";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            R.add((Spectacle)rs);
        }
        return R;
    }
}
