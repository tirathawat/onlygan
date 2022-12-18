package game.state;

public class Context {
    private State current;
    private State intial;

    public Context(State state) {
        this.current = state;
        this.intial = state;
    }

    public void setState(State state) {
        this.current = state;
    }

    public State getState() {
        return current;
    }

    public void reset(){
        this.current = this.intial;
    }
}
