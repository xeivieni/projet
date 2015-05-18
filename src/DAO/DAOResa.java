package DAO;
import items.Reservations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOResa {
    Connexion db;
    Connection dbcon;
    public DAOResa() throws SQLException, ClassNotFoundException {
        this.db = new Connexion("root", "root", "jdbc:mysql://localhost:8889/TP9", "com.mysql.jdbc.Driver");
        this.dbcon = this.db.getConnexion();
    }


    public void create(Reservations resa) throws SQLException{
        String rqst = "SELECT * FROM Resa";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            int ID = rs.getInt("ID");
            System.out.println(ID);
            if (ID == (resa.getId())){
                System.out.println("Already existing");
                return;
            }
        }
        /* Exécution d'une requête d'écriture */
        int xU = stmt.executeUpdate("INSERT INTO `Resa` (`NbPT`, `NbDT`,`NbVIP`, `ID`, `Client`, `Spectacle`) " +
                "VALUES (\"" + resa.getNbPlacesPT() + "\",\"" + resa.getNbPlacesDT() + "\",\"" + resa.getNbPlacesVIP()
                + "\",\"" + resa.getId() + "\",\"" + resa.getIDClient() + "\",\"" +
                resa.getSpectacle().getConcert().getTitre() +  "\");");
    }

    public Reservations retrieve(int ID) throws SQLException, ClassNotFoundException {
        int flag = 0;
        String rqst = "SELECT * FROM Resa";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        Reservations Resa = null;
        DAOSpectacle monDAOspectacle = new DAOSpectacle();
        while (rs.next()){

            if (ID == (rs.getInt("ID"))){
                Resa = new Reservations(rs.getInt("ID"), rs.getInt("NbDT"), rs.getInt("NbPT"), rs.getInt("NbVIP"), rs.getInt("Client"), monDAOspectacle.retrieve(rs.getString("Spectacle")));
            }
        }
        return Resa;
    }


    public void update(Reservations resa) throws SQLException{
        String rqst = "SELECT * FROM Resa";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            
            int NbPT = rs.getInt("NbPT");
            int NbDT = rs.getInt("NbDT");
            int NbVIP = rs.getInt("NbVIP");
            int ID = rs.getInt("ID");
            int Client = rs.getInt("Client");
            String Spectacle = rs.getString("Spectacle");

            if (NbPT == resa.getNbPlacesPT() || NbDT == resa.getNbPlacesDT() || NbVIP == resa.getNbPlacesVIP() ||
                    ID == resa.getId() || Client == resa.getIDClient() ||
                    Spectacle.equals(resa.getSpectacle().getConcert().getTitre())){
                rs.updateInt("NbPT", resa.getNbPlacesPT());
                rs.updateInt("NbDT", resa.getNbPlacesDT());
                rs.updateInt("NbVIP", resa.getNbPlacesVIP());
                rs.updateInt("ID", resa.getId());
                rs.updateInt("Client", resa.getIDClient());
                rs.updateString("Spectacle", String.valueOf(Spectacle.equals(resa.getSpectacle().getConcert().getTitre())));
            }
        }
    }

    public void delete(Reservations resa) throws SQLException{
        String query = "DELETE FROM Resa WHERE ID = ?";
        PreparedStatement preparedStmt = dbcon.prepareStatement(query);
        preparedStmt.setInt(1, resa.getId());

        // execute the preparedstatement
        preparedStmt.execute();
    }

    public ArrayList<Reservations> findAll() throws Exception {
        ArrayList<Reservations> R = new ArrayList<Reservations>();

        String rqst = "SELECT * FROM Resa";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            R.add((Reservations)rs);
        }
        return R;
    }
}
