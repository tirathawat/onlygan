package game.loader;

import game.state.State;

import java.util.ArrayList;
import java.util.List;

public class Sheet {
    private List<SheetState> states = new ArrayList<>();

    public Sheet() {

    }

    public void push (State state, String type, Integer index) {
        states.add(new SheetState(state, type, index));
    }

    public List<State> getStates () {
        List<State> states = new ArrayList<>();
        for (SheetState state : this.states) {
            states.add(state.getState());
        }
        return states;
    }

    public void push (State state) {
        states.add(new SheetState(state));
    }

    public void link (Sheet _dialogs, Sheet _situations, Sheet _questions, Sheet _days, Sheet _ends) {
        List<State> dialogs = _dialogs.getStates();
        List<State> situations = _situations.getStates();
        List<State> questions = _questions.getStates();
        List<State> days = _days.getStates();
        List<State> ends = _ends.getStates();
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