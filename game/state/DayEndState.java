package game.state;

import game.command.Choice;

import java.util.ArrayList;
import java.util.List;

public class DayEndState extends State{
    public DayEndState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }

    @Override
    public String getDialogMessage() {
        List<GanFriend> friends = Gan.getInstance().getEndDayFriends();
        String result = "";
        for (GanFriend friend : friends) {
            result += String.format("%s : %d หัวใจ        ", friend.getName(), friend.getLoveLevel());
        }
        return result;
    }

    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("ถัดไป", () -> {
        }));
        return choices;
    }


}
