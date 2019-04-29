import hangman.HangmanConsoleWindow;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    HangmanConsoleWindow hcw = new HangmanConsoleWindow();
    public ArrayList Wordlist = new ArrayList();

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        while (true){


            System.out.print("Play again? [Y]es [N]o");
            if (YorNBoolean(input)){
                break;
            }
        }
    }

    private static boolean YorNBoolean (String input) {
        boolean out = false;
        while (true) {
            if (input.length() == 1) {
                if (input.toUpperCase().equals("Y")) {
                    return true;
                } else if (input.toUpperCase().equals("N")) {
                    return false;
                } else {
                    System.out.print("Error in \"YorNBoolean\" ID:1");
                }
            } else {
                System.out.print("Error in \"YorNBoolean\" ID:2");
            }
        }
    }

    public static void LoadWords (String FileName){
        
    }
}
