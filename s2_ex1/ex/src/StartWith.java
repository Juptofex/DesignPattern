import java.io.*;
import java.util.*;
public class StartWith implements Strategy{ // mal foutu
    private String start;

    public StartWith(String start) {
        this.start = start;
    }

    @Override
    public boolean isValid(String word) {
        return word.startsWith(start);
    }
}