package game.imp;

import game.state.QuestionChoice;

public class SheetStateChoice extends  SheetState{

    private QuestionChoice choice;

    SheetStateChoice(String nextType, Integer nextIndex) {
        super("choices", nextType, nextIndex);
    }

    public void setChoice (QuestionChoice choice) {
        this.choice = choice;
    }

    public QuestionChoice getChoice() {
        return choice;
    }
}
