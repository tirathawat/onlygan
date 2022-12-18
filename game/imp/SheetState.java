package game.imp;

import game.state.State;

import java.util.ArrayList;
import java.util.List;

public class SheetState {

    private String type;

    private String nextType;
    private Integer nextIndex;

    private State state;
    public SheetState (String type, State state) {
        this.state = state;
        this.type = type;
    }
    public SheetState (String type, State state, String nextType, Integer nextIndex) {
        this.type = type;
        this.state = state;
        this.nextType = nextType;
        this.nextIndex = nextIndex - 1;
    }
    public SheetState (String type, String nextType, Integer nextIndex) {
        this.type = type;
        this.nextType = nextType;
        this.nextIndex = nextIndex - 1;
    }

    public State getState() {
        return state;
    }

    public Integer getNextIndex() {
        return nextIndex;
    }

    public String getNextType() {
        return nextType;
    }

    public String getSelfType() {return type;}
}
