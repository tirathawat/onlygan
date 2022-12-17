package game.state;

public class GanFriend extends Gan{
    private Integer loveLevel ;
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
}
