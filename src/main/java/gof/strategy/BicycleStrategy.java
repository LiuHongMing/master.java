package gof.strategy;

public class BicycleStrategy implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("Travel by bicycle ...");
    }
}
