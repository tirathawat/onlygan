package game.state;

public class QuestionChoice {
    private State nextState;
    private String text;

    private GanFriend effectFriendOnSelect;
    private int effectHeartOnSelect;

    private GanFriend effectFriendOnNotSelect;
    private int effectHeartOnNotSelect;

    public void setEffectOnSelect(GanFriend friend, int heart) {
        this.effectFriendOnSelect = friend;
        this.effectHeartOnSelect = heart;
    }
    public void setEffectOnNotSelect(GanFriend friend, int heart) {
        this.effectFriendOnNotSelect = friend;
        this.effectHeartOnNotSelect = heart;
    }

    public void onSelect () {
        this.effectFriendOnSelect.addLoveLevel(this.effectHeartOnSelect);
    }

    public void onNotSelect () {
        this.effectFriendOnNotSelect.addLoveLevel(this.effectHeartOnNotSelect);
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
