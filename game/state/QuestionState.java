package game.state;

import game.command.Choice;

import java.util.ArrayList;
import java.util.List;

public class QuestionState extends State{
    private List<QuestionChoice> questionChoice = new ArrayList<>();
    private QuestionChoice select;
    private State nextState;

    private String text;

    public QuestionState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }
    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("ถัดไป", () -> {
        }));
        return choices;
    }
    @Override
    public State getNextState() {
        return nextState;
    }


    public void setText (String txt) {
        text = txt;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public void setChoice(List<QuestionChoice> questionChoice) {
        this.questionChoice = questionChoice;
    }

    public void setSelect(QuestionChoice select) {
        this.select = select;
    }

    public QuestionChoice getSelect() {
        return select;
    }

    public List<QuestionChoice> getChoice() {
        return questionChoice;
    }
}
