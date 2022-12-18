package game.assets;

public abstract class Assets {
    private static final String ASSETS_PATH = "onlygan/assets/";
    private static final String IMAGE_PATH = ASSETS_PATH + "images/";
    private static final String ICON_PATH = ASSETS_PATH + "icon/";
    private static final String FONT_PATH = ASSETS_PATH + "fonts/";

    public static final String PLAYER_IMAGE_PATH = IMAGE_PATH + "players/";
    public static final String SCENE_IMAGE_PATH = IMAGE_PATH + "scenes/";

    public static final String GAME_ICON = ICON_PATH + "onlygan.png";

    public static final String GAME_FONT = FONT_PATH + "FCParagraph-Light.ttf";

    private Assets() {
    }

}
