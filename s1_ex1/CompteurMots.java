/**
 * Observateur concret pour compter le nombre de mots
 */
public class CompteurMots implements ObservateurStatistique {
    private int nombreMots = 0;
    
    @Override
    public void traiterLigne(String ligne) {
        // Ne fait rien pour cette statistique
    }
    
    @Override
    public void traiterMot(String mot) {
        nombreMots++;
    }
    
    @Override
    public void afficherResultat() {
        System.out.println("Il y avait " + nombreMots + " mots.");
    }
    
    @Override
    public String getNomStatistique() {
        return "Compteur de mots";
    }
    
    public int getNombreMots() {
        return nombreMots;
    }
}
