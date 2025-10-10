import java.util.regex.Pattern;

/**
 * Observateur concret pour compter les lignes contenant une expression régulière
 */
public class CompteurExpressionReguliere implements ObservateurStatistique {
    private int nombreLignesCorrespondantes = 0;
    private Pattern pattern;
    private String expressionReguliere;
    
    public CompteurExpressionReguliere(String expressionReguliere) {
        this.expressionReguliere = expressionReguliere;
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
                          " lignes correspondant à l'expression régulière '" + 
                          expressionReguliere + "'.");
    }
    
    @Override
    public String getNomStatistique() {
        return "Compteur d'expression régulière: " + expressionReguliere;
    }
    
    public int getNombreLignesCorrespondantes() {
        return nombreLignesCorrespondantes;
    }
}
