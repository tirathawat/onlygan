package game.state;

public interface State {
    public void render();
    public void getNextState(Gan gan);
    public void getBackground();
}
