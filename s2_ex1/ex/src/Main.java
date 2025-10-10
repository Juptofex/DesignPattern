import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Usage: java MainAnalyseur <nomFichier>");
            return;
        }

        WordList wordList = new WordList(args[0]);

        Palindrome palindrome = new Palindrome();
        WordsWithLength wordsWithLength = new WordsWithLength(5);
        StartWith startWith = new StartWith("t");

        And and = new And(wordsWithLength, startWith);
        Or or = new Or(wordsWithLength, startWith);
        Not not = new Not(wordsWithLength);

        Et et = new Et(wordsWithLength, startWith);
        Ou ou = new Ou(wordsWithLength, startWith);

        System.out.println("\nDebut palindrome");
        wordList.printIf(palindrome);

        System.out.println("\nDebut wordWithLength");
        wordList.printIf(wordsWithLength);

        System.out.println("\nDebut startWith");
        wordList.printIf(startWith);

        System.out.println("\nDebut and (length 5, startWith t)");
        wordList.printIf(and);

        System.out.println("\nDebut or (length 5, startWith t)");
        wordList.printIf(or);

        System.out.println("\nDebut not (length 5)");
        wordList.printIf(not);

        System.out.println("\nDebut et (length 5, startWith t)");
        wordList.printIf(et);

        System.out.println("\nDebut ou (length 5, startWith t)");
        wordList.printIf(ou);

        System.out.println("\nDebut compteur (palindrome)");
        Compteur compteur = new Compteur(new Palindrome());
        wordList.printIf(compteur);
        System.out.println("Nombre de mots sélectionnés : " + compteur.getCompteur());
    }
}