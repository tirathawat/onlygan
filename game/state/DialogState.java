package game.state;

import game.command.Choice;

import java.util.ArrayList;
import java.util.List;

public class DialogState extends State{
    private String speaker;
    private String emotion;
    private String message;
    public DialogState(String dialogMessage, String background, String foreground) {
        super(dialogMessage, background, foreground);
    }

    @Override
    public List<Choice> getChoices() {
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("ถัดไป", () -> {
        }));
        return choices;
    }

    public String getEmotion() {
        return emotion;
    }

    public String getMessage() {
        return message;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }
}
