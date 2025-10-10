public class And implements Strategy {
    private Strategy strategy1;
    private Strategy strategy2;

    public And(Strategy strategy1,  Strategy strategy2) {
        this.strategy1 = strategy1;
        this.strategy2 = strategy2;
    }

    @Override
    public boolean isValid(String word) {
        return strategy1.isValid(word) && strategy2.isValid(word);
    }
}
