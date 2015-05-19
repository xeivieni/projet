package items;


public class Spectacle {
    public Salle salle;
    public Concert concert;
    public String date;
    public int nbPlacesPT;
    public int nbPlacesDT;
    public int nbPlacesVIP;

    public Spectacle(){}

    public Spectacle(Salle salle, Concert concert, String date, int PT,  int DT, int VIP){
        this.salle = salle;
        this.concert = concert;
        this.date = date;
        this.nbPlacesDT = DT;
        this.nbPlacesPT = PT;
        this.nbPlacesVIP = VIP;
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

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
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

    public Concert getConcert() {
        return concert;
    }

    public String getDate() {
        return date;
    }

    public Salle getSalle() {
        return salle;
    }
}
