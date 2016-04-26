package gof.state;

public class CompletedState implements State {

    @Override
    public void handle(Context context) {
        System.out.println("Completed");
        context.setCurrentState(null);
    }

}
