package game.state;

import game.command.Choice;

import java.util.ArrayList;
import java.util.List;

public class QuestionState extends State {
    private List<QuestionChoice> questionChoice = new ArrayList<>();

    public QuestionState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }

    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        for (QuestionChoice choice : this.questionChoice) {
            choices.add(new Choice(choice.getText(), () -> {
                super.setNextState(choice.getNextState());
                choice.onSelect();
            }));
        }

        return choices;
    }

    public void setChoice(List<QuestionChoice> questionChoice) {
        this.questionChoice = questionChoice;
    }

    public List<QuestionChoice> getChoice() {
        return questionChoice;
    }
}
