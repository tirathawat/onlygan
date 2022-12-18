package game.state;

import game.command.Choice;

import java.util.List;

public class DayEndState extends State{
    public DayEndState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }

    @Override
    public List<Choice> getChoices() {
        return null;
    }


}
