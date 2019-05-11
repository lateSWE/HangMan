import java.awt.*;
import java.util.ArrayList;

public class main {
    public static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
    private static ArrayList<String> ShownWord = new ArrayList();
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
                    tries = Game(Functions.RandomWord(Functions.WordList));
                }else {
                    hcw.exit();
                    break;
                }
            }else {
                tries = Game(Functions.RandomWord(Functions.WordList));
            }


            first = false;
        }
    }



    private static int Game(String WordLocal){
        int tries = 0;
        char guess;
        GameWord(WordLocal);

        while (true){

            hcw.clear();
            IconPack.PrintLogo();


            hcw.println(ShownWord.toString());
            hcw.println("Guess a letter!");
            guess = hcw.nextChar();


            ChangeShownWord(guess);


            if (WordLocal.equals(ShownWord)){
                return tries;
            }
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


    private static void GameWord (String word){
        ShownWord.clear();
        for (int i = 0; i < word.length(); i++) {
            ShownWord.add(" -");
        }
    }

    private static void ChangeShownWord (char input){
        if (!ShownWord.isEmpty()) ShownWord.clear();

    }
}
