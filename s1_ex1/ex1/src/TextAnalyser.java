import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Subject (Observable) qui gère l'analyse du texte
 * et notifie les observateurs
 */
public class TextAnalyser {
    private List<Observer> observateurs;
    private BufferedReader lecteurAvecBuffer;
    
    public TextAnalyser() {
        this.observateurs = new ArrayList<>();
    }
    
    /**
     * Ajoute un observateur pour une statistique
     * @param observateur l'observateur à ajouter
     */
    public void ajouterObservateur(Observer observateur) {
        observateurs.add(observateur);
    }
    
    /**
     * Supprime un observateur
     * @param observateur l'observateur à supprimer
     */
    public void supprimerObservateur(Observer observateur) {
        observateurs.remove(observateur);
    }
    
    /**
     * Notifie tous les observateurs qu'une ligne a été lue
     * @param ligne la ligne courante
     */
    private void notifierLigne(String ligne) {
        for (Observer obs : observateurs) {
            obs.traiterLigne(ligne);
        }
    }
    
    /**
     * Notifie tous les observateurs qu'un mot a été trouvé
     * @param mot le mot courant
     */
    private void notifierMot(String mot) {
        for (Observer obs : observateurs) {
            obs.traiterMot(mot);
        }
    }
    
    /**
     * Demande à tous les observateurs d'afficher leurs résultats
     */
    private void afficherTousLesResultats() {
        for (Observer obs : observateurs) {
            obs.afficherResultat();
        }
    }
    
    /**
     * Analyse le fichier spécifié
     * @param nomFichier le nom du fichier à analyser
     * @throws IOException en cas d'erreur de lecture
     */
    public void analyserFichier(String nomFichier) throws IOException {
        String ligne;
        
        try {
            lecteurAvecBuffer = new BufferedReader(new FileReader(nomFichier));
        } catch (FileNotFoundException e) {
            System.out.println("Erreur d'ouverture du fichier : " + nomFichier);
            return;
        }
        
        while ((ligne = lecteurAvecBuffer.readLine()) != null) {
            // Notifier tous les observateurs de la nouvelle ligne
            notifierLigne(ligne);
            
            // Traiter chaque mot de la ligne
            String[] mots = ligne.trim().split("\\s+");
            for (String mot : mots) {
                if (!mot.isEmpty()) {
                    notifierMot(mot);
                }
            }
        }
        
        lecteurAvecBuffer.close();
        
        // Afficher tous les résultats
        afficherTousLesResultats();
    }
}
