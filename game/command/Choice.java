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
