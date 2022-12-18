package game;

import game.imp.Import;
import game.state.*;
import game.router.Router;
import game.view.GameWindow;
import game.view.HomePage;
import game.viewmodel.GameViewModel;

import javax.swing.*;

import java.awt.*;
import java.io.FileNotFoundException;

import game.view.HomePage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

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
            GameViewModel viewModel = GameViewModel.getInstance();
            HomePage homePage = new HomePage(viewModel);
            GameWindow window = new GameWindow(homePage);
            Router.getInstance().setObserver(window);
            window.setVisible(true);
        });
    }
}
