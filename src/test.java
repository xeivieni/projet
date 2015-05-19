import DAO.*;
import items.*;

import java.sql.SQLException;
import java.time.Instant;

public class test {
    public static void main(String[] args) throws Exception {
        Client testclient = new Client("Mondion", "Clement", 456);
        Festival Marvellous = new Festival();
        Concert live1 = new Concert("Magic live", "Madeon", "3h live set");
        Concert live2 = new Concert("Live from earth", "Ken Block", "Ca va etre trop cool");
        Salle salle1 = new Salle(1);
        Spectacle show1 = new Spectacle(salle1, live1, java.util.Date.from(Instant.now()), 30, 20, 10);
        Reservations resa1 = new Reservations(33, 5, 1, 0, 456, show1);
        DAOConcert daoconcert1 = new DAOConcert();
        daoconcert1.findAll();
        DAOSpectacle daospectacle1 = new DAOSpectacle();
        daospectacle1.create(show1);
        //DAOClient daoclient1 = new DAOClient();
        //daoclient1.create(testclient);
        //DAOResa daoresa1 = new DAOResa();
        //daoresa1.create(resa1);

    }
}
