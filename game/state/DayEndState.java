package game.state;

import game.command.Choice;

import java.util.List;

public class DayEndState extends State{
    DayEndState(State nextState, String dialogMessage, String background, String foreground) {
        super(nextState, dialogMessage, background, foreground);
    }

    @Override
    public List<Choice> getChoices() {
        return null;
    }


}
