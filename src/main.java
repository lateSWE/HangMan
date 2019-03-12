import com.sun.source.tree.CaseTree;
import com.sun.source.tree.SwitchTree;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class main {
    public static void main(String [] args){
        String filename = new String();
        Scanner input = new Scanner(System.in);


        System.out.println("[1] - Most common words");
        System.out.println("[2] - Only nouns");
        System.out.println("[3] - Own text file( must end with \".txt\"");
        System.out.print("What mode?: ");
        String choise = input.nextLine();
        switch (choise){
            case("1"):
                filename = "wiki-100k.txt";
                break;

            case("2"):
                filename = "nouns.txt";
                break;

            case ("3"):
                filename = input.nextLine();
                break;;
        }
        System.out.println();
        System.out.println("________________________________\n" +
                "|\t\t\t\t\t\t|");
        for (int i = 0; i < ReadFile(filename).size()-1; i++) {
            if (ReadFile(filename).get(i).indexOf('#')!=0 && ReadFile(filename).get(i).indexOf('#')!=1) {
                System.out.print("|  ");
                System.out.print(ReadFile(filename).get(i));
                System.out.println("\t  |");
            }
        }
        System.out.println("________________________________");
    }


    public static ArrayList<String> ReadFile(String FileName) {
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
