package game.imp;
// import game.state.*;
// import game.state.QuestionChoice;

// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;

// public class Import {

// private static final String basePath =
// "C:\\Users\\gan13\\Desktop\\Works\\onlygan\\game\\imp\\files";

// public void load () throws IOException {
// List<GanFriend> friends = loadFriend();
// loadState(friends);
// }

// private List<GanFriend> loadFriend () throws IOException {
// List<GanFriend> friends = new ArrayList<>();
// BufferedReader br = new BufferedReader(new FileReader(basePath +
// "/friend.csv"));
// String line = "";
// String splitBy = ",";
// while ((line = br.readLine()) != null)
// {
// String[] val = line.split(splitBy);
// GanFriend friend = new GanFriend();
// friend.setName(val[1]);
// friends.add(friend);
// }
// return friends;
// }

// private void loadState (List<GanFriend> friends) throws IOException {
// Sheet dialogs = loadDialog(friends);
// Sheet situations = loadSituation();
// Sheet questions = loadQuestion();
// Sheet days = loadDayEnd();
// Sheet ends = loadEnding();

// dialogs.link(dialogs, situations, questions, days, ends);
// situations.link(dialogs, situations, questions, days, ends);
// questions.link(dialogs, situations, questions, days, ends);
// days.link(dialogs, situations, questions, days, ends);
// ends.link(dialogs, situations, questions, days, ends);
// }

// private Sheet loadDayEnd () throws IOException {
// Sheet sheet = new Sheet("days");
// BufferedReader br = new BufferedReader(new FileReader(basePath +
// "/day-end.csv"));
// String line = "";
// String splitBy = ",";
// while ((line = br.readLine()) != null)
// {
// String[] val = line.split(splitBy);
// DayEndState day = new DayEndState();
// sheet.push(day, val[1], Integer.parseInt(val[2]));
// }
// return sheet;
// }

// private Sheet loadEnding () throws IOException {
// Sheet sheet = new Sheet("ends");
// BufferedReader br = new BufferedReader(new FileReader(basePath +
// "/ending.csv"));
// String line = "";
// String splitBy = ",";
// while ((line = br.readLine()) != null)
// {
// String[] val = line.split(splitBy);
// EndState end = new EndState();
// end.setText(val[1]);
// sheet.push(end);
// }
// return sheet;
// }

// private Sheet loadQuestion () throws IOException {
// Sheet sheet = new Sheet("questions");
// List<QuestionChoice> allChoices = loadChoice();
// BufferedReader br = new BufferedReader(new FileReader(basePath +
// "/question.csv"));
// String line = "";
// String splitBy = ",";
// while ((line = br.readLine()) != null)
// {
// String[] val = line.split(splitBy);
// QuestionState question = new QuestionState();
// question.setText(val[1]);
// List<QuestionChoice> choices = new ArrayList<>();
// int start = line.indexOf("\"") + 1;
// int end = line.indexOf("\"", start);
// String choiceStr = line.substring(start, end);
// for (String _id : choiceStr.split(",")) {
// int id = Integer.parseInt(_id);
// choices.add(allChoices.get(id - 1));
// }
// question.setChoice(choices);
// sheet.push(question);
// }
// return sheet;
// }

// private List<QuestionChoice> loadChoice () throws IOException {
// List<QuestionChoice> choices = new ArrayList<>();
// BufferedReader br = new BufferedReader(new FileReader(basePath +
// "/choice.csv"));
// String line = "";
// String splitBy = ",";
// while ((line = br.readLine()) != null)
// {
// String[] val = line.split(splitBy);
// QuestionChoice choice = new QuestionChoice();
// choice.setText(val[1]);
// choices.add(choice);
// }
// return choices;
// }

// private Sheet loadSituation () throws IOException {
// Sheet sheet = new Sheet("situations");
// BufferedReader br = new BufferedReader(new FileReader(basePath +
// "/situation.csv"));
// String line = "";
// String splitBy = ",";
// while ((line = br.readLine()) != null)
// {
// String[] val = line.split(splitBy);
// SituationState situation = new SituationState();
// situation.setDescription(val[1]);
// sheet.push(situation, val[2], Integer.parseInt(val[3]));
// }
// return sheet;
// }

// private Sheet loadDialog (List<GanFriend> friends) throws IOException {
// Sheet sheet = new Sheet("dialogs");
// BufferedReader br = new BufferedReader(new FileReader(basePath +
// "/dialogs.csv"));
// String line = "";
// String splitBy = ",";
// while ((line = br.readLine()) != null)
// {
// String[] val = line.split(splitBy);
// DialogState dialog = new DialogState();
// dialog.setMessage(val[2]);
// sheet.push(dialog, val[3], Integer.parseInt(val[4]));
// }
// return sheet;
// }
// }
