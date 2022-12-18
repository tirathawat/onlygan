package game.imp;
import game.state.*;
import game.state.QuestionChoice;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Import {
    private static final String basePath = "C:\\Users\\subta\\Desktop\\onlygan\\onlygan\\game\\imp\\files";
    private static final String ASSET_PATH = "C:\\Users\\subta\\Desktop\\onlygan\\onlygan\\game\\imp\\files\\assets";

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
        return this.dialogs.get(0);
    }

    private List<GanFriend> friends;

    public List<GanFriend> getFriends() {
        return friends;
    }

    public void load () throws IOException {
        List<GanFriend> friends = loadFriend();
        loadState(friends);
    }

    private List<GanFriend> loadFriend () throws IOException {
        List<GanFriend> friends = new ArrayList<>();
        Gan.getInstance().setFriends(friends);
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/friend.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            GanFriend friend = new GanFriend();
            friend.setName(val[1]);
            friend.setIsDisplay(val[2]=="show");
            friends.add(friend);
        }
        return friends;
    }

    private void loadState (List<GanFriend> friends) throws IOException {
        Sheet dialogs = loadDialog(friends);
        Sheet situations = loadSituation();

        List<SheetStateChoice> choices = loadChoice(friends);

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
            DayEndState day = new DayEndState("",ASSET_PATH + "/end-day.PNG", "");
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
            EndState end = new EndState(val[1], ASSET_PATH + "/final.PNG", "");
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
            QuestionState question = new QuestionState(val[1], ASSET_PATH + "/" + val[6] + ".jpg", ASSET_PATH + "/player/0.png");
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

    private List<SheetStateChoice> loadChoice (List<GanFriend> friends) throws IOException {
        List<SheetStateChoice> choices = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/choice.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            QuestionChoice choice = new QuestionChoice(val[1]);
            choice.setEffectOnSelect(friends.get(Integer.parseInt(val[4])), Integer.parseInt(val[5]));
            choice.setEffectOnNotSelect(friends.get(Integer.parseInt(val[6])), Integer.parseInt(val[7]));
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
            SituationState situation = new SituationState(val[1], ASSET_PATH + "/" + val[4] + ".jpg", "");
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
            DialogState dialog = new DialogState(friends.get(Integer.parseInt(val[1])).getName() + " : " + val[2], ASSET_PATH + "/" + val[5] + ".jpg", ASSET_PATH + "/player/" + val[1] + ".png");
            sheet.push(dialog, val[3], Integer.parseInt(val[4]));
        }
        return sheet;
    }
}