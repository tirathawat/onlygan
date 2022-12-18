package game.imp;

import game.state.State;

import java.util.ArrayList;
import java.util.List;

public class SheetState {
    private String type;
    private Integer index;

    private State state;
    public SheetState (State state) {
        this.state = state;
    }
    public SheetState (State state, String type, Integer index) {
        this.state = state;
        this.type = type;
        this.index = index - 1;
    }

    public State getState() {
        return state;
    }

    public Integer getIndex() {
        return index;
    }

    public String getType() {
        return type;
    }
}
