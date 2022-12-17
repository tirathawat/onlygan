package game.state;

import java.util.ArrayList;
import java.util.List;

public class QuestionState implements State{
    private List<Choice> choice = new ArrayList<>();
    private Choice select;
    private State nextState;
    @Override
    public void render() {
        System.out.println("question state");

    }

    @Override
    public State getNextState() {
        return nextState;
    }

    @Override
    public void getBackground() {

    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public void setChoice(List<Choice> choice) {
        this.choice = choice;
    }

    public void setSelect(Choice select) {
        this.select = select;
    }

    public Choice getSelect() {
        return select;
    }

    public List<Choice> getChoice() {
        return choice;
    }
}
