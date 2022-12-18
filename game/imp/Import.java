package game.imp;
import game.state.DialogState;
import game.state.Gan;
import game.state.GanFriend;
import game.state.SituationState;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Import {

    private static final String basePath = "C:\\Users\\gan13\\Desktop\\Works\\onlygan\\game\\imp\\files";

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
        List<DialogState> dialogs = loadDialog(friends);
        List<SituationState> situations = loadSituation();
        System.out.println(dialogs.size());
    }

    private List<SituationState> loadSituation () throws IOException {
        List<SituationState> situations = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/dialogs.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            SituationState situation = new SituationState();
            situation.setDescription(val[2]);
            situations.add(situation);
        }
        return situations;
    }

    private List<DialogState> loadDialog (List<GanFriend> friends) throws IOException {
        List<DialogState> dialogs = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(basePath + "/dialogs.csv"));
        String line = "";
        String splitBy = ",";
        while ((line = br.readLine()) != null)
        {
            String[] val = line.split(splitBy);
            DialogState dialog = new DialogState();
            dialog.setMessage(val[2]);
            dialogs.add(dialog);
        }
        return dialogs;
    }
}
