package items;

/**
 * Created by clementmondion on 12/05/15.
 */
public class Concert {
    public String titre;
    private String interprete;
    public String descriptif;

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }

    public void setInterprete(String interprete) {
        this.interprete = interprete;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescriptif() {
        return descriptif;
    }

    public String getInterprete() {
        return interprete;
    }

    public String getTitre() {
        return titre;
    }
}
