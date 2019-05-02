import java.awt.*;

import hangman.HangmanConsoleWindow;

public class main {
    private static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
    public static void main(String [] args){
        hcw.changeTextColor(Color.green);

        Functions.ReadFileContent("wiki-100k.txt");

        boolean first = true;
        while (true){
            if (!first){
                hcw.print("Play again? [Y]es [N]o:");
                if (Functions.YorNBoolean(hcw.nextString())){
                    game(Functions.RandomWord(Functions.Wordlist));
                }else {
                    hcw.exit();
                    break;
                }
            }
            first = false;

            game(Functions.RandomWord(Functions.Wordlist));
        }
    }
    private static void game (String word){
        while(true){
            PrintLogo();
            hcw.println();
            break;
        }

    }

    private static void PrintLogo (){
        hcw.print(""+
                " _                                             \n" +
                "| |                                            \n" +
                "| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
                "| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
                "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n" +
                "|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
                "                    __/ |                      \n" +
                "                   |___/                       \n" +
                "");
    }
}
