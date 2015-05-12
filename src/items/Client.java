package items;

import java.util.ArrayList;

/**
 * Created by clementmondion on 12/05/15.
 */
public class Client {
    public String nom;
    public String prenom;
    public int Id;
    public java.util.ArrayList<Reservations> resa;

    public Client(String n, String p, int id){
        this.nom = n;
        this.prenom = p;
        this.Id = id;
    }

    public void ajouterResa(Reservations resa){
        this.resa.add(resa);
    }

    public int getId() {
        return Id;
    }

    public ArrayList<Reservations> getResa() {
        return resa;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setResa(ArrayList<Reservations> resa) {
        this.resa = resa;
    }
}
