package game.view;

import java.io.InputStream;

import javax.swing.*;
import java.awt.Font;

import game.router.RouterObserver;

public class GameWindow extends JFrame implements RouterObserver {
    static final String TITLE = "OnlyGan";

    private View currentView;

    public GameWindow(View view) {
        currentView = view;
        setTitle(TITLE);
        setExtendedState(MAXIMIZED_BOTH);
        setFont(loadFont());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildView();
    }

    private Font loadFont() {
        try {
            InputStream fontStream = getClass().getResourceAsStream("/assets/fonts/MNKunghaeng.ttf");
            return Font.createFont(Font.TRUETYPE_FONT, fontStream);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void navigateTo(View view) {
        remove(currentView);
        currentView = view;
        buildView();
    }

    private void buildView() {
        currentView.build();
        add(currentView);
        revalidate();
        repaint();
    }
}