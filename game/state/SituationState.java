package game.state;

import java.util.ArrayList;
import java.util.List;
import game.command.Choice;

public class SituationState extends State {

    public SituationState(String description, String background, String foreground) {
        super(description, background, foreground);
    }

    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("ถัดไป", () -> {
        }));
        return choices;
    }
}
