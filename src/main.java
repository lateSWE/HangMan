import java.awt.*;
import java.util.ArrayList;

public class main {
    private static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
    private static ArrayList ShownWord = new ArrayList();

    public static void main(String [] args){
        hcw.changeTextColor(Color.green);

        ChoseWordList();

        boolean first = true;
        while (true){
            int tries = 0;
            if (!first){
                PrintLogo();
                hcw.println("You tried: " + tries + " times");
                hcw.println("Play again? [Y]es [N]o:");
                if (Functions.YorNBoolean(hcw.nextString())){
                    hcw.clear();
                    tries = game(Functions.RandomWord(Functions.Wordlist));
                }else {
                    hcw.exit();
                    break;
                }
            }
            first = false;
        }
    }

    private  static void ChoseWordList (){
        char input;
        String wordlist;

        PrintLogo();
        hcw.println("Chose a word list:");
        hcw.println("[1]  Top 100k words in shakespeare's novels");
        hcw.println("[2]  Top 1k used nouns in the English language");
        hcw.println("[3]  Your own word list(Advanced)");

        input = hcw.nextChar();
        switch (input){
            case(1):
                wordlist = "wiki-100k.txt";
                break;

            case(2):
                wordlist = "nouns.txt";
                break;

            case(3):
                wordlist = hcw.nextString();
                break;

            default:
                wordlist = "nouns.txt";

        }
        if (wordlist.contains(".txt")){
            Functions.ReadFileContent(wordlist);
        }
        hcw.clear();
    }

    private static int game (String word){
        ShownWord.clear();
        int tries = 0;
        boolean GuessedRight = false;

        for (int i = 0; i < word.length(); i++) {
            ShownWord.add("-");
        }
        while(!GuessedRight){
            hcw.clear();
            PrintLogo();

            hcw.println();
            GuessedRight = true;
        }
        return tries;
    }

    private static void ReplaceArrayList(){

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
