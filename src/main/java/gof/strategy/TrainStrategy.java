package gof.strategy;

public class TrainStrategy implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("Travel by train ...");
    }
}
