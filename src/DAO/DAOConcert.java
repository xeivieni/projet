package DAO;

import items.Concert;
import java.sql.*;
import java.util.ArrayList;

public class DAOConcert {
    Connexion db;
    Connection dbcon;

    public DAOConcert() throws SQLException, ClassNotFoundException {
        this.db = new Connexion("root", "root", "jdbc:mysql://localhost:8889/projet", "com.mysql.jdbc.Driver");
        this.dbcon = this.db.getConnexion();
    }

    public Concert retrieve(String titre) throws SQLException{
        int flag = 0;
        String rqst = "SELECT * FROM Concert";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        Concert monConcert = null;
        while (rs.next()){
            String titre1 = rs.getString("Titre");
            if (titre1.equals(titre)){
                monConcert = new Concert(rs.getString("Titre"), rs.getString("Interprete"), rs.getString("Descriptif"));
            }
        }
        return monConcert;
    }

    public void create(Concert concert) throws SQLException{
        String rqst = "SELECT * FROM Concert";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            String titre = rs.getString("Titre");
            String interprete = rs.getString("Interprete");
            String descriptif = rs.getString("Descriptif");
            if (titre.equals(concert.getTitre()) && interprete.equals(concert.getInterprete()) && descriptif.equals(concert.getDescriptif())){
                System.out.println("Le client demandé existe déjà dans la base de donnée");
                return;
            }
        }
        /* Exécution d'une requête d'écriture */
        int xU = stmt.executeUpdate("INSERT INTO `Concert`" +
        "(`Titre`, `Interprete`, `Descriptif`) VALUES " +
                "(\"" + concert.getTitre() + "\",\"" + concert.getInterprete() + "\",\"" + concert.getDescriptif() + "\");");
    }

    public void update(Concert concert) throws SQLException{
        String rqst = "SELECT * FROM Concert";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            String titre = rs.getString("Titre");
            String interprete = rs.getString("Interprete");
            String descriptif = rs.getString("Descriptif");
            if (titre.equals(concert.getTitre()) || interprete.equals(concert.getInterprete())
                    || descriptif.equals(concert.getDescriptif())){
                rs.updateString("Titre", concert.getTitre());
                rs.updateString("Interprete", concert.getInterprete());
                rs.updateString("Descriptif", concert.getDescriptif());
            }
        }
    }

    public void delete(Concert concert) throws SQLException{
        String query = "DELETE FROM Concert WHERE Titre = ?";
        PreparedStatement preparedStmt = dbcon.prepareStatement(query);
        preparedStmt.setString(1, concert.getTitre());

        // execute the preparedstatement
        preparedStmt.execute();
    }

    public ArrayList<Concert> findAll() throws Exception {
        ArrayList<Concert> R = new ArrayList<Concert>();

        String rqst = "SELECT * FROM Concert";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            Concert live = new Concert(rs.getString("Titre"), rs.getString("Interprete"), rs.getString("Descriptif"));
            R.add(live);
        }
        return R;
    }
}
