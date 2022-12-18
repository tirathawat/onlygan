package game.state;

import game.command.Choice;

import java.util.List;

public class DialogState extends State{
    private String speaker;
    private String emotion;
    private String message;
    private State nextState;
    DialogState(State nextState, String dialogMessage, String background, String foreground) {
        super(nextState, dialogMessage, background, foreground);
    }

    @Override
    public List<Choice> getChoices() {
        return null;
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

    public void setNextState(State nextState) {
        this.nextState = nextState;
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
