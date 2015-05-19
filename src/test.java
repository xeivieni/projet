import DAO.*;
import items.*;

import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws Exception {
        Client testclient = new Client("Montana", "Tony", 35);
        Festival Marvellous = new Festival();
        Concert live1 = new Concert("Nouveau live2fou22", "patrick etoile", "boum boum tchak");
        Concert live2 = new Concert("jubibul", "Patrick fiori", "Ohmygod");
        Salle salle1 = new Salle(1);
        Spectacle show1 = new Spectacle(salle1, live1, "2015-12-25", 30, 20, 10);
        Reservations resa1 = new Reservations(33, 5, 1, 0, 456, show1);
        DAOConcert daoconcert1 = new DAOConcert();
        ArrayList<Concert> myvar = daoconcert1.findAll();
        System.out.print(myvar);
        //DAOSpectacle daospectacle1 = new DAOSpectacle();
        //daospectacle1.create(show1);
        DAOClient daoclient1 = new DAOClient();
        daoclient1.create(testclient);
        DAOResa daoresa1 = new DAOResa();
        daoresa1.create(resa1);
    }
}
