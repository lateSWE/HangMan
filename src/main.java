import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class main {
    public static void main(String [] args){
        String filename = new String();
        Scanner input = new Scanner(System.in);


        System.out.println(
                "[1] - Most common words (Slow loading time)\n" +
                "[2] - Only nouns\n" +
                "[3] - Own text file(must end with \".txt\"!");
        int ChoiceOne = input.nextInt();
        switch (ChoiceOne){
            case(1):
                filename = "wiki-100k.txt";
                System.out.println("Loading words and choosing one...");
                break;

            case(2):
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


        System.out.println("\n\n");
        /*for (int i = 0; i < ReadFile(filename).size(); i++) {
            if (ReadFile(filename).get(i).indexOf('#')!=0 && ReadFile(filename).get(i).indexOf('#')!=1) {
                System.out.println("["+(i+1)+"] - " + ReadFile(filename).get(i));
            }
        }*/
        int ChoisePC = (int) RandomWord(ReadFile(filename).size());
        for (int i = 0; i < ReadFile(filename).get(ChoisePC).length(); i++) {
            System.out.print(" _");
        }
        System.out.println();
        System.out.println(ReadFile(filename).get(ChoisePC));
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
