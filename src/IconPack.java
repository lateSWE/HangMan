public class IconPack {
    public static void PrintLogo (){
        System.out.println();
        main.hcw.clear();
        System.out.println("HangMan console cleared");
        main.hcw.print(""+
                " _                                             \n" +
                "| |                                            \n" +
                "| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
                "| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
                "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n" +
                "|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
                "                    __/ |                      \n" +
                "                   |___/                       \n" +
                "");
        System.out.println("HangMan logo printed");
    }

    public static void PrintMan (int difficulty, int stage){
        System.out.println();
        switch (difficulty) {

            case(1):
                switch (stage) {
                    case (1):
                        main.hcw.print("" +
                                "|              \n" +
                                "|              \n" +
                                "|              \n" +
                                "|             \n" +
                                "|              \n" +
                                "|             \n" +
                                "|              \n" +
                                "|              \n" +
                                "|              \n");
                        System.out.println("First stage of Hang Man Figure");
                        break;

                    case (2):
                        main.hcw.print("" +
                                "|              \n" +
                                "|              \n" +
                                "|             \n" +
                                "|             \n" +
                                "|              \n" +
                                "|             \n" +
                                "|_________     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        System.out.println("Second stage of Hang Man Figure");
                        break;

                    case (3):
                        main.hcw.print("" +
                                "|              \n" +
                                "|  |           \n" +
                                "|  |           \n" +
                                "|  |          \n" +
                                "|  |           \n" +
                                "|  |          \n" +
                                "|__|______     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        System.out.println("Third stage of Hang Man Figure");
                        break;

                    case (4):
                        main.hcw.print("" +
                                "|   ____       \n" +
                                "|  |           \n" +
                                "|  |           \n" +
                                "|  |          \n" +
                                "|  |           \n" +
                                "|  |          \n" +
                                "|__|______     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        System.out.println("Forth stage of Hang Man Figure");
                        break;

                    case (5):
                        main.hcw.print("" +
                                "|   ____       \n" +
                                "|  | /         \n" +
                                "|  |/          \n" +
                                "|  |           \n" +
                                "|  |           \n" +
                                "|  |           \n" +
                                "|__|______     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        System.out.println("Fifth stage of Hang Man Figure");
                        break;

                    case (6):
                        main.hcw.print("" +
                                "|   ____       \n" +
                                "|  | /  |      \n" +
                                "|  |/          \n" +
                                "|  |          \n" +
                                "|  |           \n" +
                                "|  |          \n" +
                                "|__|______     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        System.out.println("Sixth stage of Hang Man Figure");
                        break;

                    case (7):
                        main.hcw.print("" +
                                "|   ____       \n" +
                                "|  | /  |      \n" +
                                "|  |/   O      \n" +
                                "|  |   /|\\    \n" +
                                "|  |    |      \n" +
                                "|  |   / \\    \n" +
                                "|__|______     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        System.out.println("Seventh stage of Hang Man Figure");
                        break;
                }
                break;

            case (2):
                switch (stage) {
                    case (1):
                        main.hcw.print("" +
                                "|              \n" +
                                "|              \n" +
                                "|              \n" +
                                "|             \n" +
                                "|              \n" +
                                "|             \n" +
                                "|              \n" +
                                "|              \n" +
                                "|              \n");
                        System.out.println("First stage of Hang Man Figure");
                        break;

                    case (2):
                        main.hcw.print("" +
                                "|              \n" +
                                "|              \n" +
                                "|             \n" +
                                "|             \n" +
                                "|              \n" +
                                "|             \n" +
                                "|_________     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        System.out.println("Second stage of Hang Man Figure");
                        break;

                    case (3):
                        main.hcw.print("" +
                                "|   ____       \n" +
                                "|  | /         \n" +
                                "|  |/          \n" +
                                "|  |           \n" +
                                "|  |           \n" +
                                "|  |           \n" +
                                "|__|______     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        System.out.println("Third stage of Hang Man Figure");
                        break;

                    case (4):
                        main.hcw.print("" +
                                "|   ____       \n" +
                                "|  | /  |      \n" +
                                "|  |/   O      \n" +
                                "|  |   /|\\    \n" +
                                "|  |    |       \n" +
                                "|  |   / \\     \n" +
                                "|__|______     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        System.out.println("Forth stage of Hang Man Figure");
                        break;
                }
                break;

            case (3):
                switch (stage){
                    case (1):
                        main.hcw.print("" +
                                "|              \n" +
                                "|              \n" +
                                "|              \n" +
                                "|             \n" +
                                "|              \n" +
                                "|             \n" +
                                "|              \n" +
                                "|              \n" +
                                "|              \n");
                        break;

                    case (2):
                        main.hcw.print("" +
                                "|   ____       \n" +
                                "|  | /         \n" +
                                "|  |/          \n" +
                                "|  |           \n" +
                                "|  |           \n" +
                                "|  |           \n" +
                                "|__|______     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        break;

                    case (3):
                        main.hcw.print("" +
                                "|   ____       \n" +
                                "|  | /  |      \n" +
                                "|  |/   O      \n" +
                                "|  |   /|\\    \n" +
                                "|  |    |      \n" +
                                "|  |   / \\    \n" +
                                "|__|______     \n" +
                                "||      |___   \n" +
                                "||_________|   \n");
                        break;

                }
                break;

        }
    }
}
