import java.awt.*;

public class main {
    public static HangmanConsoleWindow hcw = new HangmanConsoleWindow();
    private static int DifficultyGlobal;
    private static String word;


    public static void main(String [] args){
        //Makes it so the deveoper can change the text and background color
        hcw.changeTextColor(Color.green);
        ChoseWord();

        boolean first = true;
        while (true){

            //makes it so the "Play again?" question doesn't get printed the first time
            if (!first){
                //asks the user if they want to change the colors on the screen
                IconPack.PrintLogo();
                hcw.println("Do you want to change colors? [Y]es [N]o");
                if (hcw.nextChar()=='y'){
                    Functions.ChangeBackgrundColor();
                    Functions.ChangeTextColor();
                }

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
                //asks the user if they want to change the colors on the screen
                IconPack.PrintLogo();
                hcw.println("Do you want to change colors? [Y]es [N]o");
                if (hcw.nextChar()=='y'){
                    Functions.ChangeBackgrundColor();
                    Functions.ChangeTextColor();
                }

                Game(Functions.RandomWord(Functions.WordList), ChoseDifficulty());
            }

            first = false;
        }
    }


    /**
     * This is the method from where the game is programed
     *
     * @param WordLocal
     * the "WordLocal" variable is the word to be used in the game
     *
     * @param DifficultyLocal
     * The "DifficultyLocal" variable is the difficulty to be used in the game when printing the ascii art
     */
    private static void Game(String WordLocal, int DifficultyLocal){
        int tries=1;
        char GuessedChar;
        char GuessedWordChar[] = new char[WordLocal.length()];

        //Makes the dashes in the char array for showing to the user
        for (int i = 0; i < WordLocal.length(); i++) {
            GuessedWordChar[i] = '-';
        }


        //the actual game
        while (true){
            //prints the ascii art
            IconPack.PrintLogo();
            IconPack.PrintMan(DifficultyGlobal, tries);
            hcw.println();



            //prints the "letters" in the word
            hcw.println();
            hcw.print("Characters: ");
            for (int i = 0; i < GuessedWordChar.length; i++) {
                hcw.print(" " + GuessedWordChar[i] + " ");
            }

            //asks the user for a char and get it from the user
            hcw.println();
            hcw.print("Guess a character: ");
            GuessedChar = hcw.nextChar();

            System.out.println("Guessed char: " + GuessedChar);
            System.out.println("tries: " + tries);

            //Replaces the char at the right place in the "GuessedWordChar" char array
            boolean contains = false;
            for (int i = 0; i < GuessedWordChar.length; i++) {
                if (GuessedChar == WordLocal.charAt(i)) {
                    GuessedWordChar[i] = GuessedChar;
                    contains = true;
                }
            }
            //adds a try if the user gets the char wrong
            if (!contains){
                tries++;
            }


            //exiting part
            //
            // ||   Makes a temporary String that is used for comparing the char array with the word
            // \/
            String temp = "";
            for (int i = 0; i < GuessedWordChar.length; i++) {
                temp  = temp + GuessedWordChar[i];
            }
            // ||   Compares the temporary string with the word or checks if the right amount tries have been achieved
            // \/
            if (WordLocal.equals(temp) || tries >= DifficultyLocal){

                // ||   Prints the ascii art
                // \/
                IconPack.PrintLogo();
                IconPack.PrintMan(DifficultyGlobal, tries);
                hcw.println();

                //  ||  Prints the right response to if the user failed or guessed the right word
                //  \/
                if (tries >= DifficultyLocal) hcw.print("You failed to guess the word");
                else if (WordLocal.equals(temp)) hcw.print("You guessed the right word");
                hcw.println(", it was: " + WordLocal);
                hcw.println("You guessed " + (tries-1) + " character(s) wrong");

                //  ||  This is there to show the user the last ascii art part when he fails/get the right word
                //  \/
                hcw.println("Press any key to continue");
                hcw.nextChar();
                word = WordLocal;
                break;
            }


        }
    }


    /**
     * Asks the user if they want to enter a word manually or if they want a randomized word
     */
    private static void ChoseWord () {
        IconPack.PrintLogo();
        hcw.println("[1] Choose a word manually");
        hcw.println("[2] Choose a word list to randomize from");
        switch (hcw.nextChar()){
            case ('1'):
                hcw.println();
                hcw.println("Enter a word");
                Functions.WordList.add("temp");
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


    /**
     * Asks the user what difficulty they want
     *
     * @return
     * The variable that is being returned is the amount of guesses they can make
     */
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
                //the "DifficultyGlobal" is the "stage" or the amount of ascii art stages to use
                //and the difficulty is the amount of tries
                DifficultyGlobal = 1;
                difficulty = 7;
                break;

            case ('2'):
                //the "DifficultyGlobal" is the "stage" or the amount of ascii art stages to use
                //and the difficulty is the amount of tries
                DifficultyGlobal = 2;
                difficulty = 4;
                break;

            case ('3'):
                //the "DifficultyGlobal" is the "stage" or the amount of ascii art stages to use
                //and the difficulty is the amount of tries
                DifficultyGlobal = 3;
                difficulty = 3;
                break;

            default:
                //the "DifficultyGlobal" is the "stage" or the amount of ascii art stages to use
                //and the difficulty is the amount of tries
                DifficultyGlobal = 1;
                difficulty = 7;
        }
        return difficulty;
    }


    /**
     * Asks the user what file he wants to use to randomize words from
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
