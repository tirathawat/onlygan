package game;

<<<<<<< HEAD
=======
import game.imp.Import;
import game.state.Gan;
>>>>>>> b0d5356 (add import class)
import game.view.HomePage;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
<<<<<<< HEAD
        new HomePage();
=======
//        Gan gan = new Gan();
//        gan.getState();

        Import imp = new Import();
        try {
            imp.loadFile();
        } catch (FileNotFoundException error) {
            System.err.println("File not found");
        }
>>>>>>> b0d5356 (add import class)
    }
}
