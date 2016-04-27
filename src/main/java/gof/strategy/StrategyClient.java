package gof.strategy;

public class StrategyClient {

    public static void main(String[] args) {
        PersonContext person = new PersonContext();

        person.setStrategy(new TrainStrategy());
        person.operate();

        person.setStrategy(new BicycleStrategy());
        person.operate();

    }
}
