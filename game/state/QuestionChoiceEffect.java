package game.state;

public class QuestionChoiceEffect {
    private GanFriend friend;
    private int heart;

    public QuestionChoiceEffect (GanFriend friend, int heart) {
        this.friend = friend;
        this.heart = heart;
    }

    public void action () {
        this.friend.addLoveLevel(this.heart);
    }
}
