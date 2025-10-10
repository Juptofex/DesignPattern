public class Compteur implements Strategy {
    private Strategy strategie;
    private int compteur = 0;

    public Compteur(Strategy strategie) {
        this.strategie = strategie;
    }

    @Override
    public boolean isValid(String word) {
        boolean valide = strategie.isValid(word);
        if (valide) {
            compteur++;
        }
        return valide;
    }

    public int getCompteur() {
        return compteur;
    }
}
