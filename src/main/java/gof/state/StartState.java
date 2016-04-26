package gof.state;

/**
 * Created by liuhongming on 4/26/2016.
 */
public class StartState implements State {

    @Override
    public void handle(Context context) {
        System.out.println("Start to process...");
        context.setCurrentState(new DraftState());
    }

}
