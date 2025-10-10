import java.util.List;

public class Ou implements Strategy {
    private Strategy[] strategies;

    public Ou(Strategy...strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean isValid(String word) {
        for (Strategy strategy : strategies) {
            if (strategy.isValid(word)) {
                return true;
            }
        }
        return false;
    }
}
