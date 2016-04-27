package gof.strategy;

public class AirplaneStrategy implements TravelStrategy {

    @Override
    public void travel() {
        System.out.println("Travel by airplane ...");
    }
}
