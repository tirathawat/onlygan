package game.state;

public class GanFriend {
    private Integer loveLevel;
    private String name;
    
    public void setLoveLevel(Integer loveLevel) {
        this.loveLevel = loveLevel;
    }

    public Integer getLoveLevel() {
        return loveLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addLoveLevel (Integer level) {
        this.loveLevel += level;
    }
}
