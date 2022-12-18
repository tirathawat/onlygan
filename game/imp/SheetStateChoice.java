package game.imp;

import game.state.Choice;

public class SheetStateChoice extends  SheetState{

    private Choice choice;

    SheetStateChoice(String nextType, Integer nextIndex) {
        super("choices", nextType, nextIndex);
    }

    public void setChoice (Choice choice) {
        this.choice = choice;
    }

    public Choice getChoice() {
        return choice;
    }
}
