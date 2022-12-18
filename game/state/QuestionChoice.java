package game.state;

public class QuestionChoice {
    private State nextState;
    private String text;
    public QuestionChoice(String text){
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNextState(State nextState) {
        this.nextState =nextState;
    }

    public State getNextState() {

        return nextState;
    }
}
