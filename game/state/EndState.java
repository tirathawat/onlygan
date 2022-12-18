package game.state;

import game.command.Choice;

import java.util.ArrayList;
import java.util.List;

public class EndState extends State {
    public EndState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }

    @Override
    public String getDialogMessage() {
        StringBuilder sb = new StringBuilder();
        for (GanFriend friend : Gan.getInstance().getHarem()) {
            sb.append(String.format("%s ", friend.getName()));
        }

        return sb.toString();
    }

    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("จบ", true));
        return choices;
    }

}
