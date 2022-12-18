package game.state;

import game.command.Choice;

import java.util.ArrayList;
import java.util.List;

public class EndState extends State{

    private String text;

    public EndState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }

    @Override
    public String getDialogMessage() {
        List<GanFriend> friends = Gan.getInstance().getFriends();
        int maxLove = 0;
        for (GanFriend friend : friends) {
            if (friend.getLoveLevel() > maxLove) {
                maxLove = friend.getLoveLevel();
            }
        }
        String target = "";
        for (GanFriend friend : friends) {
            if (friend.getLoveLevel() == maxLove) {
                target += String.format("%s ", friend.getName());
            }
        }
        return super.getDialogMessage() + target;
    }

    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("จบ", () -> {
        },true));
        return choices;
    }

    public void setText(String text) {
        this.text = text;
    }
}
