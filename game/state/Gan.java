package game.state;

public class Gan {
    private State state = new SituationState();

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void nextState(){
        state.getNextState(this);
    }

}
