package game.state;

import game.router.Router;

import java.util.ArrayList;
import java.util.List;

public class Gan {
    private static Gan instance = null;
    private Gan() {
    }
    public static Gan getInstance() {
        if (instance == null)
            instance = new Gan();

        return instance;
    }
    private State state ;
    private State nextState;

    private List<GanFriend> friends;

    public void setFriends (List<GanFriend> friends) {
        this.friends = friends;
    }


    private void calculateLoveLevel () {
        for (GanFriend friend : this.friends) {
            friend.addLoveLevel(1);
        }
    }

    public List<GanFriend> getEndDayFriends () {
        calculateLoveLevel();
        return this.friends;
    }

    public List<GanFriend> getFriends () {
        return this.friends;
    }

    public State getNextState() {
        return nextState;
    }

    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
