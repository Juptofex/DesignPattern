import java.util.HashMap;
import java.util.Map;

/**
 * Observateur concret pour analyser la fréquence des mots
 */
public class AnalyseurFrequenceMots implements ObservateurStatistique {
    private Map<String, Integer> frequenceMots = new HashMap<>();
    
    @Override
    public void traiterLigne(String ligne) {
        // Ne fait rien pour cette statistique
    }
    
    @Override
    public void traiterMot(String mot) {
        // Nettoyer le mot (enlever la ponctuation et mettre en minuscules)
        String motNettoye = mot.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        if (!motNettoye.isEmpty()) {
            frequenceMots.put(motNettoye, frequenceMots.getOrDefault(motNettoye, 0) + 1);
        }
    }
    
    @Override
    public void afficherResultat() {
        System.out.println("\n=== Analyse de la fréquence des mots ===");
        
        if (frequenceMots.isEmpty()) {
            System.out.println("Aucun mot trouvé.");
            return;
        }
        
        // Afficher les mots triés par fréquence (décroissante)
        frequenceMots.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " occurrence(s)"));
        
        System.out.println("Total de mots uniques: " + frequenceMots.size());
    }
    
    @Override
    public String getNomStatistique() {
        return "Analyseur de fréquence des mots";
    }
    
    public Map<String, Integer> getFrequenceMots() {
        return new HashMap<>(frequenceMots);
    }
}
