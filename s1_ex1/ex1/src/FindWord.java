import java.util.regex.Pattern;

/**
 * Observateur concret pour compter les lignes contenant le mot
 */
public class FindWord implements Observer {
    private int nombreLignesCorrespondantes = 0;
    private Pattern pattern;
    private String mot;
    
    public FindWord(String expressionReguliere) {
        this.mot = expressionReguliere;
        this.pattern = Pattern.compile(expressionReguliere);
    }
    
    @Override
    public void traiterLigne(String ligne) {
        if (pattern.matcher(ligne).find()) {
            nombreLignesCorrespondantes++;
        }
    }
    
    @Override
    public void traiterMot(String mot) {
        // Ne fait rien pour cette statistique
    }
    
    @Override
    public void afficherResultat() {
        System.out.println("Il y avait " + nombreLignesCorrespondantes + 
                          " lignes correspondant au mot '" +
                mot + "'.");
    }
    
    @Override
    public String getNomStatistique() {
        return "Compteur de mot: " + mot;
    }
    
    public int getNombreLignesCorrespondantes() {
        return nombreLignesCorrespondantes;
    }
}
