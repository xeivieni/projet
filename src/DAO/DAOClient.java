package DAO;

import items.Client;
import java.sql.*;
import java.util.ArrayList;


public class DAOClient {
    Connexion db;
    Connection dbcon;

    public DAOClient() throws SQLException, ClassNotFoundException {
        this.db = new Connexion("root", "root", "jdbc:mysql://localhost:8889/projet", "com.mysql.jdbc.Driver");
        this.dbcon = this.db.getConnexion();
    }

    public Client retrieve(String nom) throws SQLException{
        int flag = 0;
        String rqst = "SELECT * FROM Clients";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        Client monClient = null;
        while (rs.next()){
            String name = rs.getString("nom");
            if (name.equals(nom)){
                monClient = new Client(rs.getString("Nom"), rs.getString("Prenom"), rs.getInt("ID"));
            }
        }
        return monClient;
    }

    public void create(Client client) throws SQLException{
        String rqst = "SELECT * FROM Clients";
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
        int xU = stmt.executeUpdate("INSERT INTO Clients (Nom, Prenom, ID) VALUES (" + client.getNom() + "," + client.getPrenom() + "," + client.getId() + ");");
    }

    public void update(Client client) throws SQLException{
        String rqst = "SELECT * FROM Clients";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            String name = rs.getString("Nom");
            String surname = rs.getString("Prenom");
            int age = rs.getInt("ID");
            if (name.equals(client.getNom()) || surname.equals(client.getPrenom()) || age == client.getId()){
                rs.updateString("Nom", client.getNom());
                rs.updateString("Prenom", client.getPrenom());
                rs.updateInt("ID", client.getId());
            }
        }
    }

    public void delete(Client client) throws SQLException{
        String query = "DELETE FROM Clients WHERE ID = ?";
        PreparedStatement preparedStmt = dbcon.prepareStatement(query);
        preparedStmt.setInt(1, client.getId());

        // execute the preparedstatement
        preparedStmt.execute();
    }


    public ArrayList<Client> findAll() throws Exception {
        ArrayList<Client> R = new ArrayList<Client>();

        String rqst = "SELECT * FROM Clients";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        while (rs.next()){
            R.add((Client)rs);
        }
        return R;
    }

}
