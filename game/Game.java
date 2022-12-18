package game;

import game.loader.Loader;
import game.state.*;
import game.router.Router;
import game.view.GameWindow;
import game.view.HomePage;
import game.viewmodel.GameViewModel;

import javax.swing.*;

import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Loader loader = loadGame();
            State firstState = loader.getFirstState();
            Context context = new Context(firstState);
            GameViewModel viewModel = new GameViewModel(context);
            HomePage homePage = new HomePage(viewModel);
            GameWindow window = new GameWindow(homePage);
            Router.getInstance().setObserver(window);
            window.setVisible(true);
        });
    }

    private static Loader loadGame() {
        Loader loader = new Loader();
        try {
            loader.load();
        } catch (IOException error) {
            System.err.println("File not found");
        }

        return loader;
    }

}
