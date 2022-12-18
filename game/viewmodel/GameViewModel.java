package game.viewmodel;

import java.util.List;

import game.command.Choice;
import game.router.Router;
import game.view.*;

public class GameViewModel extends ViewModel {
    private static GameViewModel instance = null;

    private String background;
    private String foreground;
    private int currentMessageIndex;

    private List<String> messages = new java.util.ArrayList<>();

    private GameViewModel() {
        currentMessageIndex = 0;
        background = "./assets/example-background.jpeg";
        foreground = "./assets/example-foreground.png";

        messages.add("<html><body>สวัสดีครับ! ผมชื่อซับ <br> ผมแอบชอบแกนมานานแล้ว</body></html>");
        messages.add("ผมมีอะไรจะบอกครับ");
        messages.add("ผมอยากเอาตูดแกนครับ!!");
    }

    public static GameViewModel getInstance() {
        if (instance == null)
            instance = new GameViewModel();

        return instance;
    }

    public String getBackground() {
        return background;
    }

    public String getForeground() {
        return foreground;
    }

    public String getDialogMessage() {
        return messages.get(currentMessageIndex);
    }

    public List<Choice> getChoices() {
        List<Choice> choices = new java.util.ArrayList<>();
        choices.add(new Choice("ย้อนกลับ", this::previousDialog));
        choices.add(new Choice("ต่อไป", this::nextDialog));
        return choices;
    }

    public void startGame() {
        Router.getInstance().navigateTo(new DialogPage(this));
    }

    public void nextDialog() {
        if (currentMessageIndex < messages.size() - 1)
            currentMessageIndex++;
        rebuild();
    }

    public void previousDialog() {
        if (currentMessageIndex > 0)
            currentMessageIndex--;
        rebuild();
    }
}
