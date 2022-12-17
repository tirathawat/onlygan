package game.state;

public class DialogState implements State{
    private String speaker;
    private String emotion;
    private String message;
    private State nextState;

    @Override
    public void render() {
        System.out.println("dialog state");
    }

    @Override
    public State getNextState(){
        return nextState;
    };

    @Override
    public void getBackground() {

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
