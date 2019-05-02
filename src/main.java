import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import hangman.HangmanConsoleWindow;

public class main {
    public static ArrayList<String> Wordlist = new ArrayList<String>();

    public static void main(String [] args){
        HangmanConsoleWindow hcw = new HangmanConsoleWindow();
        hcw.changeTextColor(Color.green);

        ReadFileContent("wiki-100k.txt");


        while (true){
            hcw.print("Play again? [Y]es [N]o:");
            if (YorNBoolean(hcw.nextString())){
                //game
            }else{
                hcw.exit();
                break;
            }
        }
    }




    private static boolean YorNBoolean (String input) {
        switch (input.length()){
            case (1):
                if (input.toUpperCase().equals("Y")) {
                    return true;
                } else if (input.toUpperCase().equals("N")) {
                    return false;
                } else {
                    System.out.println("Error in \"YorNBoolean\" ID:1");
                    return false;
                }

            default:
                System.out.println("Error in \"YorNBoolean\" ID:2");
                return false;
        }
    }

    private static void ReadFileContent(String FileName){
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(FileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int i=0;
        assert in != null;
        while(in.hasNext()){
            i++;
            if (i<10){
                System.out.print("Line: " + i + "     ");
            }else if (i<100){
                System.out.print("Line: " + i + "    ");
            }else  if (i<1000){
                System.out.print("Line: " + i + "   ");
            }else if (i<10000){
                System.out.print("Line: " + i + "  ");
            }else if (i<100000){
                System.out.print("Line: " + i + " ");
            }

            if (!(in.next().charAt(0) =='#')) {
                Wordlist.add(in.next());
                System.out.println("Word found");
            } else {
                System.out.println("Comment found");
            }
        }
        in.close();
    }
}
