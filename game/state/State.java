package game.state;

import java.util.List;
import game.command.Choice;

public abstract class State {
    private State nextState;
    private String dialogMessage;
    private String background;
    private String foreground;

    State(State nextState, String dialogMessage, String background, String foreground) {
        this.nextState = nextState;
        this.dialogMessage = dialogMessage;
        this.background = background;
        this.foreground = foreground;
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
