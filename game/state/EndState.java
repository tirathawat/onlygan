package game.state;

import game.command.Choice;

import java.util.List;

public class EndState extends State{

    private String text;

    public EndState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }

    @Override
    public State getNextState(){
        return null;
    }

    @Override
    public List<Choice> getChoices() {
        return null;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNextState (State next) {};
}
