package game.command;

public class Choice {
    private String text;
    private boolean isEnding;
    private Commandable command;

    public Choice(String text, Commandable command) {
        this.text = text;
        this.command = command;
        this.isEnding = false;
    }

    public Choice(String text, Commandable command,boolean isEnding) {
        this.text = text;
        this.command = command;
        this.isEnding = isEnding;
    }

    public boolean isEnding() {
        return isEnding;
    }

    public String getText() {
        return text;
    }

    public Commandable getCommand() {
        return command;
    }

    public void addCommand(Commandable command) {
        Commandable oldCommand = this.command;
        this.command = () -> {
            oldCommand.execute();
            command.execute();
        };
    }

    public void onSelectedChoice() {
        command.execute();
    }
}
