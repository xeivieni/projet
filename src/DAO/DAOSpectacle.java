package DAO;

import items.Concert;
import items.Reservations;
import items.Salle;
import items.Spectacle;

import java.sql.*;
import java.util.*;


public class DAOSpectacle {
    Connexion db;
    Connection dbcon;

    public DAOSpectacle() throws SQLException, ClassNotFoundException {
        this.db = new Connexion("root", "root", "jdbc:mysql://localhost:8889/projet", "com.mysql.jdbc.Driver");
        this.dbcon = this.db.getConnexion();
    }

    public Spectacle retrieve(String nom) throws SQLException, ClassNotFoundException {
        int flag = 0;
        String rqst = "SELECT * FROM Spectacle";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        Spectacle monSpectacle = null;
        DAOConcert monDAOConcert = new DAOConcert();
        while (rs.next()){
            String name = rs.getString("nom");
            if (name.equals(nom)){
                monSpectacle = new Spectacle(new Salle(rs.getInt("Salle")), monDAOConcert.retrieve(nom), rs.getDate("Date"),
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
        /*while (rs.next()){
            java.sql.Date date = rs.getDate("Date");
            String titre = rs.getString("Titre");
            int salle = rs.getInt("Salle");
            int PT = rs.getInt("NbPT");
            int DT = rs.getInt("NbDT");
            int VIP = rs.getInt("NbVIP");
            if (date.equals(spectacle.getDate()) && titre.equals(spectacle.getConcert().getTitre())
                    && salle == spectacle.getSalle().getNumero() && PT == spectacle.getNbPlacesPT() && DT == spectacle.getNbPlacesDT() && VIP == spectacle.getNbPlacesVIP()){
                System.out.println("Le spectacle demandé existe déjà dans la base de donnée");
                return;
            }
        }*/
        /* Exécution d'une requête d'écriture */
        String statement = ("INSERT INTO `Spectacle` " +
                "(`Date`, `Titre`, `Salle`, `NbPT`, `NbDT`, `NbVIP`) VALUES " +
                "('2015-04-20',\"" + spectacle.getConcert().getTitre() + "\",\"" + spectacle.getSalle().getNumero() + "\",\""
                + spectacle.getNbPlacesPT() + "\",\"" + spectacle.getNbPlacesDT() + "\",\"" + spectacle.getNbPlacesVIP() + "\");");
        System.out.println(statement);
        int xU = stmt.executeUpdate(statement);
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

        String rqst = "SELECT * FROM Spectacle";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            R.add((Spectacle)rs);
        }
        return R;
    }
}