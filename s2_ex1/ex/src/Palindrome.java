public class Palindrome implements Strategy {
    @Override
    public boolean isValid(String word) {
        if (word == null)
            return false;
        StringBuilder stringbuffer = new StringBuilder(word);
        return word.contentEquals(stringbuffer.reverse());
    }
}