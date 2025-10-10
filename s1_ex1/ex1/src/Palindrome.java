/**
 * Observateur concret pour compter les palindromes
 */
public class Palindrome implements Observer {
    private int nombrePalindromes = 0;
    
    @Override
    public void traiterLigne(String ligne) {
        // Ne fait rien pour cette statistique
    }
    
    @Override
    public void traiterMot(String mot) {
        // Nettoyer le mot (enlever la ponctuation)
        String motNettoye = mot.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        if (!motNettoye.isEmpty() && estPalindrome(motNettoye)) {
            nombrePalindromes++;
        }
    }
    
    private boolean estPalindrome(String mot) {
        StringBuilder temp = new StringBuilder(mot);
        return mot.equals(temp.reverse().toString());
    }
    
    @Override
    public void afficherResultat() {
        System.out.println("Il y avait " + nombrePalindromes + " palindromes.");
    }
    
    @Override
    public String getNomStatistique() {
        return "Compteur de palindromes";
    }
    
    public int getNombrePalindromes() {
        return nombrePalindromes;
    }
}
