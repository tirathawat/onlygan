package game.loader;

import game.assets.Contents;
import game.assets.Player;
import game.assets.Scene;
import game.state.*;
import game.state.QuestionChoice;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    private State firstState;

    public State getFirstState() {
        return this.firstState;
    }

    public void load() throws IOException {
        List<GanFriend> friends = loadFriend();
        loadState(friends);
    }

    private List<GanFriend> loadFriend() throws IOException {
        List<GanFriend> friends = new ArrayList<>();
        Gan.getInstance().setFriends(friends);
        BufferedReader br = new BufferedReader(new FileReader(Contents.FRIENDS));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null) {
            String[] val = line.split(splitBy);
            GanFriend friend = new GanFriend();
            friend.setName(val[1]);
            friend.setIsDisplay(val[2].equals("show"));
            friends.add(friend);
        }
        return friends;
    }

    private void loadState(List<GanFriend> friends) throws IOException {
        Sheet dialogs = loadDialog(friends);
        Sheet situations = loadSituation();

        List<SheetStateChoice> choices = loadChoice(friends);

        Sheet questions = loadQuestion(choices);

        Sheet days = loadDayEnd();
        Sheet ends = loadEnding();

        dialogs.link(dialogs, situations, questions, days, ends);
        situations.link(dialogs, situations, questions, days, ends);
        questions.link(dialogs, situations, questions, days, ends);
        days.link(dialogs, situations, questions, days, ends);
        ends.link(dialogs, situations, questions, days, ends);

        linkChoice(choices, dialogs, situations, questions, days, ends);

        this.firstState = dialogs.getStates().get(0);
    }

    private void linkChoice (List<SheetStateChoice> choices, Sheet _dialogs, Sheet _situations, Sheet _questions, Sheet _days, Sheet _ends) {
        List<State> dialogs = _dialogs.getStates();
        List<State> situations = _situations.getStates();
        List<State> questions = _questions.getStates();
        List<State> days = _days.getStates();
        List<State> ends = _ends.getStates();
        for  (SheetStateChoice choice : choices) {
            switch (choice.getNextType()) {
                case "Dialogs" :
                    choice.getChoice().setNextState(dialogs.get(choice.getNextIndex()));
                    break;
                case "Situation" :
                    choice.getChoice().setNextState(situations.get(choice.getNextIndex()));
                    break;
                case "Question" :
                    choice.getChoice().setNextState(questions.get(choice.getNextIndex()));
                    break;
                case "DayEnd" :
                    choice.getChoice().setNextState(days.get(choice.getNextIndex()));
                    break;
                case "Ending" :
                    choice.getChoice().setNextState(ends.get(choice.getNextIndex()));
                    break;
            }
        }
    }

    private Sheet loadDayEnd() throws IOException {
        Sheet sheet = new Sheet();
        BufferedReader br = new BufferedReader(new FileReader(Contents.DAY_END));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null) {
            String[] val = line.split(splitBy);
            String nextStateType = val[1];
            Integer nextStateIndex = Integer.parseInt(val[2]);
            DayEndState day = new DayEndState("", Scene.generateBackgroundPath("end-day"), "");
            sheet.push(day, nextStateType, nextStateIndex);
        }
        return sheet;
    }

    private Sheet loadEnding() throws IOException {
        Sheet sheet = new Sheet();
        BufferedReader br = new BufferedReader(new FileReader(Contents.ENDING));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null) {
            String[] val = line.split(splitBy);
            EndState end = new EndState(val[1], Scene.generateBackgroundPath("final"), "");
            sheet.push(end);
        }
        return sheet;
    }

    private Sheet loadQuestion(List<SheetStateChoice> allChoices) throws IOException {
        Sheet sheet = new Sheet();
        BufferedReader br = new BufferedReader(new FileReader(Contents.QUESTIONS));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null) {
            String[] val = line.split(splitBy);
            String background = val[6];
            QuestionState question = new QuestionState(val[1], Scene.generateBackgroundPath(background), Player.generatePlayerPath("0"));
            List<QuestionChoice> choices = new ArrayList<>();
            int start = line.indexOf("\"") + 1;
            int end = line.indexOf("\"", start);
            String choiceStr = line.substring(start, end);
            for (String _id : choiceStr.split(",")) {
                int id = Integer.parseInt(_id);
                choices.add(allChoices.get(id - 1).getChoice());
            }
            question.setChoice(choices);
            sheet.push(question);
        }
        return sheet;
    }

    private List<SheetStateChoice> loadChoice(List<GanFriend> friends) throws IOException {
        List<SheetStateChoice> choices = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(Contents.CHOICES));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null) {
            String[] val = line.split(splitBy);
            QuestionChoice choice = new QuestionChoice(val[1]);
            choice.setEffectOnSelect(friends.get(Integer.parseInt(val[4])), Integer.parseInt(val[5]));
            SheetStateChoice sheet = new SheetStateChoice(val[2], Integer.parseInt(val[3]));
            sheet.setChoice(choice);
            choices.add(sheet);
        }
        return choices;
    }

    private Sheet loadSituation() throws IOException {
        Sheet sheet = new Sheet();
        BufferedReader br = new BufferedReader(new FileReader(Contents.SITUATIONS));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null) {
            String[] val = line.split(splitBy);
            String background = val[4];
            SituationState situation = new SituationState(val[1], Scene.generateBackgroundPath(background), "");
            sheet.push(situation, val[2], Integer.parseInt(val[3]));
        }
        return sheet;
    }

    private Sheet loadDialog(List<GanFriend> friends) throws IOException {
        Sheet sheet = new Sheet();
        BufferedReader br = new BufferedReader(new FileReader(Contents.DIALOGS));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null) {
            String[] val = line.split(splitBy);
            GanFriend speaker = friends.get(Integer.parseInt(val[1]));
            String message = val[2];
            String background = val[5];
            DialogState dialog = new DialogState(speaker, message, Scene.generateBackgroundPath(background), Player.generatePlayerPath(val[1]));
            sheet.push(dialog, val[3], Integer.parseInt(val[4]));
        }
        return sheet;
    }
}