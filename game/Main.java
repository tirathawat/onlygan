package game;

import game.state.*;
import game.router.Router;
import game.view.GameWindow;
import game.view.HomePage;
import game.viewmodel.GameViewModel;

import javax.swing.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Import imp = new Import();
        // try {
        // imp.load();
        // } catch (IOException error) {
        // System.err.println("File not found");
        // }

        SwingUtilities.invokeLater(() -> {

            SituationState situationState2 = new SituationState(null, "ผมรักแกน",
                    "/assets/example-background.jpeg",
                    "/assets/example-foreground.png");

            SituationState situationState1 = new SituationState(situationState2, "สวัสดีครับ",
                    "/assets/example-background.jpeg",
                    "/assets/example-foreground.png");

            Context context = new Context(situationState1);
            GameViewModel viewModel = new GameViewModel(context);
            HomePage homePage = new HomePage(viewModel);
            GameWindow window = new GameWindow(homePage);
            Router.getInstance().setObserver(window);
            window.setVisible(true);
        });
    }
}
