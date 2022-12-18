package game.state;

public class GanFriend {
    private Integer loveLevel;
    private String name;
    
    public GanFriend(){
        loveLevel=0;
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
