package game.state;

public class EndState implements State{
    @Override
    public void render() {
        System.out.println("end state");
    }

    @Override
    public State getNextState(){
        return null;
    }

    @Override
    public void getBackground() {

    }

}
