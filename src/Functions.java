import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Functions {
    public static ArrayList<String> Wordlist = new ArrayList<String>();

    public static boolean YorNBoolean (String input) {
        switch (input.length()){
            case (1):
                if (input.toUpperCase().equals("Y")) {
                    return true;
                } else if (input.toUpperCase().equals("N")) {
                    return false;
                } else {
                    System.out.println("Error in \"YorNBoolean\" ID:1");
                    return false;
                }

            default:
                System.out.println("Error in \"YorNBoolean\" ID:2");
                return false;
        }
    }

    public static void ReadFileContent(String FileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(FileName));

            int i = 0;
            String line = br.readLine();
            while (line != null) {
                if (i<10){
                    System.out.print("Line: " + i + "     ");
                }else if (i<100){
                    System.out.print("Line: " + i + "    ");
                }else  if (i<1000){
                    System.out.print("Line: " + i + "   ");
                }else if (i<10000){
                    System.out.print("Line: " + i + "  ");
                }else if (i<100000){
                    System.out.print("Line: " + i + " ");
                }

                Wordlist.add(line);
                System.out.print(Wordlist.get(i) + "  ");

                if (line.charAt(0) != '#') {
                    Wordlist.add(line);
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

    public static String RandomWord(ArrayList list){
        int random = (int) Math.random() * list.size();
        String word = (String) list.get(random);
        return word;
    }

}