package game.state;

import game.command.Choice;

import java.util.ArrayList;
import java.util.List;

public class DayEndState extends State {
    public DayEndState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }

    @Override
    public String getDialogMessage() {
        return getLoveStatMessage();
    }

    private String getLoveStatMessage() {
        StringBuilder sb = new StringBuilder();
        Gan gan = Gan.getInstance();
        gan.loveAllFriends();

        for (GanFriend friend : gan.getFriends()) {
            if (!friend.getIsDisplay()) {
                continue;
            }

            sb.append(String.format("%s : %d หัวใจ\t\t", friend.getName(), friend.getLoveLevel()));
        }

        return sb.toString();
    }

    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("ถัดไป"));
        return choices;
    }

}
