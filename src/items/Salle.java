package items;

/**
 * Created by clementmondion on 12/05/15.
 */
public class Salle {
    public int numero;
    public int capacite;

    public Salle(int num){
        this.numero = num;
        if (num == 1){
            this.capacite = 50;
        }
        else{
            this.capacite = 75;
        }
    }
}
