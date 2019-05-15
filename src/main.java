import java.awt.*;

public class main {
    public static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
    private static int DifficultyGlobal;
    private static String word;


    public static void main(String [] args){
        hcw.changeTextColor(Color.green);

        ChoseWord();

        boolean first = true;
        while (true){
            if (!first){
                IconPack.PrintLogo();
                hcw.println("Play again? [Y]es [N]o:");

                if (hcw.nextChar() == 'y'){
                    hcw.println();
                    hcw.println("Do you want the same word? [Y]es [N]o:");
                    if (hcw.nextChar() == 'n'){
                        ChoseWord();
                        Game(Functions.RandomWord(Functions.WordList), ChoseDifficulty());
                    }else {
                        Game(word, ChoseDifficulty());
                    }
                }else {
                    hcw.exit();
                    break;
                }
            }else {
                Game(Functions.RandomWord(Functions.WordList), ChoseDifficulty());
            }


            first = false;
        }
    }



    private static void Game(String WordLocal, int DifficultyLocal){
        int tries=1;
        char GuessedChar = ' ';
        char GuessedWord[] = new char[WordLocal.length()];


        for (int i = 0; i < WordLocal.length(); i++) {
            GuessedWord[i] = '-';
        }

        while (true){
            IconPack.PrintLogo();
            IconPack.PrintMan(DifficultyGlobal, tries);
            hcw.println();



            //prints the "letters" in the word
            hcw.println();
            hcw.print("Characters: ");
            for (int i = 0; i < GuessedWord.length; i++) {
                hcw.print(" " + GuessedWord[i] + " ");
            }

            hcw.println();
            hcw.print("Guess a character: ");
            GuessedChar = hcw.nextChar();

            System.out.println("Guessed char: " + GuessedChar);
            System.out.println("tries: " + tries);

            //Replaces the char at the right place in the "GuessedWord" char array
            boolean contains = false;
            for (int i = 0; i < GuessedWord.length; i++) {
                if (GuessedChar == WordLocal.charAt(i)) {
                    GuessedWord[i] = GuessedChar;
                    contains = true;
                }
            }
            if (!contains){
                tries++;
            }


            //exiting part
            String temp = "";
            for (int i = 0; i < GuessedWord.length; i++) {
                temp  = temp + GuessedWord[i];
            }
            if (WordLocal.equals(temp) || tries >= DifficultyLocal){

                IconPack.PrintLogo();
                IconPack.PrintMan(DifficultyGlobal, tries);
                hcw.println();

                if (tries >= DifficultyLocal) hcw.print("You failed to guess the word");
                else if (WordLocal.equals(temp)) hcw.print("You guessed the right word");
                hcw.println(", it was: " + WordLocal);
                hcw.println("You guessed " + (tries-1) + " character(s) wrong");

                hcw.println("Press any key to continue");
                hcw.nextChar();
                word = WordLocal;
                break;
            }
        }
    }

    private static void ChoseWord () {
        IconPack.PrintLogo();
        hcw.println("[1] Choose a word manually");
        hcw.println("[2] Choose a word list to randomize from");
        switch (hcw.nextChar()){
            case ('1'):
                hcw.println();
                hcw.println("Enter a word");
                Functions.WordList.clear();
                Functions.WordList.add(hcw.nextString());
                hcw.println();
                break;

            case ('2'):
                ChoseWordList();
                break;

            default:
                hcw.println();
                hcw.println("Enter a word");
                Functions.WordList.clear();
                Functions.WordList.add(hcw.nextString());
                hcw.println();
        }
    }

    private static int ChoseDifficulty (){
        char input;
        int difficulty;

        IconPack.PrintLogo();
        hcw.println("Choose difficulty:");
        hcw.println("[1]  Easy difficulty       (6 Wrong guesses)");
        hcw.println("[2]  Medium difficulty     (3 Wrong guesses)");
        hcw.println("[3]  Hard difficulty       (2 Wrong guesses");

        input = hcw.nextChar();
        switch (input){
            case('1'):
                DifficultyGlobal = 1;
                difficulty = 7;
                break;

            case ('2'):
                DifficultyGlobal = 2;
                difficulty = 4;
                break;

            case ('3'):
                DifficultyGlobal = 3;
                difficulty = 3;
                break;

            default:
                DifficultyGlobal = 1;
                difficulty = 7;
        }
        return difficulty;
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
