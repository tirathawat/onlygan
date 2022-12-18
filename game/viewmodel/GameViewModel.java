package game.viewmodel;

import java.util.List;

import game.command.*;
import game.router.Router;
import game.state.*;
import game.view.*;

public class GameViewModel extends ViewModel {
    private Context context;

    public GameViewModel(Context context) {
        this.context = context;
    }

    public void startGame() {
        this.context.reset();
        Router.getInstance().navigateTo(new DialogPage(this));
    }

    public String getBackground() {
        return context.getState().getBackground();
    }

    public String getForeground() {
        return context.getState().getForeground();
    }

    public String getDialogMessage() {
        return context.getState().getDialogMessage();
    }

    public List<Choice> getChoices() {
        List<Choice> choices = context.getState().getChoices();
        for (Choice choice : choices) {
            if (choice.isEnding()) {
                choice.addCommand(this::end);
                continue;
            }
            choice.addCommand(this::next);
        }
        return choices;
    }

    private void next() {
        State nextState = context.getState().getNextState();
        if (nextState != null) {
            context.setState(nextState);
            rebuild();
        }
    }

    private void end() {
        Router.getInstance().navigateTo(new HomePage(this));

    }
}
