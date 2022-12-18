package game.state;

import java.util.List;
import game.command.Choice;

public abstract class State {
    private State nextState;
    private final String dialogMessage;
    private final String background;
    private final String foreground;

    State(String dialogMessage, String background, String foreground) {
        this.dialogMessage = dialogMessage;
        this.background = background;
        this.foreground = foreground;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public State getNextState() {
        return nextState;
    }

    public String getDialogMessage() {
        return dialogMessage;
    }

    public String getBackground() {
        return background;
    }

    public String getForeground() {
        return foreground;
    }

    public abstract List<Choice> getChoices();
}
