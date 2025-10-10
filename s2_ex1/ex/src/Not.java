public class Not implements Strategy {
    private Strategy strategy1;

    public Not(Strategy strategy1) {
        this.strategy1 = strategy1;
    }

    @Override
    public boolean isValid(String word) {
        return !strategy1.isValid(word);
    }
}
