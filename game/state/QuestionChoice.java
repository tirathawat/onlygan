package game.state;

public class QuestionChoice {
    private State nextState;
    private String text;

    private QuestionChoiceEffect effectOnSelect;
    private QuestionChoiceEffect effectOnNotSelect;

    public void setEffectOnSelect(GanFriend friend, int heart) {
        this.effectOnSelect = new QuestionChoiceEffect(friend, heart);
    }
    public void setEffectOnNotSelect(GanFriend friend, int heart) {
        this.effectOnNotSelect = new QuestionChoiceEffect(friend, heart);
    }

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
