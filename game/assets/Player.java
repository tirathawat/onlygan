package game.assets;

public abstract class Player {
    private static final String BASE = "assets/images/players/";

    public static String generatePlayerPath (String name) {
        return BASE + name + ".png";
    }

    private Player () {}
}
