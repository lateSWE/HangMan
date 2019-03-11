import java.io.*;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class main {
    public static void main(String [] args){
        String[] WordList = {("cheese"),("tomato")};
        char letter = 'C';
        Scanner input = new Scanner(System.in);
        System.out.print("Name of file: ");
        String filename = input.toString();

        System.out.println(TimeLetterInWord(WordList[0], letter));
        System.out.println(ReadFile(filename));
    }


    private static String ReadFile(String FileName) {
        String out = "";

        File file = new File(FileName);
        Scanner FileInput = new Scanner((file+".txt"));

        while (FileInput.hasNextLine()) {
            String NewOut = FileInput.nextLine();
            out = out + NewOut;
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
