/**
 * Interface Observer pour les statistiques de texte
 */
public interface Observer {
    /**
     * Méthode appelée pour chaque ligne lue
     * @param ligne la ligne courante
     */
    void traiterLigne(String ligne);
    
    /**
     * Méthode appelée pour chaque mot trouvé
     * @param mot le mot courant
     */
    void traiterMot(String mot);
    
    /**
     * Méthode appelée à la fin du traitement pour afficher les résultats
     */
    void afficherResultat();
    
    /**
     * Retourne le nom de la statistique
     * @return nom de la statistique
     */
    String getNomStatistique();
}
