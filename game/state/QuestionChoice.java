package game.state;

public class QuestionChoice {
    private String text;
    private State nextState;
    QuestionChoice(String text,State nextState){
        this.text = text;
        this.nextState = nextState;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public State getNextState() {
        return nextState;
    }
}
