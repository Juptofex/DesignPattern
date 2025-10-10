/**
 * Observateur concret pour compter le nombre de lignes
 */
public class Lines implements Observer {
    private int nombreLignes = 0;
    
    @Override
    public void traiterLigne(String ligne) {
        nombreLignes++;
    }
    
    @Override
    public void traiterMot(String mot) {
        // Ne fait rien pour cette statistique
    }
    
    @Override
    public void afficherResultat() {
        System.out.println("Il y avait " + nombreLignes + " lignes.");
    }
    
    @Override
    public String getNomStatistique() {
        return "Compteur de lignes";
    }
    
    public int getNombreLignes() {
        return nombreLignes;
    }
}
