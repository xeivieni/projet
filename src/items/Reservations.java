package items;

/**
 * Created by clementmondion on 12/05/15.
 */
public class Reservations {
    public int id;
    public int nbPlacesDT;
    public int nbPlacesPT;
    public int nbPlacesVIP;
    public Spectacle spectacle;
    public int IDClient;


    public void setIDClient(int IDClient) {
        this.IDClient = IDClient;
    }

    public int getIDClient() {
        return IDClient;
    }

    public int getId() {
        return id;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public int getNbPlacesDT() {
        return nbPlacesDT;
    }

    public int getNbPlacesPT() {
        return nbPlacesPT;
    }

    public int getNbPlacesVIP() {
        return nbPlacesVIP;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNbPlacesDT(int nbPlacesDT) {
        this.nbPlacesDT = nbPlacesDT;
    }

    public void setNbPlacesPT(int nbPlacesPT) {
        this.nbPlacesPT = nbPlacesPT;
    }

    public void setNbPlacesVIP(int nbPlacesVIP) {
        this.nbPlacesVIP = nbPlacesVIP;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public int prixResa(){
        return 5 * nbPlacesPT + 2 * nbPlacesDT;
    }

}
