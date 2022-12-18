package game.view;

import javax.swing.*;
import java.awt.Font;
import java.io.InputStream;
import game.viewmodel.*;
import game.assets.Assets;

public abstract class View extends JPanel implements Rebuildable {
    protected Font gameFont;

    protected View(ViewModel viewModel) {
        viewModel.setObserver(this);
        gameFont = loadFont();
    }

    abstract void build();

    @Override
    public void rebuild() {
        removeAll();
        build();
        revalidate();
        repaint();
    }

    Font loadFont() {
        try {
            InputStream fontStream = getClass().getResourceAsStream(Assets.GAME_FONT);
            return Font.createFont(Font.TRUETYPE_FONT, fontStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
