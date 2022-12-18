package game;

import game.imp.Import;
import game.state.*;
import game.router.Router;
import game.view.GameWindow;
import game.view.HomePage;
import game.viewmodel.GameViewModel;

import javax.swing.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
         Import imp = new Import();
         try {
            imp.load();
         } catch (IOException error) {
            System.err.println("File not found");
         }
         State firstState = imp.getFirstState();

        SwingUtilities.invokeLater(() -> {
            Context context = new Context(firstState);
            GameViewModel viewModel = new GameViewModel(context);
            HomePage homePage = new HomePage(viewModel);
            GameWindow window = new GameWindow(homePage);
            Router.getInstance().setObserver(window);
            window.setVisible(true);
        });
    }
}
