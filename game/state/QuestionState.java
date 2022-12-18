package game.state;

import java.util.ArrayList;
import java.util.List;

import game.command.Choice;

public class QuestionState extends State {
    private List<QuestionChoice> choices;

    public QuestionState(State nextState, String question, String background, String foreground,
            List<QuestionChoice> choices) {
        super(nextState, question, background, foreground);
        this.choices = choices;
    }

    @Override
    public List<Choice> getChoices() {
        return new ArrayList<>();
    }
}
