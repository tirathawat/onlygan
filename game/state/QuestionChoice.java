package game.state;

public class QuestionChoice {
    private State nextState;
    private String text;
    private GanFriend effectedFriend;
    private int effectedHeart;

    public QuestionChoice(String text) {
        this.text = text;
    }

    public void setEffectOnSelect(GanFriend friend, int heart) {
        this.effectedFriend = friend;
        this.effectedHeart = heart;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public void onSelect() {
        this.effectedFriend.addLoveLevel(this.effectedHeart);
    }
}
