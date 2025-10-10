import java.io.*;
import java.util.*;

public class WordsWithLength implements Strategy{ // mal foutu
    private int length;

    public WordsWithLength(int length) {
        this.length = length;
    }

    @Override
    public boolean isValid(String word) {
        return word.length() == length;
    }
}