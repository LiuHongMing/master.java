package gof.state;

/**
 * Created by liuhongming on 4/26/2016.
 */
public class DraftState implements State {

    @Override
    public void handle(Context context) {
        System.out.println("Draft...");
        context.setCurrentState(new PublishState());
    }
}
