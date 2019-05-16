import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Functions {
    public static ArrayList<String> WordList = new ArrayList<>();

    /**
     * Reads the contents of a ".txt" file to a ArrayList
     *
     * @param FileName
     * Filename to read words from (must be ".txt")
     */
    public static void ReadFileContent(String FileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(FileName));

            int i = 0;
            String line = br.readLine();
            while (line != null) {
                //Gets the right spacing for the printing to the terminal(used for debugging)
                if (i<10){
                    System.out.print("Line: " + i + "       ");
                }else if (i<100){
                    System.out.print("Line: " + i + "      ");
                }else  if (i<1000){
                    System.out.print("Line: " + i + "     ");
                }else if (i<10000){
                    System.out.print("Line: " + i + "    ");
                }else if (i<100000){
                    System.out.print("Line: " + i + "   ");
                }else if (i<1000000){
                    System.out.print("Line: " + i + "  ");
                }else if (i<10000000){
                    System.out.print("Line: " + i + " ");
                }else {
                    System.out.print("Line: " + i + "");
                }

                //checks if it is a comment (it starts with a "#") and prints the right answer to the console
                if (line.charAt(0) != '#') {
                    WordList.add(line);
                    System.out.println("Word found: " + line);
                } else {
                    System.out.println("Comment found: " + line);
                }
                i++;
                line = br.readLine();
            }
            br.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Randomizes a String from a ArrayList
     *
     * @param list
     * Gets a ArrayList to randomize the words from
     *
     * @return
     * returns a random string from the ArrayList
     */
    public static String RandomWord(ArrayList list){
        int random = (int) (Math.random() * list.size());
        return list.get(random).toString();
    }

    /**
     * Asks the user what background color they want in their HangManConsole window
     */
    public static void ChangeBackgrundColor(){
        IconPack.PrintLogo();

        main.hcw.println("Change background color");
        main.hcw.println("[1] - White");
        main.hcw.println("[2] - Black");
        main.hcw.println("[3] - Yellow");
        main.hcw.println("[4] - Green");
        main.hcw.println("[5] - Blue");
        main.hcw.println("[6] - Red");
        main.hcw.println("[7] - Pink");
        main.hcw.println("[8] - Darkgray");
        char choise = main.hcw.nextChar();
        switch (choise){
            case ('1'):
                main.hcw.changeBackgroundColor(Color.white);
                break;

            case ('2'):
                main.hcw.changeBackgroundColor(Color.black);
                break;

            case ('3'):
                main.hcw.changeBackgroundColor(Color.yellow);
                break;

            case ('4'):
                main.hcw.changeBackgroundColor(Color.green);
                break;

            case ('5'):
                main.hcw.changeBackgroundColor(Color.blue);
                break;

            case ('6'):
                main.hcw.changeBackgroundColor(Color.red);
                break;

            case ('7'):
                main.hcw.changeBackgroundColor(Color.pink);
                break;

            case ('8'):
                main.hcw.changeBackgroundColor(Color.darkGray);
                break;

            default:
                main.hcw.changeBackgroundColor(Color.black);
        }
    }

    /**
     * Asks the user what text color they want in their HangManConsole window
     */
    public static void ChangeTextColor() {
        IconPack.PrintLogo();

        main.hcw.println("Change text color");
        main.hcw.println("[1] - White");
        main.hcw.println("[2] - Black");
        main.hcw.println("[3] - Yellow");
        main.hcw.println("[4] - Green");
        main.hcw.println("[5] - Blue");
        main.hcw.println("[6] - Red");
        main.hcw.println("[7] - Pink");
        main.hcw.println("[8] - Darkgray");
        char choise = main.hcw.nextChar();
        switch (choise) {
            case ('1'):
                main.hcw.changeTextColor(Color.white);
                break;
            case ('2'):
                main.hcw.changeTextColor(Color.black);
                break;

            case ('3'):
                main.hcw.changeTextColor(Color.yellow);
                break;

            case ('4'):
                main.hcw.changeTextColor(Color.green);
                break;

            case ('5'):
                main.hcw.changeTextColor(Color.blue);
                break;

            case ('6'):
                main.hcw.changeTextColor(Color.red);
                break;

            case ('7'):
                main.hcw.changeTextColor(Color.pink);
                break;

            case ('8'):
                main.hcw.changeTextColor(Color.darkGray);
                break;

            default:
            main.hcw.changeTextColor(Color.green);
            }
    }
}
