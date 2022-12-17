package game.state;

public class DialogState implements State{
    String speaker;
    String emotion;
    String message;

    @Override
    public void render() {
        System.out.println("dialog state");
    }

    @Override
    public void getNextState(Gan gan) {
        gan.setState(new QuestionState());
    }

    @Override
    public void getBackground() {

    }


}
