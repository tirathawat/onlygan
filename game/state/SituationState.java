package game.state;

public class SituationState implements State{
    String description;
    String Background;
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
    public void getNextState(Gan gan) {
        gan.setState(new DialogState());
    }

    @Override
    public void getBackground() {

    }

}
