package gof.state;

public class Context {
    private State currentState;

    public Context() {
    }

    public void operator() {
        currentState.handle(this);
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
