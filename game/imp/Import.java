package game.imp;
import game.state.*;
import game.state.QuestionChoice;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Import {

    private static final String basePath = "C:\\Users\\gan13\\Desktop\\Works\\onlygan\\game\\imp\\files";

    private List<DialogState> dialogs;
    private List<SituationState> situations;
    private List<QuestionState> questions;
    private List<DayEndState> days;
    private List<EndState> ends;

    public List<DialogState> getDialogs() {
        return dialogs;
    }

    public List<SituationState> getSituations() {
        return situations;
    }

    public List<QuestionState> getQuestions() {
        return questions;
    }

    public List<DayEndState> getDays() {
        return days;
    }

    public List<EndState> getEnds() {
        return ends;
    }

    public State getFirstState () {
        return dialogs.get(0);
    }

    public void load () throws IOException {
        List<GanFriend> friends = loadFriend();
        loadState(friends);
    }

    private List<GanFriend> loadFriend () throws IOException {
        List<GanFriend> friends = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/friend.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            GanFriend friend = new GanFriend();
            friend.setName(val[1]);
            friends.add(friend);
        }
        return friends;
    }

    private void loadState (List<GanFriend> friends) throws IOException {
        Sheet dialogs = loadDialog(friends);
        Sheet situations = loadSituation();

        List<SheetStateChoice> choices = loadChoice();

        Sheet questions = loadQuestion(choices);

        Sheet days = loadDayEnd();
        Sheet ends = loadEnding();

        dialogs.link(dialogs, situations, questions, days, ends, choices);
        situations.link(dialogs, situations, questions, days, ends, choices);
        questions.link(dialogs, situations, questions, days, ends, choices);
        days.link(dialogs, situations, questions, days, ends, choices);
        ends.link(dialogs, situations, questions, days, ends, choices);

        this.dialogs = dialogs.getGenericState();
        this.situations = situations.getGenericState();
        this.questions = questions.getGenericState();
        this.days = days.getGenericState();
        this.ends = ends.getGenericState();
    }

    private Sheet loadDayEnd () throws IOException {
        Sheet sheet = new Sheet("days");
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/day-end.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            DayEndState day = new DayEndState("","", "");
            sheet.push(day, val[1], Integer.parseInt(val[2]));
        }
        return sheet;
    }

    private Sheet loadEnding () throws IOException {
        Sheet sheet = new Sheet("ends");
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/ending.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            EndState end = new EndState(val[1], "", "");
            sheet.push(end);
        }
        return sheet;
    }

    private Sheet loadQuestion (List<SheetStateChoice> allChoices) throws IOException {
        Sheet sheet = new Sheet("questions");
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/question.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            QuestionState question = new QuestionState(val[1], "", "");
            question.setText(val[1]);
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

    private List<SheetStateChoice> loadChoice () throws IOException {
        List<SheetStateChoice> choices = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/choice.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            QuestionChoice choice = new QuestionChoice(val[1]);
            SheetStateChoice sheet = new SheetStateChoice(val[2], Integer.parseInt(val[3]));
            sheet.setChoice(choice);
            choices.add(sheet);
        }
        return choices;
    }

    private Sheet loadSituation () throws IOException {
        Sheet sheet = new Sheet("situations");
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/situation.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            SituationState situation = new SituationState(val[1], "", "");
            sheet.push(situation, val[2], Integer.parseInt(val[3]));
        }
        return sheet;
    }

    private Sheet loadDialog (List<GanFriend> friends) throws IOException {
        Sheet sheet = new Sheet("dialogs");
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/dialogs.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            DialogState dialog = new DialogState(val[2], "", "");
            sheet.push(dialog, val[3], Integer.parseInt(val[4]));
        }
        return sheet;
    }
}