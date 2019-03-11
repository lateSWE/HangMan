import java.io.*;
import java.util.Scanner;

import static java.lang.Character.toUpperCase;

public class main {
    public static void main(String[] args){
        String[] WordList = {("cheese"),("tomato")};
        char letter = 'C';
        String filename = "";

        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.print("Name of file(must be a \".txt\" file: ");
            filename = input.toString();
            if((filename.charAt(-1) == 't') && (filename.charAt(-2) == 'x') && (filename.charAt(-3) == 't') && (filename.charAt(-4) == '.')){
                break;
            }
            System.out.println("Error! must end with \".txt\"!");
        }
        String out = "";
        for (int i = 0; i < filename.length()-4; i++) {
            char j = filename.charAt(i);
            out = out + j;
        }

        System.out.println(TimeLetterInWord(WordList[0], letter));
        System.out.println(ReadFile(out));
    }


    private static String ReadFile(String FileName) {
        String out = "";

        File file = new File(FileName);
        Scanner FileInput = new Scanner(FileName);

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
