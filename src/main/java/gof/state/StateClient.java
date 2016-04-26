package gof.state;

public class StateClient {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        context.setCurrentState(startState);
        do {
            context.operator();
        } while (context.getCurrentState() != null);
    }
}
