
import java.util.Scanner;

public class Menu {
    static Scanner sc = new Scanner(System.in);

    private static void printFixture() {

    }

    private static void printTournaments() {

    }

    private static void showStatistics() {
        showSecondaryMenu();
    }

    public static void showPrimaryMenu() {
        System.out.println("*****MENU*****");
        System.out.println("1- Generate Fixture");
        System.out.println("2- Perform Tournaments");
        System.out.println("3- Show Statistics");
        String ans = "";
        boolean isLegal = false;
        while (!isLegal) {
            ans = sc.nextLine();
            if (ans == "1" || ans == "2" || ans == "3") {
                isLegal = true;
            }
        }
        if (ans.equals("1")) {
            printFixture();
        } else if (ans.equals("2")) {
            printTournaments();
        } else if (ans.equals("3")) {
            showStatistics();
        }
    }

    public static void showSecondaryMenu() {
        System.out.println("***** STATISTICS MENU *****");
        System.out.println("1- The country with the highest score");
        System.out.println("2- The athlete with the highest score");
        System.out.println("3- List of matches by date");
        System.out.println("4- List of matches by country");

        String ans = "";
        boolean isLegal = false;
        while (!isLegal) {
            ans = sc.nextLine();
            if (ans == "1" || ans == "2" || ans == "3" || ans == "4") {
                isLegal = true;
            }
        }
        /*
         * todo: add menu options
         */
    }
}