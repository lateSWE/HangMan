import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class main {
    public static void main(String [] args){
        String filename = new String();
        Scanner input = new Scanner(System.in);
        Boolean run = true;

        while (true) {
            System.out.println(
                    "[1] - Most common words (Slow loading time)\n" +
                            "[2] - Only nouns\n" +
                            "[3] - Own text file(must end with \".txt\"!");
            int ChoiceOne = input.nextInt();
            switch (ChoiceOne) {
                case (1):
                    filename = "wiki-100k.txt";
                    System.out.println("Loading words and choosing one...");
                    break;

                case (2):
                    filename = "nouns.txt";
                    System.out.println("Loading words and choosing one...");
                    break;

                case (3):
                    filename = input.nextLine();
                    System.out.println("Loading words and choosing one");
                    break;
                default:
                    System.out.println("Error!!!! try again\n");
                    break;
            }
            while (run==true) {
                //Randomizing the word  |
                //                      V
                System.out.println("\n\n");
                int ChoisePC = (int) RandomWord(ReadFile(filename).size());
                for (int i = 0; i < ReadFile(filename).get(ChoisePC).length(); i++) {
                    System.out.print(" _");
                }
                System.out.println();
                System.out.println(ReadFile(filename).get(ChoisePC));

                //Putting chosen word into a ArrayList  |
                //                                      V

                ArrayList<String> RandomizedWord = new ArrayList<>();
                for (int i = 0; i < ReadFile(filename).get(ChoisePC).length(); i++) {
                    RandomizedWord.add(Character.toString(ReadFile(filename).get(ChoisePC).charAt(i)));
                }
                //Guessing part  |
                //               V
                char GuessUserChar = 'a';
                while (true) {
                    String GuessUser = input.nextLine();
                    if (GuessUser.length() == 1) {
                        GuessUserChar = GuessUser.charAt(1);
                        break;
                    }
                }
                for (int i = 0; i < ReadFile(filename).get(ChoisePC).length(); i++) {
                    if (GuessUserChar == ReadFile(filename).get(ChoisePC).charAt(i)) {

                    }
                }
            }
        }
    }
    private  static double RandomWord(int i){
        double j = (double) i;
        double out = (Math.random() * j);
        return out;
    }

    private static ArrayList<String> ReadFile(String FileName) {
        ArrayList<String> out = new ArrayList<>();
        ArrayList<String> size_out = new ArrayList<>();
        File file = new File(FileName);
        Scanner FileInput = null;
        try {
            FileInput = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        while (FileInput.hasNextLine()) {
            out.add(FileInput.nextLine());
        }

        return out;
    }

    private static int TimeLetterInWord(String list, char letter){
        int out = 0;



        for (int i = 0; i < list.length(); i++) {
            if (toUpperCase(list.charAt(i)) == toUpperCase(letter)){
                out++;
            }
        }

        return out;
    }


}
