package game.command;

public class Choice {
    private String text;
    private Commandable command;

    public Choice(String text, Commandable command) {
        this.text = text;
        this.command = command;
    }

    public String getText() {
        return text;
    }

    public void onSelectedChoice() {
        command.execute();
    }
}
