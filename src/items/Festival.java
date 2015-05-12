package items;

import java.util.ArrayList;

/**
 * Created by clementmondion on 12/05/15.
 */
public class Festival {
    public java.util.ArrayList<Spectacle> spectacles;

    public void setSpectacles(ArrayList<Spectacle> spectacles) {
        this.spectacles = spectacles;
    }

    public ArrayList<Spectacle> getSpectacles() {
        return spectacles;
    }

    public ArrayList<Spectacle> getProgSalle(int numeroSalle) {
        return null;
    }
}
