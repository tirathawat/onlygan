package game.state;

import game.command.Choice;

import java.util.ArrayList;
import java.util.List;

public class DialogState extends State {
    public DialogState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }

    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("ถัดไป"));
        return choices;
    }
}
