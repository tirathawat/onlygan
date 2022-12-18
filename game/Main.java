package game;

import game.router.Router;
import game.view.GameWindow;
import game.view.HomePage;
import game.viewmodel.GameViewModel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameViewModel viewModel = GameViewModel.getInstance();
            HomePage homePage = new HomePage(viewModel);
            GameWindow window = new GameWindow(homePage);
            Router.getInstance().setObserver(window);
            window.setVisible(true);
        });
    }
}
