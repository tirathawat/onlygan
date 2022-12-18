package game.state;

public interface State {
    public void render();
    public State getNextState();
    public void setNextState(State nextState);
    public void getBackground();
}
