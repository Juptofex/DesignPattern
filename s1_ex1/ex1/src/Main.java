import java.io.IOException;

/**
 * Classe principale démontrant l'utilisation du pattern Observer
 * pour l'analyse de texte avec différentes statistiques
 */
public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java MainAnalyseur <nomFichier>");
            return;
        }
        
        // Créer l'analyseur (Subject)
        TextAnalyser analyseur = new TextAnalyser();
        
        // Créer et ajouter les différents observateurs (statistiques)
        Lines lines = new Lines();
        Words words = new Words();
        Palindrome palindrome = new Palindrome();
        FindWord compteurBelgique = new FindWord("Belgique");
        WordFrequency analyseurFrequence = new WordFrequency();
        
        // Ajouter les observateurs à l'analyseur
        analyseur.ajouterObservateur(lines);
        analyseur.ajouterObservateur(words);
        analyseur.ajouterObservateur(palindrome);
        analyseur.ajouterObservateur(compteurBelgique);
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
