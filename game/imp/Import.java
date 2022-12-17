package game.imp;
import java.io.*;
import java.util.Scanner;


public class Import {

    private static final String basePath = "C:\\Users\\gan13\\Desktop\\Works\\onlygan\\game\\imp\\files";

    public void loadFile () throws FileNotFoundException {
        Scanner sc = new Scanner(new File(basePath + "/friend.csv"));
        sc.useDelimiter(",");
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next());
        }
        sc.close();
    }
}
