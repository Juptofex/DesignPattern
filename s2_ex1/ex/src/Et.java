import java.util.List;

public class Et implements Strategy {
    private Strategy[] strategies;

    public Et(Strategy...strategies) {
        this.strategies = strategies;
    }

    @Override
    public boolean isValid(String word) {
        for (Strategy strategy : strategies) {
            if (!strategy.isValid(word)) {
                return false;
            }
        }
        return true;
    }
}
