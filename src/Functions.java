import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Functions {
    public static ArrayList<java.lang.String> WordList = new ArrayList<String>();

    /**
     * FileName is the file name to load the words from
     * @param FileName Filename to read words from (must be ".txt")
     */
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

    public static String RandomWord(ArrayList list){
        int random = (int) (Math.random() * list.size());
        return list.get(random).toString();
    }
}
