package DAO;

import items.Spectacle;

import java.sql.*;


public class DAOSpectacle {
    Connexion db;
    Connection dbcon;

    public DAOSpectacle() throws SQLException, ClassNotFoundException {
        this.db = new Connexion("root", "root", "jdbc:mysql://localhost:8889/projet", "com.mysql.jdbc.Driver");
        this.dbcon = this.db.getConnexion();
    }

    public Spectacle retrieve(String nom) throws SQLException{
        int flag = 0;
        String rqst = "SELECT * FROM personne";
        Statement stmt = dbcon.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs;
        rs = stmt.executeQuery(rqst);
        Spectacle monSpectacle = null;
        while (rs.next()){
            String name = rs.getString("nom");
            if (name.equals(nom)){
                monSpectacle = new Spectacle(rs.getString("Nom"), rs.getString("Prenom"), rs.getInt("ID"));
            }
        }
        return monSpectacle;
    }

    public void create(Spectacle spectacle) throws SQLException{
        String rqst = "SELECT * FROM personne";
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
        String rqst = "SELECT * FROM personne";
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
        String query = "DELETE FROM personne WHERE Prenom = ?";
        PreparedStatement preparedStmt = dbcon.prepareStatement(query);
        preparedStmt.setString(1, client.getPrenom());

        // execute the preparedstatement
        preparedStmt.execute();
    }

}
