package game.state;

public class EndState implements State{
    @Override
    public void render() {
        System.out.println("end state");
    }

    @Override
    public void getNextState(Gan gan) {

    }

    @Override
    public void getBackground() {

    }

}
