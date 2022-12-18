package game;

import game.imp.Import;
import game.state.Gan;
import game.view.HomePage;

import java.io.FileNotFoundException;

import game.view.HomePage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        new HomePage();
//        Gan gan = new Gan();
//        gan.getState();

        Import imp = new Import();
        try {
            imp.load();
        } catch (IOException error) {
            System.err.println("File not found");
        }
    }
}
