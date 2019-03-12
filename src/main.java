import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class main {
    public static void main(String [] args){
        String[] WordList = {("cheese"),("tomato")};
        char letter = 'C';
        Scanner input = new Scanner(System.in);
        System.out.print("Name of file: ");
        String filename = input.nextLine();

        System.out.println(TimeLetterInWord(WordList[0], letter));
        System.out.println();

        for (int i = 0; i < ; i++) {

        }
    }


    private static ArrayList<String> ReadFile(String FileName) {
        ArrayList<String> out = new ArrayList<>();

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
