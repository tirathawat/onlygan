package game.view;

import javax.swing.*;
import game.router.RouterObserver;

public class GameWindow extends JFrame implements RouterObserver {
    static final String TITLE = "OnlyGan";

    private View currentView;

    public GameWindow(View view) {
        currentView = view;
        setTitle(TITLE);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        buildView();
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