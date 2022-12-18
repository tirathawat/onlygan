package game.assets;

public abstract class Scene {

    private static final String BASE = "assets/images/scenes/";

    public static String generateBackgroundPath (String name) {
        return BASE + name + ".jpg";
    }

    private Scene () {}
}
