package gof.state;

public class PublishState implements State {

    @Override
    public void handle(Context context) {
        System.out.println("Publish...");
        context.setCurrentState(new CompletedState());
    }
}
