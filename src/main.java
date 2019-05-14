import java.awt.*;
import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;

public class main {
    public static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
    private static String Word;
    private static int difficulty;


    public static void main(String [] args){
        hcw.changeTextColor(Color.green);


        ChoseWordList();


        int tries = 0;
        boolean first = true;
        while (true){
            if (!first){
                IconPack.PrintLogo();
                hcw.println("The word was \"" + Word + "\"");
                hcw.println("You tried: " + tries + " times");
                hcw.println("Play again? [Y]es [N]o:");

                if (hcw.nextChar() == 'y'){
                    hcw.clear();
                    tries = Game(Functions.RandomWord(Functions.WordList), difficulty);
                }else {
                    hcw.exit();
                    break;
                }
            }else {
                tries = Game(Functions.RandomWord(Functions.WordList), difficulty);
            }


            first = false;
        }
    }



    private static int Game(String WordLocal, int DifficultyLocal){
        int tries=0;
        String GuessedWord = "";


        if (WordLocal.contains(GuessedWord)){
            return tries;
        }
    }

    private static void ChoseDifficulty (){
        char input;
        hcw.println("Choose difficulty:");
        hcw.println("[1]  Easy difficulty");
        hcw.println("[2]  Medium difficulty");
        hcw.println("[3]  Hard difficulty");

        input = hcw.nextChar();
        switch (input){
            case('1'):
                difficulty = 1;
                break;

            case ('2'):
                difficulty = 2;
                break;

            case ('3'):
                difficulty = 3;
                break;

            default:
                difficulty = 2;
        }
    }


    /**
     * Asks the user what file he wants to use
     */
    private static void ChoseWordList (){
        char input;
        String wordlist;

        IconPack.PrintLogo();
        hcw.println("Chose a word list:");
        hcw.println("[1]  Top 100k words in shakespeare's novels");
        hcw.println("[2]  Top 1k used nouns in the English language");
        hcw.println("[3]  Your own word list(Advanced)");

        input = hcw.nextChar();
        switch (input){
            case('1'):
                wordlist = "wiki-100k.txt";
                break;

            case('2'):
                wordlist = "nouns.txt";
                break;

            case('3'):
                hcw.println();
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
}
