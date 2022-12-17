package game.state;

public class GanFriend extends Gan{
    private Integer loveLevel ;
    private String name;

    @Override
    public State getNextState() {
        return super.getNextState();
    }

    @Override
    public void setNextState(State nextState) {
        super.setNextState(nextState);
    }

    @Override
    public State getState() {
        return super.getState();
    }

    public void setLoveLevel(Integer loveLevel) {
        this.loveLevel = loveLevel;
    }

    public Integer getLoveLevel() {
        return loveLevel;
    }

    public String getName() {
        return name;
    }

    @Override
    public void setState(State state) {
        super.setState(state);
    }

    public void setName(String name) {
        this.name = name;
    }
}
