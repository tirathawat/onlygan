package game.state;

import java.util.ArrayList;
import java.util.List;

public class Gan {
    private static Gan instance = null;

    private List<GanFriend> friends;

    private Gan() {
    }

    public static Gan getInstance() {
        if (instance == null)
            instance = new Gan();

        return instance;
    }

    public void setFriends(List<GanFriend> friends) {
        this.friends = friends;
    }

    public List<GanFriend> getFriends() {
        return this.friends;
    }

    public List<GanFriend> getHarem() {
        List<GanFriend> harem = new ArrayList<>();
        int max = getMaxHeart();

        for (GanFriend friend : friends) {
            if (friend.getLoveLevel() == max) {
                harem.add(friend);
            }
        }

        return harem;
    }

    private int getMaxHeart() {
        int max = 0;
        for (GanFriend friend : friends) {
            if (friend.getLoveLevel() > max) {
                max = friend.getLoveLevel();
            }
        }

        return max;
    }

    public void loveAllFriends() {
        for (GanFriend friend : this.friends) {
            if (!friend.getIsCharacter()) continue;
            friend.addLoveLevel(1);
        }
    }
}
