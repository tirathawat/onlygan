package game.state;

import game.command.Choice;

import java.util.ArrayList;
import java.util.List;

public class EndState extends State{

    private String text;

    public EndState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }
    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("จบ", () -> {
        },true));
        return choices;
    }

    public void setText(String text) {
        this.text = text;
    }
}
