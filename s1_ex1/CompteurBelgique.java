/**
 * Observateur concret pour compter les lignes contenant "Belgique"
 */
public class CompteurBelgique implements ObservateurStatistique {
    private int nombreLignesBelgique = 0;
    
    @Override
    public void traiterLigne(String ligne) {
        if (ligne.contains("Belgique")) {
            nombreLignesBelgique++;
        }
    }
    
    @Override
    public void traiterMot(String mot) {
        // Ne fait rien pour cette statistique
    }
    
    @Override
    public void afficherResultat() {
        System.out.println("Il y avait " + nombreLignesBelgique + " lignes contenant Belgique.");
    }
    
    @Override
    public String getNomStatistique() {
        return "Compteur de lignes contenant Belgique";
    }
    
    public int getNombreLignesBelgique() {
        return nombreLignesBelgique;
    }
}
