package gof.strategy;

public class PersonContext {

    private TravelStrategy strategy;

    public TravelStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(TravelStrategy strategy) {
        this.strategy = strategy;
    }

    public void operate() {
        strategy.travel();
    }
}
