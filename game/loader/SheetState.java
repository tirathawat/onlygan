package game.loader;
import game.state.State;

public class SheetState {

    private String nextType;
    private Integer nextIndex;

    private State state;
    public SheetState (State state) {
        this.state = state;
    }
    public SheetState (State state, String nextType, Integer nextIndex) {
        this.state = state;
        this.nextType = nextType;
        this.nextIndex = nextIndex - 1;
    }
    public SheetState (String nextType, Integer nextIndex) {
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

}