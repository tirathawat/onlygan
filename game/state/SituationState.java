package game.state;

public class SituationState implements State{
    private String description;
    private String Background;
    private State nextState;

    SituationState(){}

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void render() {
        // Jframe
        System.out.println("situation");
    }

    @Override
    public State getNextState(){
        return nextState;
    };

    @Override
    public void getBackground() {

    }

    public void setBackground(String background) {
        Background = background;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }
}
