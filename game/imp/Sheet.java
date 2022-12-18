package game.imp;

import game.state.Choice;
import game.state.DialogState;
import game.state.QuestionState;
import game.state.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Sheet {

    private String type;

    private List<SheetState> states = new ArrayList<>();

    public Sheet(String type) {
        this.type = type;
    }

    public void push (State state, String type, Integer index) {
        states.add(new SheetState(this.type, state, type, index));
    }

    public List<State> getStates () {
        List<State> states = new ArrayList<>();
        for (SheetState state : this.states) {
            states.add(state.getState());
        }
        return states;
    }


    public <T> List<T> getGenericState () {
        List<T> states = new ArrayList<>();
        for (SheetState state : this.states) {
            states.add((T) state.getState());
        }
        return states;
    }

    public void push (State state) {
        states.add(new SheetState(this.type, state));
    }

    public void link (Sheet _dialogs, Sheet _situations, Sheet _questions, Sheet _days, Sheet _ends, List<SheetStateChoice> choices) {
        List<State> dialogs = _dialogs.getStates();
        List<State> situations = _situations.getStates();
        List<State> questions = _questions.getStates();
        List<State> days = _days.getStates();
        List<State> ends = _ends.getStates();
        for  (SheetStateChoice choice : choices) {
            switch (choice.getNextType()) {
                case "Dialogs" :
                    choice.getChoice().setNextState(dialogs.get(choice.getNextIndex()));
                    break;
                case "Situation" :
                    choice.getChoice().setNextState(situations.get(choice.getNextIndex()));
                    break;
                case "Question" :
                    choice.getChoice().setNextState(questions.get(choice.getNextIndex()));
                    break;
                case "DayEnd" :
                    choice.getChoice().setNextState(days.get(choice.getNextIndex()));
                    break;
                case "Ending" :
                    choice.getChoice().setNextState(ends.get(choice.getNextIndex()));
                    break;
            }
        }
        for (SheetState state : this.states) {
            if (state.getNextType()==null) continue;
            switch (state.getNextType()) {
                case "Dialogs" :
                    state.getState().setNextState(dialogs.get(state.getNextIndex()));
                    break;
                case "Situation" :
                    state.getState().setNextState(situations.get(state.getNextIndex()));
                    break;
                case "Question" :
                    state.getState().setNextState(questions.get(state.getNextIndex()));
                    break;
                case "DayEnd" :
                    state.getState().setNextState(days.get(state.getNextIndex()));
                    break;
                case "Ending" :
                    state.getState().setNextState(ends.get(state.getNextIndex()));
                    break;
            }
        }
    }
}
