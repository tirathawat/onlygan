package game.state;

public class GanFriend {
    private Integer loveLevel;
    private String name;

    private boolean isDisplay;
    
    public GanFriend(){
        loveLevel=0;
    }

    public void setIsDisplay (boolean isDisplay) {
        this.isDisplay = isDisplay;
    }

    public boolean getIsDisplay () {
        return this.isDisplay;
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
