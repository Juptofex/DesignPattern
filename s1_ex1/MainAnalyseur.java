import java.io.IOException;

/**
 * Classe principale démontrant l'utilisation du pattern Observer
 * pour l'analyse de texte avec différentes statistiques
 */
public class MainAnalyseur {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java MainAnalyseur <nomFichier>");
            return;
        }
        
        // Créer l'analyseur (Subject)
        AnalyseurDeTexteObservable analyseur = new AnalyseurDeTexteObservable();
        
        // Créer et ajouter les différents observateurs (statistiques)
        CompteurLignes compteurLignes = new CompteurLignes();
        CompteurMots compteurMots = new CompteurMots();
        CompteurPalindromes compteurPalindromes = new CompteurPalindromes();
        CompteurBelgique compteurBelgique = new CompteurBelgique();
        
        // Nouvelles statistiques demandées
        CompteurExpressionReguliere compteurEmail = new CompteurExpressionReguliere("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b");
        AnalyseurFrequenceMots analyseurFrequence = new AnalyseurFrequenceMots();
        
        // Ajouter les observateurs à l'analyseur
        analyseur.ajouterObservateur(compteurLignes);
        analyseur.ajouterObservateur(compteurMots);
        analyseur.ajouterObservateur(compteurPalindromes);
        analyseur.ajouterObservateur(compteurBelgique);
        analyseur.ajouterObservateur(compteurEmail);
        analyseur.ajouterObservateur(analyseurFrequence);
        
        // Analyser le fichier
        System.out.println("=== Analyse du fichier: " + args[0] + " ===");
        analyseur.analyserFichier(args[0]);
        
        // Exemple de suppression d'un observateur
        System.out.println("\n=== Analyse sans la fréquence des mots ===");
        analyseur.supprimerObservateur(analyseurFrequence);
        // Pour voir la différence, on pourrait relancer l'analyse...
    }
}
