package items;

import java.util.Date;

/**
 * Created by clementmondion on 12/05/15.
 */
public class Spectacle {
    public Salle salle;
    public Concert concert;
    public java.util.Date date;
    public int nbPlacesPT;
    public int nbPlacesDT;
    public int nbPlacesVIP;

    public Spectacle(Salle salle, Concert concert, Date date, int PT,  int DT, int VIP){
        this.salle = salle;
        this.concert = concert;
        this.date = date;
        this.nbPlacesDT = DT;
        this.nbPlacesPT = PT;
        this.nbPlacesVIP = VIP;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Concert getConcert() {
        return concert;
    }

    public Date getDate() {
        return date;
    }

    public Salle getSalle() {
        return salle;
    }
}
